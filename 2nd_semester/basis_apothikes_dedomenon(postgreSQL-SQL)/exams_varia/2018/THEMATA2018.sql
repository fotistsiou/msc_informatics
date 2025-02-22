PGDMP     5                    z           THEMATA2018    14.5    14.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16573    THEMATA2018    DATABASE     h   CREATE DATABASE "THEMATA2018" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Greek_Greece.1252';
    DROP DATABASE "THEMATA2018";
                postgres    false            �            1259    16581    ACTOR    TABLE     �   CREATE TABLE public."ACTOR" (
    "ID" character varying NOT NULL,
    "NAME" character varying,
    "GENDER" character varying
);
    DROP TABLE public."ACTOR";
       public         heap    postgres    false            �            1259    16588    CAST    TABLE     �   CREATE TABLE public."CAST" (
    "ACTOR_ID" character varying NOT NULL,
    "FILM_ID" character varying NOT NULL,
    "ROLE" character varying
);
    DROP TABLE public."CAST";
       public         heap    postgres    false            �            1259    16574    FILM    TABLE     �   CREATE TABLE public."FILM" (
    "ID" character varying NOT NULL,
    "TITLE" character varying,
    "YEAR" character varying
);
    DROP TABLE public."FILM";
       public         heap    postgres    false            �          0    16581    ACTOR 
   TABLE DATA           9   COPY public."ACTOR" ("ID", "NAME", "GENDER") FROM stdin;
    public          postgres    false    210   "       �          0    16588    CAST 
   TABLE DATA           ?   COPY public."CAST" ("ACTOR_ID", "FILM_ID", "ROLE") FROM stdin;
    public          postgres    false    211   �       �          0    16574    FILM 
   TABLE DATA           7   COPY public."FILM" ("ID", "TITLE", "YEAR") FROM stdin;
    public          postgres    false    209          f           2606    16587    ACTOR ACTOR_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."ACTOR"
    ADD CONSTRAINT "ACTOR_pkey" PRIMARY KEY ("ID");
 >   ALTER TABLE ONLY public."ACTOR" DROP CONSTRAINT "ACTOR_pkey";
       public            postgres    false    210            h           2606    16594    CAST CAST_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public."CAST"
    ADD CONSTRAINT "CAST_pkey" PRIMARY KEY ("ACTOR_ID", "FILM_ID");
 <   ALTER TABLE ONLY public."CAST" DROP CONSTRAINT "CAST_pkey";
       public            postgres    false    211    211            d           2606    16580    FILM FILM_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."FILM"
    ADD CONSTRAINT "FILM_pkey" PRIMARY KEY ("ID");
 <   ALTER TABLE ONLY public."FILM" DROP CONSTRAINT "FILM_pkey";
       public            postgres    false    209            i           2606    16595    CAST ACTOR_ID    FK CONSTRAINT     w   ALTER TABLE ONLY public."CAST"
    ADD CONSTRAINT "ACTOR_ID" FOREIGN KEY ("ACTOR_ID") REFERENCES public."ACTOR"("ID");
 ;   ALTER TABLE ONLY public."CAST" DROP CONSTRAINT "ACTOR_ID";
       public          postgres    false    211    210    3174            j           2606    16600    CAST FILM_ID    FK CONSTRAINT     t   ALTER TABLE ONLY public."CAST"
    ADD CONSTRAINT "FILM_ID" FOREIGN KEY ("FILM_ID") REFERENCES public."FILM"("ID");
 :   ALTER TABLE ONLY public."CAST" DROP CONSTRAINT "FILM_ID";
       public          postgres    false    211    209    3172            �   Q   x��svq��LO���M�I��s
p����%�&e�r���B��\���E�9��p�H�`oN�B$�1��/39j^� +5=      �   �   x�]��
1 �ͿD��cw�p�F�&��M�� h��Mlgf	)�
:ǖ�>@\ϏZn�ܞj�XO�=#-0��\ޢ�Xġ�ln�Z~�'Cd'F�[���]L ��t��9�����0���i��z�I1�      �   �   x�5�=k�0��Y�wL���Vp�JI C%���+cɥ��UI����F��n�,l��=�.�rK��%&{����GO.�#�׬*ˆ�V���(4ۓ�qZ:���>��mJ>Я�\*%��.뮖.�t�'tY�M�jcZar�{�	vHx�m�����4R	m��u�4�@��SN��'��}G?e     