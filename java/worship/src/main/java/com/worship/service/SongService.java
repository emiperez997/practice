package com.worship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worship.entity.Song;
import com.worship.repository.SongRepository;

@Service
public class SongService {

  @Autowired
  private SongRepository songRepository;

  public List<Song> findAll() {
    return (List<Song>) songRepository.findAll();
  }

  public Song findSongById(Integer id) {
    return songRepository.findById(id).orElse(null);
  }

  public Song createSong(Song song) {
    return songRepository.save(song);
  }

  public void deleteSong(Integer id) {
    songRepository.deleteById(id);
  }

}
