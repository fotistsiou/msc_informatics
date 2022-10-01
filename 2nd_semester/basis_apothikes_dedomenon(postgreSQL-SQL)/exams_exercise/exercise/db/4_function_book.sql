CREATE OR REPLACE FUNCTION sum_total_book(book_r VARCHAR(6))
    RETURNS DOUBLE PRECISION
    AS
    $$
        DECLARE 
            summs DOUBLE PRECISION;
        BEGIN 
            SELECT sum(t_tprice) into summs FROM ticket WHERE book_ref = book_r;
            UPDATE book SET book_tprice = summs WHERE book_ref = book_r;
            RETURN summs;
        END
    $$LANGUAGE plpgsql;

SELECT sum_total_book('gh3j42');
SELECT sum_total_book('ukh1d5');
SELECT sum_total_book('44gh21');
SELECT sum_total_book('gh5hdr');
SELECT sum_total_book('dd3j42');
SELECT sum_total_book('hhy54h');
SELECT sum_total_book('dbbf3t');
SELECT sum_total_book('gbgb63');
SELECT sum_total_book('dbd23b');
SELECT sum_total_book('54gfd3');
SELECT sum_total_book('bdsdf2');
SELECT sum_total_book('sfb3sv');
SELECT sum_total_book('gnvx32');
SELECT sum_total_book('56657b');
SELECT sum_total_book('dg324g');
SELECT sum_total_book('hhg56w');
SELECT sum_total_book('46fb13');
SELECT sum_total_book('hgb564');
SELECT sum_total_book('f3g5h5');
SELECT sum_total_book('3gtnrb');
SELECT sum_total_book('7de3gd');
SELECT sum_total_book('3ght67');
SELECT sum_total_book('g5j4dd');
SELECT sum_total_book('sfbd14');
SELECT sum_total_book('sdbfv1');
SELECT sum_total_book('advsd2');
SELECT sum_total_book('13vvrv');
SELECT sum_total_book('dvd234');
SELECT sum_total_book('vs35sv');
SELECT sum_total_book('sdvsv3');
SELECT sum_total_book('235gsv');
SELECT sum_total_book('bbb3sv');
SELECT sum_total_book('bgst51');
SELECT sum_total_book('763gbs');
SELECT sum_total_book('dbbg4h');
SELECT sum_total_book('23hbgd');
SELECT sum_total_book('454hsb');
SELECT sum_total_book('egfge3');
SELECT sum_total_book('fg456h');
SELECT sum_total_book('dbr454');
SELECT sum_total_book('kfg5bc');
SELECT sum_total_book('dgnd31');
SELECT sum_total_book('36ebda');
SELECT sum_total_book('enwer5');
SELECT sum_total_book('dv25a2');
SELECT sum_total_book('47dbd2');
SELECT sum_total_book('db5db1');
SELECT sum_total_book('ad5ev1');
SELECT sum_total_book('dv224v');
SELECT sum_total_book('adv24s');
SELECT sum_total_book('dvcvc3');
SELECT sum_total_book('sdvb3s');
SELECT sum_total_book('bsdv3s');