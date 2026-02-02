
CREATE TABLE Personne (
    noPersonne INTEGER PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    prenom VARCHAR(60) NOT NULL,
    dateDeNaissance DATE NOT NULL
);

CREATE TABLE Film (
    noFilm INTEGER PRIMARY KEY,
    titre VARCHAR(80) NOT NULL,
    dateSortie DATE NOT NULL,
    duree INTEGER NOT NULL
);

CREATE TABLE Salle (
    noSalle INTEGER PRIMARY KEY,
    capacite INTEGER NOT NULL,
    CHECK (capacite > 0)
);

CREATE TABLE Acteur (
    noFilm INTEGER,
    noPersonne INTEGER,
    role VARCHAR(80),
    PRIMARY KEY (noFilm, noPersonne, role),
    FOREIGN KEY(noFilm) REFERENCES Film(noFilm),
    FOREIGN KEY(noPersonne) REFERENCES Personne(noPersonne)
);

CREATE TABLE Realisateur (
    noPersonne INTEGER,
    noFilm INTEGER,
    PRIMARY KEY (noPersonne, noFilm),
    FOREIGN KEY(noFilm) REFERENCES Film(noFilm),
    FOREIGN KEY(noPersonne) REFERENCES Personne(noPersonne)
);

CREATE TABLE Seance(
    noSalle INTEGER,
    noFilm INTEGER,
    dateSeance DATE,
    heureSeance TIME,
    nombrePlacesVendues INTEGER,
    PRIMARY KEY (noSalle, noFilm, dateSeance, heureSeance),
    FOREIGN KEY (noSalle) REFERENCES Salle(noSalle),
    FOREIGN KEY (noFilm) REFERENCES Film(noFilm)
);


ALTER TABLE Personne RENAME to Personnalite;


ALTER TABLE Film add description VARCHAR(500);



DROP TABLE Seance;
DROP TABLE Acteur;
DROP TABLE Realisateur;
DROP TABLE Personnalite;
DROP TABLE Film;
DROP TABLE Salle;