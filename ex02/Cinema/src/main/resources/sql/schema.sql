DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS data;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS halls;
DROP TABLE IF EXISTS films;
DROP TABLE IF EXISTS sessions;
DROP TABLE IF EXISTS messages;


CREATE TABLE IF NOT EXISTS users (
    id              INTEGER PRIMARY KEY,
    firstName       TEXT NOT NULL,
    lastName        TEXT NOT NULL,
    phoneNumber     TEXT NOT NULL,
    email           TEXT NOT NULL,
    password        TEXT,
    avatarUrl       TEXT
);

CREATE TABLE IF NOT EXISTS data (
    id              INTEGER PRIMARY KEY,
    user_id         INTEGER NOT NULL REFERENCES users(id),
    date            TEXT NOT NULL,
    time            TIMESTAMP,
    ip              TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS images (
    id              INTEGER PRIMARY KEY,
    user_id         INTEGER NOT NULL REFERENCES users(id),
    filename        TEXT NOT NULL,
    size            TEXT NOT NULL,
    mime            TEXT NOT NULL,
    url             TEXT
);

CREATE TABLE IF NOT EXISTS halls (
    id              INTEGER PRIMARY KEY,
    serialNumber    TEXT NOT NULL,
    numberOfSeats   TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS films (
    id              INTEGER PRIMARY KEY,
    name            TEXT NOT NULL,
    yearOfRelease   TEXT NOT NULL,
    ageRestrictions TEXT NOT NULL,
    description     TEXT NOT NULL,
    posterUrl       TEXT
);

CREATE TABLE IF NOT EXISTS sessions (
    id              INTEGER PRIMARY KEY,
    hall_id         INTEGER NOT NULL REFERENCES halls(id),
    film_id         INTEGER NOT NULL REFERENCES films(id),
    dateTime        TIMESTAMP,
    ticketCost      TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
    id              INTEGER PRIMARY KEY,
    film_id         INTEGER NOT NULL REFERENCES films(id),
    author          TEXT NOT NULL,
    content         TEXT NOT NULL
);