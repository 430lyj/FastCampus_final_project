package com.fastcampus.board.domain;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "BOARD")
@Getter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "seq")
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String writer;

    @NotEmpty
    private String content;

    private int cnt;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Timestamp reg_date;
}
