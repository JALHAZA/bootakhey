package com.lyj.bootakey.repository;

import com.lyj.bootakey.domain.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {

}
