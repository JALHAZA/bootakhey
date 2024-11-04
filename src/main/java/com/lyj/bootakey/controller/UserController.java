package com.lyj.bootakey.controller;

import com.lyj.bootakey.domain.User;
import com.lyj.bootakey.repository.UserRepository;
import com.lyj.bootakey.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailService userDetailService;

    @GetMapping("user")
    public String userList(Model model) {
        List<User> users = userDetailService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("")
    public String index() {return "index";}

    @GetMapping("/join")
    public void join(){
    }

    @GetMapping("/login")
    public void login(){
    }

    @PostMapping("/register")
    public String register(User user) {
        System.out.println("회원가입 진행 : " + user);
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:/";
    }



}
