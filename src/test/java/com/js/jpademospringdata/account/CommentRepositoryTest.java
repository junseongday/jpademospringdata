package com.js.jpademospringdata.account;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {


    @Autowired
    CommentRepository repository;

    @Test
    void save() {
        // given
        Comment comment = new Comment();
        comment.setComment("Hello Commnet");

        // when
        final Comment newComment = repository.save(comment);

        // then
        assertThat(newComment.getId()).isNotNull();

        // when
        final List<Comment> list = repository.findAll();

        // then
        assertThat(list.size()).isEqualTo(1);
    }
}