package com.anoystick.repository;

import com.anoystick.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
