package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.domain.Rereply;
import com.lyj.bootakey.dto.RereplyDTO;
import com.lyj.bootakey.repository.BoardRepository;
import com.lyj.bootakey.repository.RereplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class RereplyServiceImpl implements RereplyService {
    private final RereplyRepository replyRepository;
    private final BoardRepository boardRepository;


    @Override
    public Rereply createRereply(Long boardId, RereplyDTO rereplyDTO) {
        Board board=boardRepository.findById(boardId)
                .orElseThrow(()-> new RuntimeException("Post not found"));

        Rereply rereply=new Rereply();
        rereply.setContent(rereplyDTO.getContent());
        rereply.setWriter(rereplyDTO.getWriter());
        rereply.setBoard(board);

        if (rereplyDTO.getParentId()!= null) {
            Rereply parentRereply = replyRepository.findById(Long.valueOf(rereplyDTO.getParentId()))
                    .orElseThrow(() -> new IllegalArgumentException("Parent comment not found"));
            rereply.setParent(parentRereply);
        }

        return replyRepository.save(rereply);
    }

    @Override
    public List<Rereply> getRereplies(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        //log.info("aaaaaaaaaaaaaaaaa"+commentRepository.findByBoardAndParentIsNull());

        return replyRepository.findByBoardAndParentIsNull(board);
    }

    @Override
    public void deleteRereply(Long id) {
        replyRepository.deleteById(id);
    }
}
