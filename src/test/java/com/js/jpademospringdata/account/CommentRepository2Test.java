package com.js.jpademospringdata.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepository2Test {
    @Autowired
    CommentRepository2 repository;

    @Test
    public void count() {
        // given
        Comment comment = new Comment();
        comment.setComment("hello comment");
        final Comment save = repository.save(comment);

        // when
        final long count = repository.count();

        //then
        assertThat(count).isEqualTo(1);
    }
}