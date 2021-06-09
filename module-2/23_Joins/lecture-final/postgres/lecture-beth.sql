-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city.city_name, state.state_name
FROM city
INNER JOIN state
ON city.state_abbreviation = state.state_abbreviation
WHERE city.city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT p.park_name, ps.state_abbreviation
FROM park p
INNER JOIN park_state ps
ON p.park_id = ps.park_id;


-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT p.park_name, ps.state_abbreviation, s.state_name
FROM park p
INNER JOIN park_state ps
ON p.park_id = ps.park_id
INNER JOIN state s
ON ps.state_abbreviation = s.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.
SELECT p.park_name, ps.state_abbreviation, s.state_name, c.city_name AS state_capital
FROM park p
INNER JOIN park_state ps
ON p.park_id = ps.park_id
INNER JOIN state s
ON ps.state_abbreviation = s.state_abbreviation
LEFT JOIN city c
ON s.capital = c.city_id;


-- Modify the previous query to include the area of each park.
SELECT 
        p.park_name, 
        ps.state_abbreviation, 
        s.state_name, 
        c.city_name AS state_capital, 
        p.area AS park_area
FROM park p
INNER JOIN park_state ps
ON p.park_id = ps.park_id
INNER JOIN state s
ON ps.state_abbreviation = s.state_abbreviation
LEFT JOIN city c
ON s.capital = c.city_id;


-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT 
        c.city_name,
        c.population,
        s.census_region
FROM city c
JOIN state s
ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.

SELECT 
         s.state_name,
         COUNT(*) AS cities_in_state
FROM city c
JOIN state s
ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT 
         s.state_name,
         COUNT(*) AS cities_in_state
FROM city c
JOIN state s
ON c.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_abbreviation
ORDER BY cities_in_state DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.

SELECT 
        s.state_name,
        MIN(p.date_established) AS earliest_park_estblished_date
        --earliest date a park was established - MIN on some date
FROM state s 
LEFT JOIN park_state ps
ON s.state_abbreviation = ps.state_abbreviation
LEFT JOIN park p
ON ps.park_id = p.park_id
GROUP BY s.state_abbreviation, s.state_name
ORDER BY s.state_name;

-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. 
--(Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%'

UNION 

SELECT city_name
FROM city
WHERE city_name LIKE 'W%'
ORDER BY place_name ;
 --UNION selects DISTINCT values
 
 --UNION ALL doesn't

SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%'

UNION ALL

SELECT city_name
FROM city
WHERE city_name LIKE 'W%'

ORDER BY place_name ;


-- Modify the previous query to include a column that indicates whether the place is a city or state.

SELECT 
        state_name AS place_name,
        'State' AS place_type
FROM state
WHERE state_name LIKE 'W%'

UNION 

SELECT 
        city_name,
        'City' AS place_type
FROM city
WHERE city_name LIKE 'W%'
ORDER BY place_type, place_name ;



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT *
FROM genre;

-- The titles of all the Comedy movies
SELECT m.title
FROM movie m
JOIN movie_genre mg
ON m.movie_id = mg.movie_id
JOIN genre g
ON mg.genre_id = g.genre_id
WHERE g.genre_name = 'Comedy';
