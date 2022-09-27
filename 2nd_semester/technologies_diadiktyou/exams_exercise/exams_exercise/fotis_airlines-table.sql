-- Table: public.fotis_airlines

-- DROP TABLE IF EXISTS public.fotis_airlines;

CREATE TABLE IF NOT EXISTS public.fotis_airlines
(
    name_customer character varying(50) COLLATE pg_catalog."default" NOT NULL,
    address character varying(50) COLLATE pg_catalog."default" NOT NULL,
    country character varying(50) COLLATE pg_catalog."default" NOT NULL,
    zip_code numeric NOT NULL,
    email_customer character varying(50) COLLATE pg_catalog."default" NOT NULL,
    tel_customer character varying(50) COLLATE pg_catalog."default" NOT NULL,
    card_number numeric NOT NULL,
    card_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    pass_customer character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT fotis_airlines_pkey PRIMARY KEY (email_customer)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.fotis_airlines
    OWNER to postgres;