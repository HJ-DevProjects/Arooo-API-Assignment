package com.arooo.webapi.like.service;

import com.arooo.webapi.content.entity.ContentEntity;
import com.arooo.webapi.content.repository.ContentRepository;
import com.arooo.webapi.like.dto.LikeRequest;
import com.arooo.webapi.like.dto.LikeResponse;
import com.arooo.webapi.like.entity.LikeEntity;
import com.arooo.webapi.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final ContentRepository contentRepository;

    public LikeResponse incrementLike(LikeRequest likeRequest) {
        ContentEntity contentEntity = contentRepository.findById(likeRequest.getContentId())
                                                       .orElseThrow();
        // LikeEntity 생성
        LikeEntity likeEntity = LikeEntity.builder()
                                          .content(contentEntity)
                                          .build();

        // Content의 좋아요 수 필드 증가 후 DB에 저장
        contentEntity.incrementLikeCount();
        contentRepository.save(contentEntity);

        likeRepository.save(likeEntity);
        LikeResponse likeResponse = LikeResponse.builder().likes(contentEntity.getLikes()).build();
        return likeResponse;
    }
}