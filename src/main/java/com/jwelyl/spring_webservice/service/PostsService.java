package com.jwelyl.spring_webservice.service;

import com.jwelyl.spring_webservice.domain.posts.PostsRepository;
import com.jwelyl.spring_webservice.web.dto.PostsSavedRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSavedRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
