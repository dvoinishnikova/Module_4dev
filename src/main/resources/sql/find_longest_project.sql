WITH project_duration AS (
    SELECT (EXTRACT(YEAR FROM FINISH_DATE) - EXTRACT(YEAR FROM START_DATE)) * 12
               + EXTRACT(MONTH FROM FINISH_DATE) - EXTRACT(MONTH FROM START_DATE) AS MONTH_COUNT
    FROM project
)
SELECT project.ID, project_duration.MONTH_COUNT
FROM project
         JOIN project_duration ON true
WHERE project_duration.MONTH_COUNT = (
    SELECT MAX(project_duration.MONTH_COUNT)
    FROM project_duration
);