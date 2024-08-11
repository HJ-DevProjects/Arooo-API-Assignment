package com.arooo.webapi.content.service;

import com.arooo.webapi.content.dto.ContentResponse;
import com.arooo.webapi.content.entity.ContentEntity;
import com.arooo.webapi.content.repository.ContentRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentService {
    private final ContentRepository contentRepository;

    public List<ContentResponse> getContentList(int skip, int limit) {
        Pageable pageable = PageRequest.of(skip / limit, limit);
        List<ContentEntity> contentList = contentRepository.findAllBy(pageable);
        List<ContentResponse> contentResponseList = ContentResponse.toDtoList(contentList);
        return contentResponseList;
    }

    public ContentResponse getContentDetail(Long contentId) {
        Optional<ContentEntity> content = contentRepository.findById(contentId);
        ContentResponse contentResponse = ContentResponse.builder()
                                                         .id(content.get().getId())
                                                  .title(content.get().getTitle())
                                                  .mainText(content.get().getMainText())
                                                  .likes(content.get().getLikes())
                                                  .build();
        return contentResponse;
    }
}