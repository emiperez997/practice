package com.worship.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worship.entity.Singer;
import com.worship.repository.SingerRepository;

@Service
public class SingerService {

  @Autowired
  private SingerRepository singerRepository;

  public List<Singer> findBySongsIsNotNull() {
    return singerRepository.findBySongsIsNotNull();
  }

  public List<Singer> findAll() {
    return (List<Singer>) singerRepository.findAll();
  }

  public Singer findSingerById(Integer id) {
    return singerRepository.findById(id).orElse(null);
  }

  public Singer createSinger(Singer singer) {
    return singerRepository.save(singer);
  }

  public void deleteSinger(Integer id) {
    singerRepository.deleteById(id);
  }
}
