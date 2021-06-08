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
ORDER BY date_established, park_name
LIMIT 20;

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
SELECT *, city_name || ', ' || state_abbreviation || '!'
FROM city;


-- The all parks by name and date established.
SELECT *, park_name || ' Date Established: '  || date_established
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
SELECT COUNT(*) AS cities_with_gt1mil
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(state_name) AS name_count
FROM state;

SELECT *
FROM state
ORDER BY state_nickname DESC;


-- The area of the smallest and largest parks.
SELECT MIN(area) AS min_area, MAX(area) AS max_area 
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS city_count
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;


-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT 
        SUM(population) AS state_population ,
        state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;


-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;


-- Miscellaneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT *
FROM city
ORDER BY city_name
OFFSET 10 ROWS FETCH NEXT 20 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT 
        --city.*,
        (SELECT state.state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation) AS state_name,
        COUNT(city.*) AS city_count
FROM city
GROUP BY city.state_abbreviation;


-- Include the names of the smallest and largest parks

SELECT park_name, area--, *
FROM park,
   (
        SELECT 
               MIN(area) AS min_area, 
               MAX(area) AS max_area
        FROM park
   ) AS min_max_area
 WHERE park.area = min_max_area.min_area
 OR park.area = min_max_area.max_area;

SELECT park_name,area
FROM park
WHERE area = (SELECT MIN(area) FROM park) OR
      area = (SELECT MAX(area) FROM park);


-- List the capital cities for the states in the Northeast census region.
SELECT *, 
        (
                SELECT c.city_name
                FROM city AS c
                WHERE c.city_id = s.capital
        ) AS capital_city
FROM state AS s
WHERE s.census_region = 'Northeast';

