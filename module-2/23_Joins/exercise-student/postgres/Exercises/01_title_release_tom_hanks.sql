-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)

SELECT title, release_date
FROM movie m
LEFT JOIN movie_actor ma
ON m.movie_id = ma.movie_id
LEFT JOIN person p
ON p.person_id = ma.actor_id
WHERE person_name = 'Tom Hanks';
