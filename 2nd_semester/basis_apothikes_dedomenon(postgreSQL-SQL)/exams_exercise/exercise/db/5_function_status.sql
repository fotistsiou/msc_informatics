CREATE OR REPLACE FUNCTION status_check(ticket_no VARCHAR(13), flight_code VARCHAR(10), i_date DATE, r_time TIME)
    RETURNS VARCHAR 
    AS
    $$
        DECLARE
            f_mounth DATE;
            f_time TIME;
            f_act_dep_time TIME;
            f_act_arr_time TIME;
            check_if_canceled VARCHAR;
        BEGIN
            SELECT t_fl_date INTO f_mounth FROM ticket_flight WHERE fl_code = flight_code AND t_no = ticket_no;
            SELECT depart_time_sche INTO f_time FROM flight WHERE fl_code = flight_code;
            SELECT cast(depart_date_act as time) INTO f_act_dep_time FROM flight_depart_act where cast(depart_date_act as date) = i_date AND fl_code = flight_code;
            SELECT cast(arr_date_act as time) INTO f_act_arr_time FROM flight_arr_act where cast(arr_date_act as date) = i_date AND fl_code = flight_code;
            SELECT fl_status INTO check_if_canceled FROM flight where fl_code = flight_code;
            IF (check_if_canceled != 'Canceled') then
                IF (EXTRACT(YEAR FROM f_mounth) - EXTRACT(YEAR FROM i_date) >= 1 OR EXTRACT(MONTH FROM f_mounth) - EXTRACT(MONTH FROM i_date) >= 1) THEN
                    UPDATE flight SET fl_status = 'Not Booked' WHERE fl_code = flight_code;
                    RETURN 'Not Booked'; 
                ELSEIF (EXTRACT(YEAR FROM f_mounth) - EXTRACT(YEAR FROM i_date) = 0 AND EXTRACT(MONTH FROM f_mounth) - EXTRACT(MONTH FROM i_date) < 1 AND EXTRACT(DAY FROM f_mounth) - EXTRACT(DAY FROM i_date) >= 1) THEN
                    UPDATE flight SET fl_status = 'Scheduled' WHERE fl_code = flight_code;
                    RETURN 'Scheduled';
                ELSEIF (f_time > r_time) then
                    UPDATE flight SET fl_status = 'Ontime' WHERE fl_code = flight_code;
                    RETURN 'Ontime';
                ELSEIF (r_time < f_act_dep_time) then
                    UPDATE flight SET fl_status = 'Delayed' WHERE fl_code = flight_code;
                    RETURN 'Delayed';
                ELSEIF (r_time > f_act_dep_time AND r_time < f_act_arr_time) then
                    UPDATE flight SET fl_status = 'Departed' WHERE fl_code = flight_code;
                    RETURN 'Departed';
                ELSEIF (r_time > f_act_arr_time) then
                    UPDATE flight SET fl_status = 'Arrived' WHERE fl_code = flight_code;
                    RETURN 'Arrived';
                END IF;
            ELSE
                RETURN 'Canceled';
            END IF;
        END 
    $$LANGUAGE plpgsql;

SELECT status_check('1265789542646','EDoazFvG2m','2022-09-05', '11:00:00');
SELECT status_check('8234814684835','OPljf24efj','2022-09-12', '12:00:00');
SELECT status_check('2457468545686','16aghzXbPp','2022-09-15', '17:57:00');
SELECT status_check('3686835634637','1LeMJJzMjw','2022-09-11', '10:57:00');
SELECT status_check('4568456346864','HfdofJ86Jo','2022-09-22', '03:57:00');
SELECT status_check('6595567534773','1J8PSkCuMZ','2022-09-09', '16:50:00');
SELECT status_check('4679346374835','hti86HUk97','2022-09-05', '16:50:00');

UPDATE flight SET fl_status = 'Canceled' WHERE fl_code = 'AV769djvdo';
UPDATE flight SET fl_status = 'Canceled' WHERE fl_code = '1DxfMSFQW8';
UPDATE flight SET fl_status = 'Canceled' WHERE fl_code = '1343ffvrsv';

SELECT status_check('6794346347468','1343ffvrsv','2022-09-13', '21:50:00');