-- 6. The genres of "The Wizard of Oz" (3 rows)


SELECT genre_name
FROM genre g
INNER JOIN movie_genre mg
ON mg.genre_id = g.genre_id
INNER JOIN movie m
ON mg.movie_id = m.movie_id
WHERE m.title = 'The Wizard of Oz';