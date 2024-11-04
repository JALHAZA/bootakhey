package com.lyj.bootakey.service;

import com.lyj.bootakey.domain.Request;
import com.lyj.bootakey.dto.RequestDTO;
import com.lyj.bootakey.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Override
    public List<RequestDTO> getRequests(){
        return requestRepository.findAllRequestWithUserAndPostContent();
    }
    @Override
    public void saveRequest(Request request){
        requestRepository.save(request);
    }
}
