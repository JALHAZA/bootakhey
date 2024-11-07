package com.lyj.bootakey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lyj.bootakey.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}
