package com.thinkpad.repository.impl;

import com.thinkpad.model.MotorBike;
import com.thinkpad.repository.MotorBikeRepository;

import javax.persistence.EntityManager;
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

}
