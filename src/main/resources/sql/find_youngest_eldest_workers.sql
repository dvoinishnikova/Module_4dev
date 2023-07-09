WITH youngest_worker AS (
    SELECT NAME, BIRTHDAY
    FROM worker
    WHERE BIRTHDAY = (SELECT MAX(BIRTHDAY) FROM worker)
), oldest_worker AS (
    SELECT NAME, BIRTHDAY
    FROM worker
    WHERE BIRTHDAY = (SELECT MIN(BIRTHDAY) FROM worker)
)
SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
FROM youngest_worker
UNION ALL
SELECT 'OLDEST' AS TYPE, NAME, BIRTHDAY
FROM oldest_worker;