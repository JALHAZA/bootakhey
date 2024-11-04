package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
