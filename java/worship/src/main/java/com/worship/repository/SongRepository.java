package com.worship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worship.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

}
