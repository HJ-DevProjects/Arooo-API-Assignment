package com.arooo.webapi.like.dto;

import lombok.Builder;

public class LikeResponse {
    private Integer likeCount;

    @Builder
    public LikeResponse(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
