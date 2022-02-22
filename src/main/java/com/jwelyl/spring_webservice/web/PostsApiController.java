package com.jwelyl.spring_webservice.web;

import com.jwelyl.spring_webservice.service.PostsService;
import com.jwelyl.spring_webservice.web.dto.PostsSavedRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSavedRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
