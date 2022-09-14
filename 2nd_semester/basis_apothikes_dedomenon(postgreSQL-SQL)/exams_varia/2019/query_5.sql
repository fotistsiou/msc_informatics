SELECT 
    (s.ship_capacity - COUNT(b.book_code)) AS "διαθέσιµες_θέσεις"
FROM 
    "BOOK" AS b
JOIN
    "ITINERARY" AS i
ON 
    i.itinerary_code = b.itinerary_code
JOIN
    "SHIP" AS s 
ON 
    s.ship_name = i.ship_name
WHERE 
    cast(i.departure_date AS DATE) = '2019/09/22'
    AND 
    i.departure_port = 'Weiwangzhuang'
    AND 
    i.arrival_port = 'Rappang'
    AND
    i.ship_name = 'Durgan Inc'
GROUP BY
    s.ship_capacity;