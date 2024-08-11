package com.arooo.webapi.content.controller;

import com.arooo.webapi.content.dto.ContentResponse;
import com.arooo.webapi.content.entity.ContentEntity;
import com.arooo.webapi.content.repository.ContentRepository;
import com.arooo.webapi.content.service.ContentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController
@Controller
//@RequestMapping("/api")
@RequestMapping("/api/library/content")
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    /* 콘텐츠 리스트 조회 */
    // @GetMapping("/library/content")
    @GetMapping
    public String getList(@RequestParam(name = "skip", defaultValue = "0") int skip,
                                         @RequestParam(name = "limit", defaultValue = "10") int limit,
                                         Model model) {
        List<ContentResponse> contents = contentService.getContentList(skip, limit);
        model.addAttribute("contents", contents);
        // return contents;
        return "content/list";
    }

    /* 콘텐츠 상세 조회 */
    // @GetMapping("/library/content/{contentId}")
    @GetMapping("/{contentId}")
    public String getContentDetail(@PathVariable Long contentId, Model model){
        ContentResponse content = contentService.getContentDetail(contentId);
        model.addAttribute("content", content);
        return "content/detail";
    }
}