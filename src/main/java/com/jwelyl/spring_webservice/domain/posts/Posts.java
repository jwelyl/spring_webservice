package com.jwelyl.spring_webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //  기본 생성자 생성
@Entity             //  table과 링크될 클래스
public class Posts {
    @Id //  Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  PK 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private  String author;

    @Builder    //  빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
