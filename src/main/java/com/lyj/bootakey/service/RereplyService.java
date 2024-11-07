package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Rereply;
import com.lyj.bootakey.dto.RereplyDTO;

import java.util.List;

public interface RereplyService {
    public Rereply createRereply(Long boardId, RereplyDTO rereplyDTO);

    public List<Rereply>getRereplies(Long boardId);
    public void deleteRereply(Long id);

}
