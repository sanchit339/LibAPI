package com.bytecodevelocity.service;

import com.bytecodevelocity.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentDao {
    @PersistenceContext // this will manage all the transaction and roll back if necessary
    EntityManager em;
    public void insertStudent( Student stu){
        em.persist(stu);
    }
}
