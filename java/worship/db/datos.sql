-- Datos singer

INSERT INTO singer (first_name, last_name)
VALUES
('Matías', 'Mirón'),
('Javier', 'Claure'),
('Cintia', 'Kromplewski'),
('Candela', 'Bruno');

-- Datos song
INSERT INTO song (title, lyrics)
VALUES
('Majestuoso, Poderoso', 'Majestuoso, poderoso, Digno de loor. Proclamemos Su grandeza hoy. // Jescuristo es Rey // Postrados hoy ante Sus pies, Jesucristo es Rey'),
('Dios de lo imposible', 'convallis tellus id interdum velit laoreet id donec ultrices tincidunt arcu non sodales neque sodales ut etiam sit amet nisl purus in mollis nunc sed id semper risus in hendrerit gravida rutrum quisque non tellus orci ac auctor augue mauris augue neque gravida in fermentum et sollicitudin ac orci phasellus'),
('Majestad', 'convallis tellus id interdum velit laoreet id donec ultrices tincidunt arcu non sodales neque sodales ut etiam sit amet nisl purus in mollis nunc sed id semper risus in hendrerit gravida rutrum quisque non tellus orci ac auctor augue mauris augue neque gravida in fermentum et sollicitudin ac orci phasellus');

-- Datos singer_song
INSERT INTO singer_song (singer_id, song_id)
VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 1),
(3, 2),
(3, 3),
(4, 1),
(4, 2),
(4, 3);