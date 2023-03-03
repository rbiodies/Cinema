INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatar)
VALUES ('Alexandr', 'Pushkin', '88005353535', 'winter@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatar)
VALUES ('Mihail', 'Lermontov', '88005353532', 'luna@ya.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatar)
VALUES ('Fedor', 'Dostoevskiy', '88005353536', 'prestuplenie@mail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatar)
VALUES ('Mihail', 'Bulgakov', '88005353636', 'margarita@gmail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);
INSERT INTO users (firstName, lastName, phoneNumber, email, password, avatar)
VALUES ('Sergey', 'Esenin', '88005353530', 'senya@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', null);

INSERT INTO data (user_id, date, time, ip)
VALUES (1, 'December 31, 2021', '23:59', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 10, 2020', '05:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 9, 2020', '04:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 8, 2020', '03:00', '127.0.0.1');
INSERT INTO data (user_id, date, time, ip)
VALUES (2, 'December 5, 2020', '02:00', '127.0.0.1');

INSERT INTO images (user_id, filename, size, mime, uniqueName)
VALUES (1, 'photo.png', '2MB', 'image/png', '1.png');
INSERT INTO images (user_id, filename, size, mime, uniqueName)
VALUES (2, 'avatar.jpg', '196KB', 'image/jpg', '2.jpg');
INSERT INTO images (user_id, filename, size, mime, uniqueName)
VALUES (2, 'image.png', '1MB', 'image/png', '3.png');
INSERT INTO images (user_id, filename, size, mime, uniqueName)
VALUES (3, 'my_holidays.jpg', '196KB', 'image/jpg', '4.jpg');
INSERT INTO images (user_id, filename, size, mime, uniqueName)
VALUES (4, 'dubai.png', '1MB', 'image/png', '5.png');

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

INSERT INTO films (title, yearOfRelease, ageRestrictions, description, poster)
VALUES ('Avatar 2', '2023', '12', 'Blue mans war.', null);
INSERT INTO films (title, yearOfRelease, ageRestrictions, description, poster)
VALUES ('Cheburashka', '2023', '6', 'Family film.', null);
INSERT INTO films (title, yearOfRelease, ageRestrictions, description, poster)
VALUES ('Transformers', '2012', '16', 'Auto-bots war.', null);
INSERT INTO films (title, yearOfRelease, ageRestrictions, description, poster)
VALUES ('Astral', '2015', '18', 'Horror film.', null);
INSERT INTO films (title, yearOfRelease, ageRestrictions, description, poster)
VALUES ('Fifty Shades of Grey', '2015', '18', 'Young student likes rich Cristian Gray who likes BDSM.', null);

INSERT INTO sessions (hall_id, film_id, time, ticketCost)
VALUES (1, 1, '20:00', '650');
INSERT INTO sessions (hall_id, film_id, time, ticketCost)
VALUES (1, 2, '23:00', '400');
INSERT INTO sessions (hall_id, film_id, time, ticketCost)
VALUES (2, 1, '14:00', '600');
INSERT INTO sessions (hall_id, film_id, time, ticketCost)
VALUES (3, 3, '20:00', '400');
INSERT INTO sessions (hall_id, film_id, time, ticketCost)
VALUES (4, 4, '01:00', '350');