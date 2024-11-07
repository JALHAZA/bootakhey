package com.lyj.bootakey.controller;

import com.lyj.bootakey.config.auth.PrincipalDetails;
import com.lyj.bootakey.domain.Board;
import com.lyj.bootakey.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/request")
    public String request(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        return "/board/request";
    }

    @GetMapping("/report")
    public String reportPage(){
        return "/board/request";
    }

    @GetMapping("insert")
    public String insert() {
        return "/board/register";
    }

    @PostMapping("/insert")
    public String insert(Board board,
                         @AuthenticationPrincipal PrincipalDetails principal) {
//        board.setWriter(principal.getUsername());
        boardService.insert(board,principal.getUser() );
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("num") Long num, Model model) {
        model.addAttribute("board",boardService.findById(num));
        return "/board/view";
    }
    @GetMapping("/modify")
    public String update(@RequestParam Long num, Model model) {
        model.addAttribute("board", boardService.findById(num));
        return "/board/modify";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("lists",boardService.list());
        return "/board/list";
    }

    @GetMapping("/update")
    public String update(Board board) {
        boardService.update(board);
        return "redirect:/board/view?num="+board.getNum();
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long num) {
        boardService.delete(num);
        return "redirect:/board/list";
    }
}
