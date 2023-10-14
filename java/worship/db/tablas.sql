-- Table Singer
CREATE TABLE singer(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50)
);

-- Table Song
CREATE TABLE song(
	id SERIAL PRIMARY KEY,
	title VARCHAR(50),
	lyrics TEXT
);

-- Table SingerSong
CREATE TABLE singer_song(
  id SERIAL PRIMARY KEY,
  singer_id INTEGER REFERENCES singer(id),
  song_id INTEGER REFERENCES song(id)
);
