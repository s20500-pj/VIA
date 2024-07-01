--liquibase formatted sql
--changeset s20500:2024_06_30_15_15_add_initial_data.sql

INSERT INTO SIT.serwisant (nazwisko, aktywny, email)
VALUES ('Nowak', 1, 'nowak@example.com'),
       ('Kowalski', 1, 'kowalski@example.com'),
       ('Wiśniewski', 1, 'wisniewski@example.com'),
       ('Wójcik', 1, 'wojcik@example.com'),
       ('Kowalczyk', 1, 'kowalczyk@example.com');

INSERT INTO obszar (nazwa, aktywny, identyfikator_serwisanta)
VALUES ('Pomorskie', 1, 1),
       ('Mazowieckie', 0, 2),
       ('Śląskie', 1, 3),
       ('Opolskie', 0, 4),
       ('Wielkopolskie', 1, 5);

INSERT INTO SIT.dzialanie (opis_dzialania, planowany_czas, identyfikator_serwisanta, identyfikator_obszaru)
VALUES ('Przegląd', 12, 1, 1),
       ('Naprawa', 3, 2, 2),
       ('Wymiana', 19, 3, 3),
       ('Regeneracja', 31, 4, 4),
       ('Naprawa', 20, 5, 5);