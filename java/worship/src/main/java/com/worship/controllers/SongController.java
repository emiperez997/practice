package com.worship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worship.entity.Song;
import com.worship.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {

  @Autowired
  private SongService songService;

  @GetMapping()
  public ResponseEntity<List<Song>> findAll() {
    return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
  }

}
