package com.jwelyl.spring_webservice.web.dto;

import com.jwelyl.spring_webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSavedRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSavedRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
