
-- Movie table
CREATE TABLE movies (
id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT,
genre VARCHAR(100),
release_date DATE
);

-- Insert movies into the movies table
INSERT INTO movies (title, description, genre, release_date) VALUES
('Avatar 2', 'A sequel to Avatar, exploring Pandora and its breathtaking landscapes.', 'Action, Sci-Fi', '2022-12-16'),
('Spider-Man: No Way Home', 'Spider-Man teams up with alternate versions of himself to fight multiversal villains.', 'Action, Superhero', '2021-12-17'),
('RRR', 'A fictional story about two Indian revolutionaries, Alluri Sitarama Raju and Komaram Bheem.', 'Action, Drama', '2022-03-25'),
('Pushpa: The Rise', 'A tale of a laborer’s rise in the red sandalwood smuggling syndicate of Andhra and Telangana.', 'Action, Thriller', '2021-12-17'),
('Bahubali: The Beginning', 'A historical epic about a warrior destined to reclaim his kingdom.', 'Action, Drama', '2015-07-10'),
('Bahubali: The Conclusion', 'The epic conclusion to the battle for Mahishmati.', 'Action, Drama', '2017-04-28'),
('KGF: Chapter 1', 'A story about Rocky and his rise to power in the Kolar Gold Fields.', 'Action, Crime', '2018-12-21'),
('KGF: Chapter 2', 'Rocky returns to consolidate his power in the KGF empire.', 'Action, Crime', '2022-04-14'),
('Sita Ramam', 'A heartfelt romantic tale set against a military backdrop.', 'Romance, Drama', '2022-08-05'),
('Radhe Shyam', 'A love story between a palmist and his muse.', 'Romance, Drama', '2022-03-11'),
('Dangal', 'The journey of a father training his daughters to become wrestling champions.', 'Drama, Sports', '2016-12-23'),
('3 Idiots', 'A story about friendship and challenging societal expectations.', 'Comedy, Drama', '2009-12-25'),
('Drushyam', 'A gripping story of a family man caught in a murder investigation.', 'Crime, Thriller', '2014-07-11'),
('Drushyam 2', 'The continuation of the struggles of a father to protect his family.', 'Crime, Thriller', '2021-11-19'),
('Jathi Ratnalu', 'A comedy of three friends who accidentally get into trouble.', 'Comedy', '2021-03-11'),
('Sarileru Neekevvaru', 'A soldier takes on a mission to protect a family from evil forces.', 'Action, Comedy', '2020-01-11'),
('Ala Vaikunthapurramuloo', 'A story of swapped identities and family dynamics.', 'Drama, Comedy', '2020-01-12'),
('Eega', 'A man reincarnates as a fly to avenge his death.', 'Fantasy, Action', '2012-07-06'),
('Maharshi', 'A journey of a man from a corporate CEO to a village savior.', 'Drama, Action', '2019-05-09'),
('Geetha Govindam', 'A lighthearted love story with a touch of comedy.', 'Romance, Comedy', '2018-08-15');

-- theatres table
CREATE TABLE theatres (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
location VARCHAR(255),
capacity INT
);

-- Insert theatres into the theatres table
INSERT INTO theatres (name, location, capacity) VALUES
('PVR Cinemas Hyderabad', 'Hyderabad', 300),
('INOX GVK One', 'Hyderabad', 250),
('Asian Cinemas', 'Secunderabad', 200),
('Miraj Cinemas', 'Warangal', 180),
('Shanti Theatre', 'Nizamabad', 150),
('Cinepolis', 'Karimnagar', 220),
('Radhika Multiplex', 'Khammam', 170),
('Venkateshwara Theatre', 'Mahbubnagar', 140),
('Amaravathi Theatre', 'Adilabad', 160),
('Sri Krishna Cinemas', 'Siddipet', 130);

-- theatres table
CREATE TABLE showtimes (
id SERIAL PRIMARY KEY,
movie_id INT REFERENCES movies(id),
theatre_id INT REFERENCES theatres(id),
show_date DATE NOT NULL,
show_time TIME NOT NULL
);


-- Inserting showtimes data for  theatres
INSERT INTO showtimes (movie_id, theatre_id, show_date, show_time) VALUES
(1, 1, '2025-01-27', '14:00'), -- Movie 1 at PVR Cinemas Hyderabad
(1, 1, '2025-01-27', '18:00'), -- Movie 1 at PVR Cinemas Hyderabad
(2, 2, '2025-01-27', '16:00'), -- Movie 2 at INOX GVK One Hyderabad
(2, 2, '2025-01-27', '20:00'), -- Movie 2 at INOX GVK One Hyderabad
(3, 3, '2025-01-27', '12:00'), -- Movie 3 at Asian Cinemas Secunderabad
(3, 3, '2025-01-27', '15:30'), -- Movie 3 at Asian Cinemas Secunderabad
(4, 4, '2025-01-27', '10:00'), -- Movie 4 at Miraj Cinemas Warangal
(4, 4, '2025-01-27', '13:00'), -- Movie 4 at Miraj Cinemas Warangal
(5, 5, '2025-01-27', '17:00'), -- Movie 5 at Shanti Theatre Nizamabad
(5, 5, '2025-01-27', '20:30'), -- Movie 5 at Shanti Theatre Nizamabad
(6, 6, '2025-01-27', '11:30'), -- Movie 6 at Cinepolis Karimnagar
(6, 6, '2025-01-27', '15:00'), -- Movie 6 at Cinepolis Karimnagar
(7, 7, '2025-01-27', '10:30'), -- Movie 7 at Radhika Multiplex Khammam
(7, 7, '2025-01-27', '14:00'), -- Movie 7 at Radhika Multiplex Khammam
(8, 8, '2025-01-27', '18:00'), -- Movie 8 at Venkateshwara Theatre Mahbubnagar
(8, 8, '2025-01-27', '21:30'); -- Movie 8 at Venkateshwara Theatre Mahbubnagar