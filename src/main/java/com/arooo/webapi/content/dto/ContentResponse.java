package com.arooo.webapi.content.dto;

import com.arooo.webapi.content.entity.ContentEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ContentResponse {
    private Long id;
    private String title;
    private String mainText;
    private Integer likes;

    @Builder
    public ContentResponse(Long id, String title, String mainText, Integer likes) {
        this.id = id;
        this.title = title;
        this.mainText = mainText;
        this.likes = likes;
    }

    public ContentResponse toDto (ContentEntity contentEntity) {
        return ContentResponse.builder()
                              .id(contentEntity.getId())
                              .title(contentEntity.getTitle())
                              .mainText(contentEntity.getMainText())
                              .likes(contentEntity.getLikes())
                              .build();
    }

    public static List<ContentResponse> toDtoList (List<ContentEntity> contentEntityList) {
        return contentEntityList.stream()
                                .map(content -> ContentResponse.builder()
                                                               .id(content.getId())
                                                               .title(content.getTitle())
                                                               .mainText(content.getMainText())
                                                               .likes(content.getLikes())
                                                               .build())
                                .collect(Collectors.toList());
    }
}