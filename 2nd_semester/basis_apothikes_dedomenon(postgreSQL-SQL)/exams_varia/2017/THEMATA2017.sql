PGDMP     &                    z           THEMATA2017    14.5    14.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16524    THEMATA2017    DATABASE     h   CREATE DATABASE "THEMATA2017" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Greek_Greece.1252';
    DROP DATABASE "THEMATA2017";
                postgres    false            �            1259    16539    Airlines    TABLE     l   CREATE TABLE public."Airlines" (
    "ALcode" character varying NOT NULL,
    "ALname" character varying
);
    DROP TABLE public."Airlines";
       public         heap    postgres    false            �            1259    16532    Airports    TABLE     �   CREATE TABLE public."Airports" (
    "APcode" character varying NOT NULL,
    "APname" character varying,
    "APregion" character varying,
    "APcountry" character varying
);
    DROP TABLE public."Airports";
       public         heap    postgres    false            �            1259    16546    FlightDates    TABLE     x   CREATE TABLE public."FlightDates" (
    "FLcode" character varying NOT NULL,
    "FLdate" character varying NOT NULL
);
 !   DROP TABLE public."FlightDates";
       public         heap    postgres    false            �            1259    16525    Flights    TABLE       CREATE TABLE public."Flights" (
    "FLcode" character varying NOT NULL,
    "ALcode" character varying,
    "APcode-from" character varying,
    "APcode-to" character varying,
    "FLdeparture-time" character varying,
    "FLduration" character varying
);
    DROP TABLE public."Flights";
       public         heap    postgres    false                       0    16539    Airlines 
   TABLE DATA           8   COPY public."Airlines" ("ALcode", "ALname") FROM stdin;
    public          postgres    false    211   �       �          0    16532    Airports 
   TABLE DATA           Q   COPY public."Airports" ("APcode", "APname", "APregion", "APcountry") FROM stdin;
    public          postgres    false    210                    0    16546    FlightDates 
   TABLE DATA           ;   COPY public."FlightDates" ("FLcode", "FLdate") FROM stdin;
    public          postgres    false    212   �       �          0    16525    Flights 
   TABLE DATA           u   COPY public."Flights" ("FLcode", "ALcode", "APcode-from", "APcode-to", "FLdeparture-time", "FLduration") FROM stdin;
    public          postgres    false    209          l           2606    16545    Airlines Airlines_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Airlines"
    ADD CONSTRAINT "Airlines_pkey" PRIMARY KEY ("ALcode");
 D   ALTER TABLE ONLY public."Airlines" DROP CONSTRAINT "Airlines_pkey";
       public            postgres    false    211            j           2606    16538    Airports Airports_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Airports"
    ADD CONSTRAINT "Airports_pkey" PRIMARY KEY ("APcode");
 D   ALTER TABLE ONLY public."Airports" DROP CONSTRAINT "Airports_pkey";
       public            postgres    false    210            n           2606    16552    FlightDates FlightDates_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public."FlightDates"
    ADD CONSTRAINT "FlightDates_pkey" PRIMARY KEY ("FLcode", "FLdate");
 J   ALTER TABLE ONLY public."FlightDates" DROP CONSTRAINT "FlightDates_pkey";
       public            postgres    false    212    212            h           2606    16531    Flights Flights_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Flights"
    ADD CONSTRAINT "Flights_pkey" PRIMARY KEY ("FLcode");
 B   ALTER TABLE ONLY public."Flights" DROP CONSTRAINT "Flights_pkey";
       public            postgres    false    209            q           2606    16563    Flights ALcode    FK CONSTRAINT     �   ALTER TABLE ONLY public."Flights"
    ADD CONSTRAINT "ALcode" FOREIGN KEY ("ALcode") REFERENCES public."Airlines"("ALcode") NOT VALID;
 <   ALTER TABLE ONLY public."Flights" DROP CONSTRAINT "ALcode";
       public          postgres    false    3180    209    211            o           2606    16553    Flights APcode-from    FK CONSTRAINT     �   ALTER TABLE ONLY public."Flights"
    ADD CONSTRAINT "APcode-from" FOREIGN KEY ("APcode-from") REFERENCES public."Airports"("APcode") NOT VALID;
 A   ALTER TABLE ONLY public."Flights" DROP CONSTRAINT "APcode-from";
       public          postgres    false    210    209    3178            p           2606    16558    Flights APcode-to    FK CONSTRAINT     �   ALTER TABLE ONLY public."Flights"
    ADD CONSTRAINT "APcode-to" FOREIGN KEY ("APcode-to") REFERENCES public."Airports"("APcode") NOT VALID;
 ?   ALTER TABLE ONLY public."Flights" DROP CONSTRAINT "APcode-to";
       public          postgres    false    210    3178    209            r           2606    16568    FlightDates FLcode    FK CONSTRAINT     �   ALTER TABLE ONLY public."FlightDates"
    ADD CONSTRAINT "FLcode" FOREIGN KEY ("FLcode") REFERENCES public."Flights"("FLcode") NOT VALID;
 @   ALTER TABLE ONLY public."FlightDates" DROP CONSTRAINT "FLcode";
       public          postgres    false    209    212    3176                <   x�s4�tLMOM�Sp�,���K-�rr�t*�,�,� ��'Vs�qU&�%fq��qqq ܪ�      �   �   x�m�A� ���p
N�;�Ԁ)n�Ս��@J� ���C�דXc1]��7�_6ʤ�EZ�p�!�i|nmAO������Z����k������f���n^�'[�~ ��l(G�t�C�ښvΊ�4��AU���~�����v�t���7��Q$         ?   x�s4630�44�"#Cs.G��!\�����YT ��-���sCL5Ȧ��qqq Sy�      �   a   x�U�1�0���0�[�C��	��c�����
���$����u�QՑ)KdS,�R���Y�~�o`���p?�ܰ��'�]�~%#t��=��X8�     