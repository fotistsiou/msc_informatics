SELECT 
    ar."APcountry" AS "κράτος", count(fl."ALcode") AS "πλήθος πτήσεων"
FROM 
    "Flights" AS fl
JOIN
    "Airlines" AS arl
ON
    arl."ALcode" = fl."ALcode"
JOIN
    "Airports" AS ar
ON 
    ar."APcode" = fl."APcode-to"
WHERE
    arl."ALname" = 'Aegean Airlines'
GROUP BY
    ar."APcountry";