-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

START TRANSACTION;

INSERT INTO genre (genre_name)
VALUES ('Sports')



INSERT INTO movie (title)
VALUES ('Coach Carter')
WHERE (SELECT genre_name FROM genre WHERE genre_name = 'Sports');
ROLLBACK;
COMMIT;