package com.js.jpademospringdata.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

public interface CommentRepository2 extends MyRepository<Comment, Long> {
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThanOrderByLikeCountDesc(String keyword, int likeCount);
    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThanOrderByLikeCountAsc(String keyword, int likeCount);
    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);
    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
