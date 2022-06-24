package com.example.pagedemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ArticleVO {

    private Integer article_no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;
}
