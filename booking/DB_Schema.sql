CREATE TABLE theaters
(
    theater_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    city       VARCHAR(255) NOT NULL
);

CREATE TABLE movies
(
    movie_id     BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    release_date DATE         NOT NULL
);


CREATE TABLE bookings
(
    booking_id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    show_id      BIGINT         NOT NULL,
    seats_booked INT            NOT NULL,
    total_price  DECIMAL(19, 2) NOT NULL,
    booking_time TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_show FOREIGN KEY (show_id) REFERENCES shows (show_id) ON DELETE CASCADE
);

CREATE TABLE shows
(
    show_id    SERIAL PRIMARY KEY,
    movie_id   INT              NOT NULL,
    theater_id INT              NOT NULL,
    show_time  TIME             NOT NULL,
    show_date  DATE             NOT NULL,
    price      DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
    FOREIGN KEY (theater_id) REFERENCES theaters (theater_id)
);

CREATE TABLE show_seats
(
    show_seat_id SERIAL PRIMARY KEY,   -- Auto-generated unique ID
    show_id      INT         NOT NULL,
    seat_type    VARCHAR(50) NOT NULL, -- 'available' or 'booked'
    seat_name    VARCHAR(10) NOT NULL,
    FOREIGN KEY (show_id) REFERENCES shows (show_id) ON DELETE CASCADE
);


INSERT INTO movies (title, release_date)
VALUES ('RRR', '2022-03-25'),
       ('Baahubali: The Beginning', '2015-07-10'),
       ('Baahubali: The Conclusion', '2017-04-28'),
       ('Sye Raa Narasimha Reddy', '2019-10-02'),
       ('Eega', '2012-07-06');

INSERT INTO theaters (name, city)
VALUES ('Prasad’s IMAX', 'Hyderabad'),
       ('AMB Cinemas', 'Hyderabad'),
       ('PVR Cinemas', 'Warangal'),
       ('INOX', 'Nizamabad'),
       ('Sri Lakshmi Cinemas', 'Khammam');

INSERT INTO shows (movie_id, theater_id, show_time, show_date, price)
VALUES (1, 1, '19:00', '2025-02-01', 150.00),
       (1, 2, '21:00', '2025-02-01', 180.00),
       (2, 3, '18:30', '2025-02-01', 140.00),
       (2, 1, '20:00', '2025-02-02', 160.00),
       (3, 2, '22:00', '2025-02-01', 200.00);

INSERT INTO show_seats (show_id, seat_type, seat_name)
VALUES (1, 'available', 'A1'),
       (1, 'available', 'A2'),
       (1, 'available', 'A3'),
       (1, 'available', 'A4'),
       (2, 'available', 'B1'),
       (2, 'available', 'B2'),
       (2, 'available', 'B3'),
       (2, 'available', 'B4'),
       (3, 'available', 'C1'),
       (3, 'available', 'C2');

