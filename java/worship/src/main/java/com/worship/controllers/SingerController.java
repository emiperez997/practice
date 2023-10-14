package com.worship.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worship.entity.Singer;
import com.worship.entity.SingerSong;
import com.worship.service.SingerService;

@RestController
@RequestMapping("/singer")
public class SingerController {

  @Autowired
  private SingerService singerService;

  @GetMapping()
  public ResponseEntity<List<Singer>> findAll() {
    return new ResponseEntity<>(singerService.findBySongsIsNotNull(), HttpStatus.OK);
  }
}
