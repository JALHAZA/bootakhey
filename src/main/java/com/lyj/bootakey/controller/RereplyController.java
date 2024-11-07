package com.lyj.bootakey.controller;

import com.lyj.bootakey.domain.Rereply;
import com.lyj.bootakey.dto.RereplyDTO;
import com.lyj.bootakey.service.RereplyService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rereplies")
@Log4j2
@RequiredArgsConstructor
public class RereplyController {
    private final RereplyService rereplyService;

    @PostMapping("/{boardId}")
    public ResponseEntity<Long> createRereply(
            @PathVariable Long boardId ,
            @RequestBody RereplyDTO rereplyDTO) {
        Rereply rereply = rereplyService.createRereply(boardId,rereplyDTO);
        return ResponseEntity.ok(rereply.getId());
    }
    @GetMapping("/{boardId}")
    public ResponseEntity<List<Rereply>> getRereplies(@PathVariable Long boardId) {
        List<Rereply> rereplies=rereplyService.getRereplies(boardId);
        return ResponseEntity.ok(rereplies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteRereply(@PathVariable Long id) {
        rereplyService.deleteRereply(id);
        return ResponseEntity.ok(id);
    }

}
