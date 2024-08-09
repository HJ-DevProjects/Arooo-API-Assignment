package com.arooo.webapi.like.controller;

import com.arooo.webapi.like.dto.LikeRequest;
import com.arooo.webapi.like.dto.LikeResponse;
import com.arooo.webapi.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/library/content/{contentId}/like")
    public LikeResponse incrementLike(LikeRequest likeRequest) {
        LikeResponse likeResponse = likeService.incrementLike(likeRequest);
        return likeResponse;
    }
}