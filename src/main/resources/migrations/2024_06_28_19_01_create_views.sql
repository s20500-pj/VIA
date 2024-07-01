--liquibase formatted sql
--changeset s20500:2024_06_28_19_01_create_views.sql

CREATE VIEW obszar_with_serwisant_view AS
SELECT
    o.identyfikator AS obszar_id,
    o.nazwa AS obszar_nazwa,
    o.aktywny AS obszar_aktywny,
    s.identyfikator AS serwisant_id,
    s.nazwisko AS serwisant_nazwisko,
    s.email AS serwisant_email
FROM
    obszar o
JOIN
    SIT.serwisant s ON o.identyfikator_serwisanta = s.identyfikator;

CREATE VIEW dzialania_for_serwisant_view AS
SELECT
    s.identyfikator AS serwisant_id,
    s.nazwisko,
    s.email,
    d.identyfikator AS dzialanie_id,
    d.opis_dzialania,
    d.planowany_czas,
    o.nazwa AS obszar_nazwa
FROM
    SIT.serwisant s
JOIN
    SIT.dzialanie d ON s.identyfikator = d.identyfikator_serwisanta
JOIN
    obszar o ON d.identyfikator_obszaru = o.identyfikator;
