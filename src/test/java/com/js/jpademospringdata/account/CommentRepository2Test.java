package com.js.jpademospringdata.account;

import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
    public void crud() {
        // given
        Comment comment = new Comment();
        comment.setComment("Hello Commnet");
        comment.setLikeCount(100);

        Comment comment1 = new Comment();
        comment1.setComment("Hello Commnet2");
        comment1.setLikeCount(50);

        //when
        final Comment newComment = repository.save(comment);
        repository.save(comment1);

        //then
        final List<Comment> list = repository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThanOrderByLikeCountDesc("hello", 10);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0).getComment()).isEqualTo("Hello Commnet");
        assertThat(list.get(1).getComment()).isEqualTo("Hello Commnet2");
    }

    @Test
    public void crudPage() {
        // given
        this.save("Hello spring Comment", 100);
        this.save("Hello SPRING comment", 50);
        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "likeCount"));

        //then
        final Page<Comment> commentPage = repository.findByCommentContainsIgnoreCase("spring", pageRequest);

        assertThat(commentPage.getTotalPages()).isEqualTo(1);
        assertThat(commentPage.getNumberOfElements()).isEqualTo(2);
    }

    private Comment save(String comment, int likeCount) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        return repository.save(newComment);
    }
}