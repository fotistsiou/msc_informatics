PGDMP     	    0                z           THEMATA2019    14.5    14.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16637    THEMATA2019    DATABASE     h   CREATE DATABASE "THEMATA2019" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Greek_Greece.1252';
    DROP DATABASE "THEMATA2019";
                postgres    false            �            1259    16657    BOOK    TABLE     �   CREATE TABLE public."BOOK" (
    book_code character varying NOT NULL,
    itinerary_code character varying,
    pass_lname character varying,
    pass_fname character varying
);
    DROP TABLE public."BOOK";
       public         heap    postgres    false            �            1259    16645 	   ITINERARY    TABLE     6  CREATE TABLE public."ITINERARY" (
    itinerary_code character varying NOT NULL,
    ship_name character varying,
    departure_port character varying,
    arrival_port character varying,
    departure_date timestamp without time zone,
    arrival_date timestamp without time zone,
    ticket_price numeric
);
    DROP TABLE public."ITINERARY";
       public         heap    postgres    false            �            1259    16638    SHIP    TABLE     d   CREATE TABLE public."SHIP" (
    ship_name character varying NOT NULL,
    ship_capacity integer
);
    DROP TABLE public."SHIP";
       public         heap    postgres    false            �          0    16657    BOOK 
   TABLE DATA           S   COPY public."BOOK" (book_code, itinerary_code, pass_lname, pass_fname) FROM stdin;
    public          postgres    false    211   �       �          0    16645 	   ITINERARY 
   TABLE DATA           �   COPY public."ITINERARY" (itinerary_code, ship_name, departure_port, arrival_port, departure_date, arrival_date, ticket_price) FROM stdin;
    public          postgres    false    210   �       �          0    16638    SHIP 
   TABLE DATA           :   COPY public."SHIP" (ship_name, ship_capacity) FROM stdin;
    public          postgres    false    209   O       h           2606    16663    BOOK BOOK_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."BOOK"
    ADD CONSTRAINT "BOOK_pkey" PRIMARY KEY (book_code);
 <   ALTER TABLE ONLY public."BOOK" DROP CONSTRAINT "BOOK_pkey";
       public            postgres    false    211            f           2606    16651    ITINERARY ITINERARY_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public."ITINERARY"
    ADD CONSTRAINT "ITINERARY_pkey" PRIMARY KEY (itinerary_code);
 F   ALTER TABLE ONLY public."ITINERARY" DROP CONSTRAINT "ITINERARY_pkey";
       public            postgres    false    210            d           2606    16644    SHIP SHIP_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public."SHIP"
    ADD CONSTRAINT "SHIP_pkey" PRIMARY KEY (ship_name);
 <   ALTER TABLE ONLY public."SHIP" DROP CONSTRAINT "SHIP_pkey";
       public            postgres    false    209            j           2606    16664    BOOK itinerary_code    FK CONSTRAINT     �   ALTER TABLE ONLY public."BOOK"
    ADD CONSTRAINT itinerary_code FOREIGN KEY (itinerary_code) REFERENCES public."ITINERARY"(itinerary_code);
 ?   ALTER TABLE ONLY public."BOOK" DROP CONSTRAINT itinerary_code;
       public          postgres    false    3174    210    211            i           2606    16652    ITINERARY ship_name    FK CONSTRAINT     ~   ALTER TABLE ONLY public."ITINERARY"
    ADD CONSTRAINT ship_name FOREIGN KEY (ship_name) REFERENCES public."SHIP"(ship_name);
 ?   ALTER TABLE ONLY public."ITINERARY" DROP CONSTRAINT ship_name;
       public          postgres    false    210    3172    209            �   �   x�-��NA��=��+����K�l�t�ҳ�fyz��[��JuW�%?QhYԗ^M�E0m'�Pƌ���+b�ю� �\�kI��z-�z7ϴ�D�$�6wm¨NsJ��5I����t�S=.�/�|�e�؃s�Vs�?�����2ϥVb_�|SV�C.��~�����`I�u�l������D\�84`M%w+jGh��������8>��&>�XO�A�uMj��	��G��>�|q      �   �  x���Mn�0���)t��E�f綀$
o�E7��HQ�AJ�mO�E/�^�4��c$� $�x ��<�TL�G����'��+@4\��a�	#�N����k�K��~�a���&�Zi�IK(Ic���Z!A1�u4��ݪ
&���݉v|�?�#%�B�Wd�$�}9J���E��N�j�A_Z�r\�ժvW)�
1pubeW�ٚ�RBqU
3��QV/��-t΢�����t�M_r��lJt��򘤘�|r���m�]x?v���~��=�VO �8��O�e�g���J2��	�K���6R̶C;]k�2�y��ȡ�k�Y���0�D���@LP-��i�H��������vk#�o|�� e[X5;��R��e��L�0TvQ�;�J�4*}٨	IC�/�w3 �G� =��'���d�      �   q   x�sJ,*�//�Q�LMO�KQ a�Ԣ���TNK.��"���g^2��%�w~Uj�nPjf^zj���%Wxfq~U��{iqf6М�LN.�Ԣ�⒢�\]�Ĳ�bNCC�=... �|#     