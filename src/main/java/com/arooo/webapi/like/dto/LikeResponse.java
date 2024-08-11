package com.arooo.webapi.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LikeResponse {
    private Integer likes;

    @Builder
    public LikeResponse(Integer likes) {
        this.likes = likes;
    }
}
