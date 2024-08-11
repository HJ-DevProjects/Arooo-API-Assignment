package com.arooo.webapi.like.entity;

import com.arooo.webapi.content.entity.ContentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "thumbs_up")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thumbs_up_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private ContentEntity content;

    /* Entity 생성 메서드 */
    @Builder
    public LikeEntity(ContentEntity content) {
        this.content = content;
    }
}