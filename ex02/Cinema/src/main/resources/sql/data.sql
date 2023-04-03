INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatarUrl)
VALUES ('Alexandr', 'Pushkin', '88005353535', 'winter@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatarUrl)
VALUES ('Mihail', 'Lermontov', '88005353532', 'luna@ya.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatarUrl)
VALUES ('Fedor', 'Dostoevskiy', '88005353536', 'prestuplenie@mail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatarUrl)
VALUES ('Mihail', 'Bulgakov', '88005353636', 'margarita@gmail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatarUrl)
VALUES ('Sergey', 'Esenin', '88005353530', 'senya@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);

INSERT INTO data (user_id, date, time, ip)
VALUES (1, 'December 31, 2021', '23:59', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 10, 2020', '05:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 19, 2020', '04:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 8, 2021', '03:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 5, 2022', '02:00', '127.0.0.1');

INSERT INTO images (user_id, filename, size, mime, url)
VALUES (1, 'photo.png', '2MB', 'image/png', null);
INSERT INTO images (user_id, filename, size, mime, url)
VALUES (2, 'avatar.jpg', '196KB', 'image/jpg', null);
INSERT INTO images (user_id, filename, size, mime, url)
VALUES (2, 'image.png', '1MB', 'image/png', null);
INSERT INTO images (user_id, filename, size, mime, url)
VALUES (3, 'my_holidays.jpg', '196KB', 'image/jpg', null);
INSERT INTO images (user_id, filename, size, mime, url)
VALUES (4, 'dubai.png', '1MB', 'image/png', null);

INSERT INTO halls (serialNumber, numberOfSeats)
VALUES ('123D-435F-DF4F-2RFD', '35');
INSERT INTO halls (serialNumber, numberOfSeats)
VALUES ('3SDS-3244-DDF4-FD43', '30');
INSERT INTO halls (serialNumber, numberOfSeats)
VALUES ('A4DS-D678-8DS8-8DSD', '30');
INSERT INTO halls (serialNumber, numberOfSeats)
VALUES ('ASD4-435F-4464-DFF7', '25');
INSERT INTO halls (serialNumber, numberOfSeats)
VALUES ('AAA4-DDD4-4DDD-FFD6', '20');

INSERT INTO films (name, yearOfRelease, ageRestrictions, description, posterUrl)
VALUES ('Avatar 2', '2023', '12', 'Blue mans war.', null);
INSERT INTO films (name, yearOfRelease, ageRestrictions, description, posterUrl)
VALUES ('Cheburashka', '2023', '6', 'Family film.', null);
INSERT INTO films (name, yearOfRelease, ageRestrictions, description, posterUrl)
VALUES ('Transformers', '2012', '16', 'Auto-bots war.', null);
INSERT INTO films (name, yearOfRelease, ageRestrictions, description, posterUrl)
VALUES ('Astral', '2015', '18', 'Horror film.', null);
INSERT INTO films (name, yearOfRelease, ageRestrictions, description, posterUrl)
VALUES ('Fifty Shades of Grey', '2015', '18', 'Young student likes rich Cristian Gray who likes BDSM.', null);

INSERT INTO sessions (hall_id, film_id, dateTime, ticketCost)
VALUES (1, 1, '01/02/2023 20:00', '650');
INSERT INTO sessions (hall_id, film_id, dateTime, ticketCost)
VALUES (1, 2, '01/02/2023 23:00', '400');
INSERT INTO sessions (hall_id, film_id, dateTime, ticketCost)
VALUES (2, 1, '01/04/2023 14:00', '600');
INSERT INTO sessions (hall_id, film_id, dateTime, ticketCost)
VALUES (3, 3, '01/03/2023 20:00', '400');
INSERT INTO sessions (hall_id, film_id, dateTime, ticketCost)
VALUES (4, 4, '01/06/2023 01:00', '350');

INSERT INTO messages (film_id, author, content)
VALUES (1, 'user123', 'Hello!');
INSERT INTO messages (film_id, author, content)
VALUES (1, 'user435', 'Really good film :)');
INSERT INTO messages (film_id, author, content)
VALUES (1, 'user567', 'Bye (:');
INSERT INTO messages (film_id, author, content)
VALUES (2, 'user789', 'Cool film!');
INSERT INTO messages (film_id, author, content)
VALUES (3, 'user123', 'I do not like...');