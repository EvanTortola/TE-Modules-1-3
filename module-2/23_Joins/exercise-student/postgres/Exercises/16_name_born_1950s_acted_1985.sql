-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

SELECT DISTINCT p.person_name, p.birthday
FROM person p
JOIN movie_actor ma
ON p.person_id = ma.actor_id
JOIN movie m
ON ma.movie_id = m.movie_id
WHERE p.birthday > '1949/12/31'
AND p.birthday <= '1959/12/31'
AND m.release_date > '1984/12/31'
AND m.release_date <= '1985/12/31';