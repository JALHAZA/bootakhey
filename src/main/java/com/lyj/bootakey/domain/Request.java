package com.lyj.bootakey.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;
import java.util.Date;


@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="post_id")
    private Post post;

    @Column(nullable = false,length = 2000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "request_status_id")
    private RequestStatus requestStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern ="yyyy-MM-dd H:mm:ss")
    private Date regDate;





}
