package com.js.jpademospringdata.account;

import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void findById() {
        final Optional<Comment> byId = repository.findById(100l);
        assertThat(byId).isEmpty();
    }

    @Test
    public void save() {
        repository.save(null);
    }
}