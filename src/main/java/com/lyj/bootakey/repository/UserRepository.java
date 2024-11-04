package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    //select * from tbl_user where username="abcd"; 동일하다
}
