package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.domain.Rereply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RereplyRepository extends JpaRepository<Rereply, Long> {
    List<Rereply> findByBoardAndParentIsNull(Board board);
    List<Rereply> findByParentId(Long parentId);
}
