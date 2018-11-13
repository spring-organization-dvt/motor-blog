package com.thinkpad.repository.impl;

import com.thinkpad.model.MotorBike;
import com.thinkpad.repository.MotorBikeRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MotorBikeRepositoryImpl implements MotorBikeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MotorBike> findAll() {
        TypedQuery<MotorBike> query = entityManager.createQuery("select m from MotorBike m", MotorBike.class);
        return query.getResultList();
    }

    @Override
    public MotorBike findById(Integer id) {
        TypedQuery<MotorBike> query = entityManager.createQuery("select m from MotorBike m where m.id=:id", MotorBike.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(MotorBike model) {
        if (model.getId() != null) {
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Integer id) {
        MotorBike motorBike = findById(id);
        if (motorBike.getId() != null) {
            entityManager.remove(motorBike);
        }
    }

}
