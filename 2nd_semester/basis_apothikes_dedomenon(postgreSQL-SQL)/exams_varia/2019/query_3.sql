SELECT 
    i."ship_name" AS "ονοµασία-πλοίου",
    i."departure_port" AS "λιµάνι-αναχώρησης",
    i."departure_date" AS "ηµέρα-ώρα-αναχώρησης",
    i."arrival_date" AS "ηµέρα-ώρα-άφιξης"
FROM 
    "ITINERARY" AS i
WHERE 
    (cast(i."departure_date" AS DATE) = '2019/09/21' AND i."arrival_port" = 'Rappang')
    OR
    (cast(i."departure_date" AS DATE) = '2019/09/22' AND i."arrival_port" = 'Rappang');