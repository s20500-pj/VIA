--liquibase formatted sql
--changeset s20500:2024_06_28_17_36_create_initial_tables.sql

IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'sit')
BEGIN
    EXEC('CREATE SCHEMA sit')
END;

CREATE TABLE [sit].[serwisant] (
    identyfikator        INT NOT NULL IDENTITY(1,1),
    nazwisko             NVARCHAR(250) NOT NULL,
    aktywny              TINYINT NOT NULL DEFAULT 1,
    email                NVARCHAR(250) NOT NULL,
    CONSTRAINT pk_serwisant PRIMARY KEY (identyfikator)
);

CREATE TABLE [obszar] (
    identyfikator            INT NOT NULL IDENTITY(1,1),
    nazwa                    NVARCHAR(250) NOT NULL,
    aktywny                  TINYINT NOT NULL DEFAULT 1,
    identyfikator_serwisanta INT,
    CONSTRAINT pk_obszar PRIMARY KEY (identyfikator),
    CONSTRAINT fk_obszar_serwisant FOREIGN KEY (identyfikator_serwisanta) REFERENCES [sit].[serwisant](identyfikator)
);

CREATE TABLE [sit].[dzialanie] (
    identyfikator            INT NOT NULL IDENTITY(1,1),
    identyfikator_serwisanta INT,
    identyfikator_obszaru    INT,
    opis_dzialania           NVARCHAR(255),
    planowany_czas           INT,
    CONSTRAINT pk_dzialanie PRIMARY KEY (identyfikator),
    CONSTRAINT fk_dzialanie_serwisant FOREIGN KEY (identyfikator_serwisanta) REFERENCES [sit].[serwisant](identyfikator),
    CONSTRAINT fk_dzialanie_obszar FOREIGN KEY (identyfikator_obszaru) REFERENCES [obszar](identyfikator)
);

CREATE INDEX idx_obszar_nazwa ON obszar(nazwa);
CREATE INDEX idx_dzialanie_opis_dzialania ON [sit].dzialanie(opis_dzialania);
