package com.worship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "singer_song")
public class SingerSong {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "singer_id", insertable = false, updatable = false)
  private Singer singer;

  @ManyToOne
  @JoinColumn(name = "song_id", insertable = false, updatable = false)
  private Song song;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Singer getSinger() {
    return singer;
  }

  public void setSinger(Singer singer) {
    this.singer = singer;
  }

  public Song getSong() {
    return song;
  }

  public void setSong(Song song) {
    this.song = song;
  }

}
