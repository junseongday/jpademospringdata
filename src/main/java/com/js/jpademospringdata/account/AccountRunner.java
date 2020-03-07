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

//        Post post = new Post();
//        post.setTitle("JPA 언제 보나?");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어요");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("빨리 보고 싶어요");
//        post.addComment(comment1);

        //hibernate
        final Session session = entityManager.unwrap(Session.class);
//        session.save(post);
        final Post post = session.get(Post.class, 1l);
        System.out.println("=================================");
        System.out.println(post.getTitle());

        post.getComment().forEach(s -> {
            System.out.println("==========================");
            System.out.println(s.getComment());
        });

//        final Comment comment = session.get(Comment.class, 2l);
//        System.out.println("=================================");
//        System.out.println(comment.toString());
    }
}
