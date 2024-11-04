package com.lyj.bootakey.controller;


import com.lyj.bootakey.domain.Post;
import com.lyj.bootakey.domain.Request;
import com.lyj.bootakey.domain.RequestStatus;
import com.lyj.bootakey.domain.User;
import com.lyj.bootakey.repository.BoardRepository;
import com.lyj.bootakey.repository.PostRepository;
import com.lyj.bootakey.repository.RequestRepository;
import com.lyj.bootakey.repository.UserRepository;
import com.lyj.bootakey.service.RequestService;
import groovy.util.logging.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import com.lyj.bootakey.repository.RequestStatusRepository;

import java.util.Date;

@SpringBootTest
@Transactional
@Rollback(false)
@Log4j2
public class RequestControllerTest {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private RequestController requestController;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RequestStatusRepository requestStatusRepository;


    @Test
    public void testApplyForm() {

    User user = userRepository.findById(1L).orElseGet(() -> {
        User newUser = new User();
        newUser.setUsername("testUser");
        newUser.setPassword("password");
        newUser.setEmail("abc@naver.com");
        newUser.setRole("USER");
        return userRepository.save(newUser);
    });

    Post post = postRepository.findById(1L).orElseGet(() -> {
        Post newPost = new Post();
        newPost.setTitle("Test Title");
        newPost.setPcontent("Test Content");
        return postRepository.save(newPost);
    });

        RequestStatus status = requestStatusRepository.findById(1L).orElseGet(() -> {
            RequestStatus newStatus = new RequestStatus();
            newStatus.setStatus("진행중");
            return requestStatusRepository.save(newStatus);
        });

        Request request = new Request();
        request.setContent("테스트참여글6");
        request.setRegDate(new Date());
        request.setUser(user);
        request.setPost(post);
        request.setRequestStatus(status);
        requestService.saveRequest(request);

    }

}
