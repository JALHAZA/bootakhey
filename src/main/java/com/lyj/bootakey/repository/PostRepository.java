package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
}
