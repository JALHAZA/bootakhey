package com.lyj.bootakey.service;

import com.lyj.bootakey.config.auth.PrincipalDetails;
import com.lyj.bootakey.domain.User;
import com.lyj.bootakey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        User user = userRepository.findByUsername(username);

        if (user == null) return null;

        PrincipalDetails principalDetails = new PrincipalDetails(user);
        log.info("loadUserByUsername");
        return principalDetails;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
