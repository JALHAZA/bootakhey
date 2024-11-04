package com.lyj.bootakey.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "tbl_board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String title;
    private String writer;
    private String content;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "regdate")
    private Date regdate;
    @ColumnDefault("0")
    private Long hitcount;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = true)
    @JoinColumn(name = "user_id")
    private User user;

//    public void updateHitcount() {
//        this.hitcount =this.hitcount+1;
//    }

    @PrePersist
    public void prePersist() {
        this.hitcount=this.hitcount==null?0:this.hitcount;
    }
}
