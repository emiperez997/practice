package com.worship.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.worship.entity.Singer;

public interface SingerRepository extends JpaRepository<Singer, Integer> {

  // Find singers with songs
  // @Query(nativeQuery = true, value = "SELECT * FROM singer INNER JOIN
  // singer_song ON singer.id = singer_song.singer_id INNER JOIN song ON
  // singer_song.song_id = song.id")
  List<Singer> findBySongsIsNotNull();

}
