package com.example.spring_boot_introduction_spring_boot.chpater07;

import javax.persistence.EntityManager;
import java.util.List;

public class MsgDataDaoImpl implements MsgDataDao<MsgData> {

    private EntityManager entityManager;

    public MsgDataDaoImpl() {
        super();
    }

    public MsgDataDaoImpl(EntityManager manager) {
        entityManager = manager;
    }

    @Override
    public List<MsgData> getAll() {
        return entityManager
                .createQuery("from MsgData")
                .getResultList();
    }

    @Override
    public MsgData findById(long id) {
        return (MsgData) entityManager
                .createQuery("from MsgData where id = " + id)
                .getSingleResult();
    }
}
