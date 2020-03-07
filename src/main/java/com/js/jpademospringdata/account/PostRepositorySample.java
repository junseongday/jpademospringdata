package com.js.jpademospringdata.account;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// 옛날방식
@Transactional
@Repository
public class PostRepositorySample {
    @PersistenceContext
    EntityManager entityManager;

    public void add(Post post) {
        entityManager.persist(post);
    }

    public void remove(Post post) {
        entityManager.remove(post);
    }

    public List<Post> findAll() {
        return entityManager.createQuery("select p from Post as p", Post.class).getResultList();
    }
}
