CREATE TABLE fotis_airlines_ex4 (
    name_customer character varying(50) NOT NULL,
    address character varying(50)  NOT NULL,
    country character varying(50) NOT NULL,
    zip_code numeric NOT NULL,
    email_customer character varying(50) NOT NULL,
    tel_customer character varying(50) NOT NULL,
    card_number numeric NOT NULL,
    card_type character varying(50) NOT NULL,
    PRIMARY KEY (email_customer)
);