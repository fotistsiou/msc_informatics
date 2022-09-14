SELECT 
    a."GENDER" AS "φύλο",
    COUNT(a."GENDER") AS "πλήθος ηθοποιών"
FROM
    "ACTOR" AS a
GROUP BY
    a."GENDER";