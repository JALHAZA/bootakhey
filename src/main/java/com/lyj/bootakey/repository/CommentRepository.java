package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
