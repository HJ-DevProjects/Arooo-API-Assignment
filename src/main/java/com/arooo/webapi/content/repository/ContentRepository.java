package com.arooo.webapi.content.repository;

import com.arooo.webapi.content.entity.ContentEntity;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
    List<ContentEntity> findAllBy(Pageable pageable);
    Optional<ContentEntity> findById(Long contentId);
}