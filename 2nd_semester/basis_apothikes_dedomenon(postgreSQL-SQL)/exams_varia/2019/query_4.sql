SELECT 
    COUNT(b.book_code) AS "πλήθος-κρατήσεων"
FROM 
    "BOOK" AS b
JOIN
    "ITINERARY" AS i
ON 
    i.itinerary_code = b.itinerary_code
WHERE 
    cast(i.departure_date AS DATE) = '2019/09/22'
    AND 
    i.departure_port = 'Weiwangzhuang'
    AND 
    i.arrival_port = 'Rappang'
    AND
    i.ship_name = 'Durgan Inc';