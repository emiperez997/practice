package com.worship.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private String lyrics;

  // Connect to SingerSong
  @JsonIgnore
  @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
  private List<SingerSong> singerSong;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLyrics() {
    return lyrics;
  }

  public void setLyrics(String lyrics) {
    this.lyrics = lyrics;
  }

  public List<SingerSong> getSingerSong() {
    return singerSong;
  }

  public void setSingerSong(List<SingerSong> singerSong) {
    this.singerSong = singerSong;
  }

}
