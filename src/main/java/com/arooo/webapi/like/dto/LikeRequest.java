package com.arooo.webapi.like.dto;

import lombok.Getter;

@Getter
public class LikeRequest {
    private Long contentId;

    public LikeRequest(Long contentId) {
        this.contentId = contentId;
    }
}
