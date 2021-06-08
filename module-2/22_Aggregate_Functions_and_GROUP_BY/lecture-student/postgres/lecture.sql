-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT *
FROM state
ORDER BY census_region DESC;


-- The biggest park by area
SELECT *
FROM park
ORDER BY area DESC
LIMIT 1;



-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT *
FROM park
WHERE park_id IN (
        SELECT park_id
        FROM park
        ORDER BY date_established
        LIMIT 20
)
ORDER BY park_name;





-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT *, city_name || ', ' || state_abbreviation
FROM city;


-- The all parks by name and date established.
SELECT *, park_name || ' Date Established: ' || date_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ' ' || state_name AS region_state_name
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY region_state_name;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population
FROM state
WHERE census_region IN ('West', 'South');


-- The number of cities with populations greater than 1 million
SELECT COUNT(city_name) AS cities_with_gt1mil
FROM city
WHERE population > 1000000;


-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(state_name) AS name_count
FROM state;


-- The area of the smallest and largest parks.
SELECT MIN(area) AS min_area, MAX(area) AS max_area
FROM park;



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS city_count
FROM city
GROUP BY state_abbreviation;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;


-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT 
        state_abbreviation,
        SUM(population) AS state_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;


-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT *
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT 
        state_abbreviation, 
        COUNT(*) AS city_count
FROM city
GROUP BY state_abbreviation;

SELECT state_name
FROM state
WHERE state_abbreviation = 'AZ';


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

