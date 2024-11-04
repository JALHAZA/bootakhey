package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.Request;
import com.lyj.bootakey.dto.RequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query("SELECT new com.lyj.bootakey.dto.RequestDTO(r.content, u.username, p.pcontent) " +
            "FROM Request r " +
            "JOIN r.user u " +
            "JOIN r.post p")
    List<RequestDTO> findAllRequestWithUserAndPostContent();
}
