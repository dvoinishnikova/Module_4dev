WITH project_duration AS (
    SELECT project.ID, (EXTRACT(YEAR FROM project.FINISH_DATE) - EXTRACT(YEAR FROM project.START_DATE)) * 12
                           + EXTRACT(MONTH FROM project.FINISH_DATE) - EXTRACT(MONTH FROM project.START_DATE) AS MONTH_COUNT
    FROM project
)
SELECT project.ID, project_duration.MONTH_COUNT
FROM project
         JOIN project_duration ON project.ID = project_duration.ID
WHERE project_duration.MONTH_COUNT = (
    SELECT MAX(project_duration.MONTH_COUNT)
    FROM project_duration
);