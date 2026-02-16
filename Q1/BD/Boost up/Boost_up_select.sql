-- Exercice 1

select c.nom || ' ' || c.prenom as candidat
from candidat c

-- Exercice 2

select *
from bien
where nb_chac > 4

-- Exercice 3

select *
from bien
where to_char(date_mise_en_vente, 'mm-yyyy') = '08-2012'

-- Exercice 4

select nom, prenom
from candidat
where lower(nom) like '%on%'

-- Exercice 5

select *
from bien
where nb_chac is null

-- Exercice 6

select *
from offre
where date_offre > sysdate

-- Exercice 7

select id_bien, to_char((sysdate - date_mise_en_vente),'dd') as jours_ecoules
from bien

-- Exercice 8

select (rue || ' ' || numero || ' ' || 'à' || ' ' ||  localite) as adresse, to_char(date_mise_en_vente, 'dd-month-yyyy') as date_mise_en_vente
from bien
where surface_habitable > 250 and nb_sdb > 1 and nb_facade >= 3

-- Exercice 9

select nom, prenom, localite
from client
where lower(localite) in ('verviers','spa','herve','eupen')

-- Exercice 10

select id_offre, montant
from offre


-- Exercice 11

select localite
from candidat
where lower(localite) like 'p%'

-- Exercice 12

select '*' || substr(telephone,instr(telephone,'/'))
from client

-- Exercice 13

select pseudo
from vendeur
where length(mdp) < 32

-- Exercice 14

select upper(substr(nom,1,1)) || substr(nom,2) as nom
from candidat

-- Exercice 15

select localite, code_postal
from client
where lower(localite) = 'spa'

update client
    set code_postal = 4900
where lower(localite) = 'spa'

-- Exercice 16

select numero, rue, localite
from bien
where date_mise_en_vente > to_date('01-08-2012', 'dd-mm-yyyy') and nb_chac >= 2 and nb_sdb >= 2
order by surface_habitable desc

-- Exercice 17

select substr(email, 1, instr(email, '@')-1) as Nom, substr(email, instr(email, '@')+1) as Domaine
from candidat
order by Domaine asc