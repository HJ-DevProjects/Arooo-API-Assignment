package com.arooo.webapi.content.dto;

import com.arooo.webapi.content.entity.ContentEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContentResponse {
    private String title;
    private String mainText;
    private Integer likeCount;

    @Builder
    public ContentResponse(String title, String mainText, Integer likeCount) {
        this.title = title;
        this.mainText = mainText;
        this.likeCount = likeCount;
    }

    public ContentResponse toDto (ContentEntity contentEntity) {
        return ContentResponse.builder()
                              .title(contentEntity.getTitle())
                              .mainText(contentEntity.getMainText())
                              .likeCount(contentEntity.getLikeCount())
                              .build();
    }

    public static List<ContentResponse> toDtoList (List<ContentEntity> contentEntityList) {
        return contentEntityList.stream()
                                .map(content -> ContentResponse.builder()
                                                               .title(content.getTitle())
                                                               .mainText(content.getMainText())
                                                               .likeCount(content.getLikeCount())
                                                               .build())
                                .collect(Collectors.toList());
    }
}