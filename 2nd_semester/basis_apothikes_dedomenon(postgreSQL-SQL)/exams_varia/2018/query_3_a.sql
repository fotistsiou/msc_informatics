SELECT 
    a."NAME" AS "όνοµα ηθοποιού",
    f."TITLE" AS "τίτλος ταινίας"
FROM
    "ACTOR" AS a
JOIN
    "CAST" AS c
ON
    c."ACTOR_ID" = a."ID"
JOIN
    "FILM" AS f
ON
    c."FILM_ID" = f."ID" 
WHERE
    f."YEAR" = '2018';