package com.lyj.bootakey.dto;

public class RequestDTO {
    private String username;
    private String pcontent;
    private String content;

    public RequestDTO(String username, String pcontent, String content) {
        this.username = username;
        this.pcontent = pcontent;
        this.content = content;
    }
}
