-- Exercice 2 
SELECT COUNT(*)
FROM Film f
JOIN Acteur a ON f.numFilm = a.numFilm
WHERE UPPER(f.titre) = 'GONE GIRL'

-- Exercice 3
SELECT AVG (duree)
FROM Film f
JOIN Acteur a ON f.numFilm = a.numFilm
JOIN Personne p ON p.numPersonne = p.numPersonne
WHERE UPPER(p.nom) = 'LANNERS' AND UPPER(p.prenom) = 'BOULI'

-- Exercice 4
SELECT TO_CHAR(jourHeure, 'dd/mm/yyyy'), numSalle, SUM(nbPlacesVendues)
FROM Seance
GROUP BY TO_CHAR(jourHeure, 'dd/mm/yyyy'), numSalle

-- Exercice 5
SELECT sa.nomSalle, (SUM(se.nbPlacesVendues) / SUM(sa.capacite)) * 100 || '%'
FROM Salle sa
JOIN Seance se ON se.numSalle = sa.numSalle
WHERE TO_CHAR (jourHeure, 'mmyyyy') = '012017'
GROUP BY sa.nomSalle

-- Exercice 6
SELECT titre, dateSortie
FROM Film f
WHERE Duree > (SELECT AVG(duree)FROM Film)
