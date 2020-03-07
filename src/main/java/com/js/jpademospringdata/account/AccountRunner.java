package com.js.jpademospringdata.account;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class AccountRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("JS2");
        account.setPassword("jpa2");

        Study study = new Study();
        study.setName("JPA");

        account.addStudy(study);
//        account.getStudy().add(study);
//        study.setOwner(account);

        //hibernate
        final Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
