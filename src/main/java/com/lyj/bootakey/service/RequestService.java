package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Request;
import com.lyj.bootakey.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    List<RequestDTO> getRequests();
    void saveRequest(Request request);
}
