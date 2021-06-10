-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre_name
FROM genre g
INNER JOIN movie_genre mg
ON mg.genre_id = g.genre_id
INNER JOIN movie m
ON mg.movie_id = m.movie_id
INNER JOIN movie_actor ma
ON ma.movie_id = m.movie_id
INNER JOIN person p
ON ma.actor_id = p.person_id
WHERE p.person_name = 'Christopher Lloyd';