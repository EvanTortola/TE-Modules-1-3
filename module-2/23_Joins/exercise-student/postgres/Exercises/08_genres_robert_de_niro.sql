-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)


SELECT DISTINCT g.genre_name
FROM genre g
INNER JOIN movie_genre mg
ON mg.genre_id = g.genre_id
INNER JOIN movie m
ON mg.movie_id = m.movie_id
INNER JOIN movie_actor ma
ON ma.movie_id = m.movie_id
INNER JOIN person p
ON ma.actor_id = p.person_id
WHERE p.person_name = 'Robert De Niro' AND m.release_date > '12/31/2009';