package com.example.jpa_advanced.repositories;

import com.example.jpa_advanced.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Integer> {
}
