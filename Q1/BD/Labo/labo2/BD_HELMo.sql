-- Exercice 1
UPDATE CATEGORIE
SET CATEGORIEPARENT = NULL
WHERE NOM = 'Informatique'

-- Exercice 2

ALTER TABLE Emprunteur
ADD CodePostal INTEGER;

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 4000
WHERE LOCALITE = 'LiÃ¨ge'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 1000
WHERE LOCALITE = 'Bruxelles'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 8400
WHERE LOCALITE = 'Ostende'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 4900
WHERE LOCALITE = 'Spa'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 8400
WHERE LOCALITE = 'Ostende'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 5021
WHERE LOCALITE = 'Namur'

UPDATE EMPRUNTEUR
SET CODEPOSTAL = 6041
WHERE LOCALITE = 'Charleroi'

-- Exercice 3

UPDATE editeur
SET adresse = 'Fond Jean-Pâques, 4', localite = 'B-1348 Louvain-la-Neuve'
WHERE numediteur = 4

-- Exercice 4

DELETE
FROM Langue
WHERE LOWER(nomLangue) LIKE '%artificielle%';

-- Exercice 8 
SELECT
    prenom || ' ' || nom AS EMPRUNTEUR,
    SUBSTR(email, 1, INSTR(email, '@') - 1) AS PREFIXE,
    SUBSTR(email, INSTR(email, '@') + 1) AS DOMAINE
FROM emprunteur
WHERE email IS NOT NULL;

-- Exercice 7
SELECT
    'La location de l''emprunteur ' || numEmprunteur || ' du ' || TO_CHAR(dateLocation, 'DD/MM/YYYY') || ' a fait l''objet d''un rappel le ' || TO_CHAR(NEXT_DAY(TRUNC(dateRetourPrevu), 'Lundi'), 'DAY dd/mm/yyyy') AS MESSAGE_RAPPEL
FROM Location
WHERE dateRetour IS NULL AND SYSDATE > dateRetourPrevu 

-- Exercice 6 
SELECT
    TITRE,
    ISBN,
    NBPAGES AS NOMBREPAGES,
    cote * 4 || '/20' AS COTE_SUR_20
FROM LIVRE 
WHERE DATEPUBLICATION > DATE '2000-01-01'
  AND COTE > 2.5
  AND UPPER(LANGUE) = 'FRE'
  AND TITRE LIKE '%Harry Potter%';

-- Exercice 5
SELECT 
    nom, 
    prenom,
    TO_CHAR(TO_DATE(SUBSTR(regnat, 1, 8), 'YY.MM.DD'), 'MONTH') as moisdenaissance
FROM emprunteur

-- Exercice 4
SELECT
    NOM,
    TO_CHAR(DATENAISSANCE, 'DD') AS JOURNAISSANCE,
    TO_CHAR(DATENAISSANCE, 'MON',
            'NLS_DATE_LANGUAGE = FRENCH') AS MOISNAISSANCE
FROM AUTEUR
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DATENAISSANCE) / 12) > 60
-- WHERE SYSDATE - dateNaissance > 365 * 60