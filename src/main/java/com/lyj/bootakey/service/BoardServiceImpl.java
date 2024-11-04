package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.domain.User;
import com.lyj.bootakey.repository.BoardRepository;
import com.lyj.bootakey.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void insert(Board board, User user) {
        User manageUser = userRepository.findById(user.getUserId())
                .orElseThrow(()->new IllegalArgumentException("User Not Found"));

        board.setUser(manageUser);
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long num) {
        Board board = boardRepository.findById(num).get();
        board.setHitcount(board.getHitcount()+1);
        boardRepository.save(board);
//        board.prePersist();
        return board;
    }

    @Override
    public void update(Board board) {
        Board oldBoard=boardRepository.findById(board.getNum()).get();
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());
        boardRepository.save(oldBoard);
    }

    @Override
    public void delete(Long num) {
        boardRepository.deleteById(num);
    }
}
