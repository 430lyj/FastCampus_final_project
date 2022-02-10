package com.fastcampus.board.domain;

import com.fastcampus.board.dto.PostDto;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "BOARD")
@Getter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String writer;

    @NotEmpty
    private String content;

    private int cnt;

    @CreationTimestamp
    private LocalDateTime reg_date;

    /**
     * 포스트 생성
     */
    public void createPost(String title, String writer, String content, int cnt){
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.cnt = cnt;
    }

    /**
     * 포스트 업데이트
     */
    public void updatePost(String title, String writer, String content){
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    /**
     * cnt += 1
     */
    public void upCnt(){
        this.cnt ++;
    }
}
