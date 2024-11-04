package com.lyj.bootakey.controller;


import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.domain.Request;
import com.lyj.bootakey.dto.RequestDTO;
import com.lyj.bootakey.service.BoardService;
import com.lyj.bootakey.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    private final BoardService boardService;

    @GetMapping("/apply")
    public String applyForm(@RequestParam("boardId")Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "request/apply";
    }

    @PostMapping("/insert")
    public String saveRequest(Request request) {
        requestService.saveRequest(request);
        return "redirect:/request";
    }
    @GetMapping("/list")
    public List<RequestDTO> getRequests() {
        return requestService.getRequests();
    }
}

