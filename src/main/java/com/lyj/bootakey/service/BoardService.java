package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BoardService {
    void insert(Board board, User user);
    public List<Board> list();
    public Board findById(Long num);
    public void update(Board board);
    public void delete(Long num);
}
