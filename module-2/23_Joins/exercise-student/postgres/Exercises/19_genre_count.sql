-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).

SELECT g.genre_name, COUNT(m.title) AS num_of_movies
FROM genre g
JOIN movie_genre mg
ON g.genre_id = mg.genre_id
JOIN movie m
ON mg.movie_id = m.movie_id 
GROUP BY g.genre_name;