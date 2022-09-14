SELECT 
    fl."FLcode" AS "κωδικός πτήσης", 
    fl."FLdeparture-time" AS "ώρα αναχώρησης", 
    ar2."APname" AS "όνοµα αεροδροµίου άφιξης"
FROM 
    "FlightDates" AS fld
JOIN 
    "Flights" AS fl 
ON 
    fl."FLcode" = fld."FLcode"
JOIN
    "Airports" AS ar
ON 
    ar."APcode" = fl."APcode-from"
JOIN 
    "Airports" AS ar2
ON 
    ar2."APcode" = fl."APcode-to"
WHERE
    ar."APcode" = 'ATH'
AND
    fld."FLdate" = '10/10/2017';