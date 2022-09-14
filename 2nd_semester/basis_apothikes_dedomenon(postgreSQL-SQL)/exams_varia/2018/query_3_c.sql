SELECT 
    a."NAME" AS "όνοµα ηθοποιού",
    COUNT(c."ACTOR_ID") AS "πλήθος ταινιών"
FROM
    "ACTOR" AS a
JOIN
    "CAST" AS c
ON
    c."ACTOR_ID" = a."ID"
GROUP BY
    a."NAME"
HAVING
    COUNT(c."ACTOR_ID") >= 2;