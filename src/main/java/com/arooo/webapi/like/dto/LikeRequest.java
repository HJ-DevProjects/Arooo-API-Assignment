package com.arooo.webapi.like.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeRequest {
    private Long contentId;

    @Builder
    public LikeRequest(Long contentId) {
        this.contentId = contentId;
    }
}
