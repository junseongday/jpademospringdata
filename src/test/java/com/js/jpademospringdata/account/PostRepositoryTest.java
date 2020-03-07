package com.js.jpademospringdata.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        // given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertThat(post.getId()).isNull();

        // when
        final Post newPost = postRepository.save(post);

        // then
        assertThat(newPost.getId()).isNotNull();

        //when
        final List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        // when
        final Page<Post> postPage = postRepository.findAll(PageRequest.of(0, 10));

        // then
        assertThat(postPage.getTotalElements()).isEqualTo(1);
        assertThat(postPage.getTotalPages()).isEqualTo(1);
        assertThat(postPage.getSize()).isEqualTo(10);
        assertThat(postPage.getNumberOfElements()).isEqualTo(1);

        //when
        final Page<Post> page2 = postRepository.findByTitleContains("spring", PageRequest.of(0,10));
        // then
        assertThat(page2.getTotalElements()).isEqualTo(1);
        assertThat(page2.getTotalPages()).isEqualTo(1);
        assertThat(page2.getSize()).isEqualTo(10);
        assertThat(page2.getNumberOfElements()).isEqualTo(1);

        // when
        final int count = postRepository.countByTitleContains("spring");

        // then
        assertThat(count).isEqualTo(1);

    }
}