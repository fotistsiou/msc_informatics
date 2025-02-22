PGDMP         	                z           airlines_vaseis    14.3    14.3 4    I           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            J           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            K           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            L           1262    18543    airlines_vaseis    DATABASE     j   CREATE DATABASE airlines_vaseis WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Greek_Greece.1252';
    DROP DATABASE airlines_vaseis;
                postgres    false            �            1255    18680 P   status_check(character varying, character varying, date, time without time zone)    FUNCTION     
  CREATE FUNCTION public.status_check(ticket_no character varying, flight_code character varying, i_date date, r_time time without time zone) RETURNS character varying
    LANGUAGE plpgsql
    AS $$
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
    $$;
 �   DROP FUNCTION public.status_check(ticket_no character varying, flight_code character varying, i_date date, r_time time without time zone);
       public          postgres    false            �            1255    18679 !   sum_total_book(character varying)    FUNCTION     �  CREATE FUNCTION public.sum_total_book(book_r character varying) RETURNS double precision
    LANGUAGE plpgsql
    AS $$
        DECLARE 
            summs DOUBLE PRECISION;
        BEGIN 
            SELECT sum(t_tprice) into summs FROM ticket WHERE book_ref = book_r;
            UPDATE book SET book_tprice = summs WHERE book_ref = book_r;
            RETURN summs;
        END
    $$;
 ?   DROP FUNCTION public.sum_total_book(book_r character varying);
       public          postgres    false            �            1255    18677 #   sum_total_ticket(character varying)    FUNCTION     �  CREATE FUNCTION public.sum_total_ticket(ticket_no character varying) RETURNS double precision
    LANGUAGE plpgsql
    AS $$         DECLARE             summs DOUBLE PRECISION;        BEGIN            SELECT sum(t_price) into summs FROM ticket_flight WHERE t_no = ticket_no;            UPDATE ticket SET t_tprice = summs WHERE t_no = ticket_no;            RETURN summs;        END    $$;
 D   DROP FUNCTION public.sum_total_ticket(ticket_no character varying);
       public          postgres    false            �            1259    18552    aircraft    TABLE     -  CREATE TABLE public.aircraft (
    airc_code character varying(3) NOT NULL,
    airc_name character varying(20) NOT NULL,
    airc_capacity integer,
    airc_range integer,
    airp_code character varying(3),
    CONSTRAINT aircraft_airc_code_check CHECK (((airc_code)::text ~ '^(\d{3})?$'::text))
);
    DROP TABLE public.aircraft;
       public         heap    postgres    false            �            1259    18544    airport    TABLE       CREATE TABLE public.airport (
    airp_code character varying(3) NOT NULL,
    airp_name character varying(20) NOT NULL,
    airp_city character varying(20) NOT NULL,
    airp_timezone text NOT NULL,
    CONSTRAINT airport_airp_code_check CHECK ((char_length((airp_code)::text) = 3))
);
    DROP TABLE public.airport;
       public         heap    postgres    false            �            1259    18660    boarding    TABLE     {  CREATE TABLE public.boarding (
    airc_capacity integer,
    board_no integer NOT NULL,
    board_seat_no integer NOT NULL,
    t_no character varying(13),
    t_pass_fname character varying(20),
    t_pass_lname character varying(20),
    fl_code character varying(10) NOT NULL,
    t_fl_date date NOT NULL,
    CONSTRAINT boarding_check CHECK ((board_no <= airc_capacity))
);
    DROP TABLE public.boarding;
       public         heap    postgres    false            �            1259    18621    book    TABLE     �  CREATE TABLE public.book (
    book_ref character varying(6) NOT NULL,
    fl_code character varying(10),
    fl_date date,
    book_date timestamp without time zone NOT NULL,
    book_tprice double precision,
    CONSTRAINT book_book_ref_check CHECK ((char_length((book_ref)::text) = 6)),
    CONSTRAINT book_check CHECK ((((fl_date)::timestamp without time zone - book_date) <= '1 mon'::interval))
);
    DROP TABLE public.book;
       public         heap    postgres    false            �            1259    18567    flight    TABLE     �  CREATE TABLE public.flight (
    fl_code character varying(10) NOT NULL,
    airc_range integer,
    fl_distance integer NOT NULL,
    depart_airp_code character varying(20),
    depart_time_sche time without time zone,
    arr_airp_code character varying(20),
    arr_time_sche time without time zone,
    fl_duration time without time zone GENERATED ALWAYS AS ((arr_time_sche - depart_time_sche)) STORED,
    fl_status character varying(15),
    CONSTRAINT flight_check CHECK ((fl_distance <= airc_range)),
    CONSTRAINT flight_check1 CHECK (((depart_airp_code)::text <> (arr_airp_code)::text)),
    CONSTRAINT flight_check2 CHECK (((depart_airp_code)::text <> (arr_airp_code)::text))
);
    DROP TABLE public.flight;
       public         heap    postgres    false            �            1259    18611    flight_arr_act    TABLE     �   CREATE TABLE public.flight_arr_act (
    fl_code character varying(10) NOT NULL,
    arr_date_act timestamp without time zone NOT NULL
);
 "   DROP TABLE public.flight_arr_act;
       public         heap    postgres    false            �            1259    18591    flight_date    TABLE     k   CREATE TABLE public.flight_date (
    fl_code character varying(10) NOT NULL,
    fl_date date NOT NULL
);
    DROP TABLE public.flight_date;
       public         heap    postgres    false            �            1259    18601    flight_depart_act    TABLE     �   CREATE TABLE public.flight_depart_act (
    fl_code character varying(10) NOT NULL,
    depart_date_act timestamp without time zone NOT NULL
);
 %   DROP TABLE public.flight_depart_act;
       public         heap    postgres    false            �            1259    18633    ticket    TABLE     �  CREATE TABLE public.ticket (
    t_no character varying(13) NOT NULL,
    t_pass_fname character varying(20) NOT NULL,
    t_pass_lname character varying(20) NOT NULL,
    t_pass_id character varying(15) NOT NULL,
    t_pass_email character varying(50) NOT NULL,
    t_pass_tel character varying(20) NOT NULL,
    t_pass_addr character varying(40) NOT NULL,
    t_tprice double precision,
    book_ref character varying(6),
    CONSTRAINT ticket_t_no_check CHECK (((t_no)::text ~ '^(\d{13})?$'::text))
);
    DROP TABLE public.ticket;
       public         heap    postgres    false            �            1259    18644    ticket_flight    TABLE       CREATE TABLE public.ticket_flight (
    t_no character varying(13) NOT NULL,
    t_pass_fname character varying(20) NOT NULL,
    t_pass_lname character varying(20) NOT NULL,
    fl_code character varying(10) NOT NULL,
    t_fl_date date NOT NULL,
    t_price double precision NOT NULL,
    t_fare character varying(15) NOT NULL,
    CONSTRAINT ticket_flight_t_fare_check CHECK (((t_fare)::text = ANY ((ARRAY['Economy'::character varying, 'Business'::character varying, 'First class'::character varying])::text[])))
);
 !   DROP TABLE public.ticket_flight;
       public         heap    postgres    false            >          0    18552    aircraft 
   TABLE DATA           ^   COPY public.aircraft (airc_code, airc_name, airc_capacity, airc_range, airp_code) FROM stdin;
    public          postgres    false    210   PX       =          0    18544    airport 
   TABLE DATA           Q   COPY public.airport (airp_code, airp_name, airp_city, airp_timezone) FROM stdin;
    public          postgres    false    209   Y       F          0    18660    boarding 
   TABLE DATA           �   COPY public.boarding (airc_capacity, board_no, board_seat_no, t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date) FROM stdin;
    public          postgres    false    218   �Z       C          0    18621    book 
   TABLE DATA           R   COPY public.book (book_ref, fl_code, fl_date, book_date, book_tprice) FROM stdin;
    public          postgres    false    215   \       ?          0    18567    flight 
   TABLE DATA           �   COPY public.flight (fl_code, airc_range, fl_distance, depart_airp_code, depart_time_sche, arr_airp_code, arr_time_sche, fl_status) FROM stdin;
    public          postgres    false    211   �^       B          0    18611    flight_arr_act 
   TABLE DATA           ?   COPY public.flight_arr_act (fl_code, arr_date_act) FROM stdin;
    public          postgres    false    214   0`       @          0    18591    flight_date 
   TABLE DATA           7   COPY public.flight_date (fl_code, fl_date) FROM stdin;
    public          postgres    false    212   ja       A          0    18601    flight_depart_act 
   TABLE DATA           E   COPY public.flight_depart_act (fl_code, depart_date_act) FROM stdin;
    public          postgres    false    213   Wb       D          0    18633    ticket 
   TABLE DATA           �   COPY public.ticket (t_no, t_pass_fname, t_pass_lname, t_pass_id, t_pass_email, t_pass_tel, t_pass_addr, t_tprice, book_ref) FROM stdin;
    public          postgres    false    216   �c       E          0    18644    ticket_flight 
   TABLE DATA           n   COPY public.ticket_flight (t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date, t_price, t_fare) FROM stdin;
    public          postgres    false    217   {       �           2606    18559 #   aircraft aircraft_airc_capacity_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.aircraft
    ADD CONSTRAINT aircraft_airc_capacity_key UNIQUE (airc_capacity);
 M   ALTER TABLE ONLY public.aircraft DROP CONSTRAINT aircraft_airc_capacity_key;
       public            postgres    false    210            �           2606    18561     aircraft aircraft_airc_range_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.aircraft
    ADD CONSTRAINT aircraft_airc_range_key UNIQUE (airc_range);
 J   ALTER TABLE ONLY public.aircraft DROP CONSTRAINT aircraft_airc_range_key;
       public            postgres    false    210            �           2606    18557    aircraft aircraft_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.aircraft
    ADD CONSTRAINT aircraft_pkey PRIMARY KEY (airc_code);
 @   ALTER TABLE ONLY public.aircraft DROP CONSTRAINT aircraft_pkey;
       public            postgres    false    210            �           2606    18551    airport airport_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.airport
    ADD CONSTRAINT airport_pkey PRIMARY KEY (airp_code);
 >   ALTER TABLE ONLY public.airport DROP CONSTRAINT airport_pkey;
       public            postgres    false    209            �           2606    18665    boarding boarding_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.boarding
    ADD CONSTRAINT boarding_pkey PRIMARY KEY (board_no, board_seat_no, fl_code, t_fl_date);
 @   ALTER TABLE ONLY public.boarding DROP CONSTRAINT boarding_pkey;
       public            postgres    false    218    218    218    218            �           2606    18627    book book_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_ref);
 8   ALTER TABLE ONLY public.book DROP CONSTRAINT book_pkey;
       public            postgres    false    215            �           2606    18615 "   flight_arr_act flight_arr_act_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.flight_arr_act
    ADD CONSTRAINT flight_arr_act_pkey PRIMARY KEY (fl_code, arr_date_act);
 L   ALTER TABLE ONLY public.flight_arr_act DROP CONSTRAINT flight_arr_act_pkey;
       public            postgres    false    214    214            �           2606    18595    flight_date flight_date_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.flight_date
    ADD CONSTRAINT flight_date_pkey PRIMARY KEY (fl_code, fl_date);
 F   ALTER TABLE ONLY public.flight_date DROP CONSTRAINT flight_date_pkey;
       public            postgres    false    212    212            �           2606    18605 (   flight_depart_act flight_depart_act_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.flight_depart_act
    ADD CONSTRAINT flight_depart_act_pkey PRIMARY KEY (fl_code, depart_date_act);
 R   ALTER TABLE ONLY public.flight_depart_act DROP CONSTRAINT flight_depart_act_pkey;
       public            postgres    false    213    213            �           2606    18575    flight flight_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_pkey PRIMARY KEY (fl_code);
 <   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_pkey;
       public            postgres    false    211            �           2606    18649     ticket_flight ticket_flight_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.ticket_flight
    ADD CONSTRAINT ticket_flight_pkey PRIMARY KEY (t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date);
 J   ALTER TABLE ONLY public.ticket_flight DROP CONSTRAINT ticket_flight_pkey;
       public            postgres    false    217    217    217    217    217            �           2606    18638    ticket ticket_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (t_no, t_pass_fname, t_pass_lname);
 <   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_pkey;
       public            postgres    false    216    216    216            �           2606    18562     aircraft aircraft_airp_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.aircraft
    ADD CONSTRAINT aircraft_airp_code_fkey FOREIGN KEY (airp_code) REFERENCES public.airport(airp_code) ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.aircraft DROP CONSTRAINT aircraft_airp_code_fkey;
       public          postgres    false    3214    210    209            �           2606    18666 $   boarding boarding_airc_capacity_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.boarding
    ADD CONSTRAINT boarding_airc_capacity_fkey FOREIGN KEY (airc_capacity) REFERENCES public.aircraft(airc_capacity) ON DELETE SET NULL;
 N   ALTER TABLE ONLY public.boarding DROP CONSTRAINT boarding_airc_capacity_fkey;
       public          postgres    false    210    218    3216            �           2606    18671 G   boarding boarding_t_no_t_pass_fname_t_pass_lname_fl_code_t_fl_date_fkey    FK CONSTRAINT       ALTER TABLE ONLY public.boarding
    ADD CONSTRAINT boarding_t_no_t_pass_fname_t_pass_lname_fl_code_t_fl_date_fkey FOREIGN KEY (t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date) REFERENCES public.ticket_flight(t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date) ON DELETE CASCADE;
 q   ALTER TABLE ONLY public.boarding DROP CONSTRAINT boarding_t_no_t_pass_fname_t_pass_lname_fl_code_t_fl_date_fkey;
       public          postgres    false    217    217    217    218    218    218    218    217    217    3234    218            �           2606    18628    book book_fl_code_fl_date_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_fl_code_fl_date_fkey FOREIGN KEY (fl_code, fl_date) REFERENCES public.flight_date(fl_code, fl_date) ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.book DROP CONSTRAINT book_fl_code_fl_date_fkey;
       public          postgres    false    215    212    3224    215    212            �           2606    18586    flight flight_airc_range_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_airc_range_fkey FOREIGN KEY (airc_range) REFERENCES public.aircraft(airc_range) ON DELETE SET NULL;
 G   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_airc_range_fkey;
       public          postgres    false    210    3218    211            �           2606    18616 *   flight_arr_act flight_arr_act_fl_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight_arr_act
    ADD CONSTRAINT flight_arr_act_fl_code_fkey FOREIGN KEY (fl_code) REFERENCES public.flight(fl_code) ON DELETE CASCADE;
 T   ALTER TABLE ONLY public.flight_arr_act DROP CONSTRAINT flight_arr_act_fl_code_fkey;
       public          postgres    false    214    3222    211            �           2606    18581     flight flight_arr_airp_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_arr_airp_code_fkey FOREIGN KEY (arr_airp_code) REFERENCES public.airport(airp_code);
 J   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_arr_airp_code_fkey;
       public          postgres    false    209    3214    211            �           2606    18596 $   flight_date flight_date_fl_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight_date
    ADD CONSTRAINT flight_date_fl_code_fkey FOREIGN KEY (fl_code) REFERENCES public.flight(fl_code) ON DELETE CASCADE;
 N   ALTER TABLE ONLY public.flight_date DROP CONSTRAINT flight_date_fl_code_fkey;
       public          postgres    false    211    212    3222            �           2606    18606 0   flight_depart_act flight_depart_act_fl_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight_depart_act
    ADD CONSTRAINT flight_depart_act_fl_code_fkey FOREIGN KEY (fl_code) REFERENCES public.flight(fl_code) ON DELETE CASCADE;
 Z   ALTER TABLE ONLY public.flight_depart_act DROP CONSTRAINT flight_depart_act_fl_code_fkey;
       public          postgres    false    211    3222    213            �           2606    18576 #   flight flight_depart_airp_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_depart_airp_code_fkey FOREIGN KEY (depart_airp_code) REFERENCES public.airport(airp_code) ON DELETE SET NULL;
 M   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_depart_airp_code_fkey;
       public          postgres    false    3214    211    209            �           2606    18639    ticket ticket_book_ref_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_book_ref_fkey FOREIGN KEY (book_ref) REFERENCES public.book(book_ref) ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.ticket DROP CONSTRAINT ticket_book_ref_fkey;
       public          postgres    false    215    216    3230            �           2606    18655 (   ticket_flight ticket_flight_fl_code_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_flight
    ADD CONSTRAINT ticket_flight_fl_code_fkey FOREIGN KEY (fl_code) REFERENCES public.flight(fl_code) ON DELETE CASCADE;
 R   ALTER TABLE ONLY public.ticket_flight DROP CONSTRAINT ticket_flight_fl_code_fkey;
       public          postgres    false    211    217    3222            �           2606    18650 ?   ticket_flight ticket_flight_t_no_t_pass_fname_t_pass_lname_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_flight
    ADD CONSTRAINT ticket_flight_t_no_t_pass_fname_t_pass_lname_fkey FOREIGN KEY (t_no, t_pass_fname, t_pass_lname) REFERENCES public.ticket(t_no, t_pass_fname, t_pass_lname) ON DELETE CASCADE;
 i   ALTER TABLE ONLY public.ticket_flight DROP CONSTRAINT ticket_flight_t_no_t_pass_fname_t_pass_lname_fkey;
       public          postgres    false    217    217    217    216    216    216    3232            >   �   x�e���0�ϳc����w�R� J��@�Oo�I�q2?_ƈE�s��nyLi�
��9��%fAץ��4�Q�>ld��mzű�#C+�
�4�^0�S���2�¶��N�cJqY��������Q�����#CAJ5�/�Te}�9 D}{?���>��_5\2]OD��+C$      =   �  x�m�Qn�0D����	���\4m\;-PF�JڈZ�$K:}F!�??3o0;��̟�8Q��c���.�3���~�����]��R�ζ��m�X�D��������J��]�j�)���_��	1(\>=�lak1sNyDU�@"}nX�3�~�|h�2=O)48��7�Zy��krI�'˗x����j��\9�g< ��#�G�����4��?!���1$f�3=�<у��p��t�'�rƏl�c~�K�e��b�jN�1WDZu5k:U�5uG���>�ж��J�7S!�}�]��U޶���ʢ�����#m�N�6�;_����D�W_�]��b���6'�73ǂE�0*��A{K�6����6��~y��      F   t  x�}�OO1��������9�u50UR��l�@�!�fg�駯�B�f�����U�e�Rh�!��]�۲��n����wЍ�gM{��J	�E��Z�ơ�ML?�q`ؔ�b~��B	�Gwc�cr��a����Kx���P�:r]�⴮\u�h}57�[�u
#O���C�q��*돞NP����p�۴�eֈ�6�����!���sZ��2+�z�G8d�(�i�tu"j�E-�r��]��p7��$�E⦍�C��q��K�##/�T��#x,c��8�SX+��E��B��*my���K(�b��i>��
�-�.y��Ra*Y2��ϻ���?~�M{kj�$�����|�������j��=���      C   �  x����n1 ���)x�"{�w�!J�"E?B����K)ʦn��3�P젉V�r������M�^hޞ�-�.�;�Հ8�ݙ����gҽ����QF
c� �E��(ҀC�pFA᪘�!;\m�8�����(�H��7��]Φ�I
�}�[���,h�'o�Ҳ:��@�g�@p�94)>Nel1�1D� {!�b�^�y�t&��8���l�4_>����QU��9�֢�Y�u�P���$�t %5CB�Ш��8�����-Ǔ,j��m��*'�!y��5�Q'�cP�]o(s���z��~��LA1�2��Na��-G�i�Zǚ�mPF$\���'�"��@�r�]��vvǙ��1��@��qF,B�ƱCd�P:�M��@����Pm�l�"ɣ�q2�9�IY�c֬���q�hLGB�H��?/�	T�%��-�����e��ei��p��N~<���N����@݁1��0x	�hv���H�ޕ�O��L��>��k��w���@1�앎��֣�����_���2�R#i��uR�bB{�	i�bMU�z`�ж�a1e�}o@��~��Q廤�W4{��T�;0���	S?�(%�WͰ����ϫΕ)6q���}>�t�e`2k�Ef<̈́|�o���Fǘ74�\gWn���Z�����M�~L+�W�
8񉪪V�� n^
!�1�h!      ?   6  x�U�]o�0��?fi��;�s���b��e7�mED1���׏��˓���}��E��R=�P
$�% ��"}� �� 3lw���Jpo��JI!��A� �0MCK�Z8Jq����@B'(p���wh�4e�g�g��˛E����-�� aǯ���$����b������P�|��?G�,�l��k�9���:�6�icH�fX���������1��F�cк5�H�z0������[D^*^;� �LLc�ɜ�w���e�]�����iw����?�TM�F����h�m&����_����      B   *  x�}��N�0�3}������I�bSEE��@��PF*⣠>=M4� %9�jǍ�Y����.����h�D�P� ��ÅfFF�Vcf�T��>�ǻ���2KQ�X���9�2�|���j��owr�2&La{��{��j��pnx������6�gC�����=L�<5��&�4��f}8����BI_g!fq.4g`t�W��U�����i�4Y1�ab'�W�K���Tg'�6F���1�v�v���h�����Y�2�(O�Fv���s.V7�B��h��c7L�3�����}���p�$�/nd��      @   �   x���Qk�0�����Hnj�<��`�C�D��Q�Z���U�����{���Nn6��a����Ăy$�HhʀZ����I��6��9j�r�Ůpn(�[��HY@e�!������=�{TF�HT�ti�:L��6v�PT�T*�}�y�j���ih)Ӳ<����oc�4��T!���m붯�k"�j�J�4����S����j�!�(���w�7/�>E�D�c��      A   +  x�}��N�0�3y��@�x�%�і*""�b�R�����X���E�!��<�ż�����Ng�g S@�� $�	�Qfg�8�Ln�w��S�8K7B�'�{�)�4Xy�ܖEї�OH��1��q�#���r������CqmR��%�n0m@�O�`9�"������!,t(.'9��v,(f>-�㕭[[�h��x-S�<k���8Vc(~U�6��6�s�[�؝C��������n��u�ա5�)��7�*�L:FA0ʐ�}��ru��*����;g�s������ύp<���$I� K��y      D      x�uZI��F�>g�
��Џ�����6�������ysI I,4 �B���"��v��.�Ȓ�̈o����T+��=��`د�X�ibZ���p�B�C���7�vBĻX�;�&K��fp��u�W!�j�*�GR*�e��X��f�k�ގ־X��X�U+Y����cs4幙�q���]�Ý�Ŏk��N�$x;6f�F;�����X� ����>R*�#�H�kJ��t�Rc��������E���\i��rk�H����w<V	��$��7�0����8ae�S�")�X�Я�Jk�3�k[��e��t67���5�"��������{��ȓ'<f�>�J���yƞ̌�	��E����%�	�����X�,{��k\Ű�HU���f�i]�����c�(��H"�TJ��0
�5��c��K��<��yM?%${��ذ��W�mpƱ���Q�b�1�NG|�G[��ߤF&1~�p�P�ǅ��C|1��qĪ��#� ����PZ����_O�7αHɘ�n}J2���ط{U�(�)��bl���Ä_��μ�.�(���Y��t"���0��.���ǎ��-��+�m!�Lo^��eZ#%�Nh�S\�X����`/L�jRU�R>P�C �2��L����ghg���g�9{Y��pM��p�S$��t(D���>��c�fy9�{�"O�W�#�"���p֖�;u�BmzVK��U�/okyf\e�}3���$�)�}�"E�2x>��x�>���@��(7�ޟ*K�X�fs$:\��ڪ���^/�v����%�OJ��a�K��_ �Ҳ�Dſ9[�7*[���s$���#��f��Xd�JU�U�T�l*�%��̣)�vq�BG=�i(G�4�Ŝ(��q�&* ����P�`S��n����� _Z�n�Ѻ�V�r436~n�5a!�*����%)��`��%P���o��D���� �@�硳T�Z�@�~�c�U�Pu7�@ �	`B�e��{�Y�CE�����и
���spxA�a����5�L�Z�!+�v0J^�rW�3��U|��y�7]��I4�����,R���0��_�!Ƽ\rDS��u��
�n�t�	��->5���2���`n/+]�
��	%
H��z��|h�`�DѬ��R��Ma�a8��&�T�NK�L� 47�cS"�Vx�f��ݘ0Q7#�H'�	��߻�l�n`9�[W��ör��[$����v����H��|��t����*)R��±gS���Fe�����4ӊ���F���]�)J<IS&�5#�d�����T�Ue��Po5�P܈�����<������d�{������H�wa�M�7��Ի ��_ˎ# E�Q��({c��v@]M1�3öI��c�3S\W�Yi��h��T�e�]��%�zG_��"��,+O�
]��Ϝ�1��#|�'3S+]FSc\V�b�+d�u�iz����02NqHh[KU�q����G
�g�!S)���8�mK��ϧ"���A���s����fS���ٔ_nK��&(oD��?�����dc���<d!�<Ƣ�� j�or�a�,����~a�.�q�"�)�(�2�z���^�e=b�3�Py|�S�*�m(�Hخ_섎�X~ʵ:-����2głJ/�?n��"���)v�#^�<�������8��|9�'�=q��I�y��`�s �E�~iq6�3�f�c���� 	&<e<	>��������4k��M|��t߆��J�gy�Z���%=/Y�_�+�&�;  ճda$8��/`��4���P�U>����h�y<�qޞ����1j"Ƞ*�/Y���M�����D�Q	�2���\!(�UA�y�F�Sg&�mʆ}A��	�t��ڱ���<�z�㸢tD��	pD������l�QĒ�s �򬦥�������]J|y�w�3�M3��2�)K�3 ��0�Ҹ�P�hAr1�Y�S����$0io�u�R��if�׹\��"�~���~6�{~�@oG1�4p,�/�঵���j_Y��tD`����Lt�b��i��6j���ev�LG;N�nI�<�et�讝�&����q)(�B�֯�A Z����F3�;����Ċj[�*[�.w�!��/�	��t:xNW���[�#�r�Ҙ�Y"g����~3eC�3j7�p�q]����I��ȹ4����5%�Ȫ��t^����7$�?N�	�}1���QO�2�nK<�P���js�^0P�l�`a~�g0ٍ�i,WJ~�R�$u*��Qז}[ #�rq��E�#Vx�8���3�w\)��0bQ�i�U�QV�%��l^���T R�^�ްts��M���~��P�{{Dg�վ�y���<�|,R��}Lx*�!������! fx����; ܁��_�&���;��c{�Q��>K�!�V���p!�v�?�br2�m��+z��yn���2(��5����_,ȁ��Ð'LB?�fb��U�F�@]��Ay��	��o�F��༚��jג��A1�k��Қf�:�ܫ>��#�$xKՕ��D�ڂ��'��FCg�V@����s=���}��ۖx�y�M���� ��8gX�_N��d��83�ξ�cU$�>�W���T������6{i����H5��R�?�[�R���F}>��P��H9&s���#d�i�W.r�ӎ5����q���H�]"i�|<����'(��kI��(�wh����;�pF'��V��!���"יR)B�'HL��Eu��?E[��jʈ� R�Wp��jVV��P��;J���I$TM����\(
>��KR�w@��C���$ѸL����"Z����8��?���#��C >�TD!��z�-�x�R̫�ӰL�2\1�v�|n�Ge3�4vֱ6ߖD���y�N���U
mE�.�C(�f��H���I�� �p�>L�L���g �-�.#���(�\Vt��%4��1|����p강���vr:!Q�HB��%��i1�d�K�z�l������i�i:[��u(v�
�iFΖ��T���P:����S:ھ7�=Lgs�e�g��VD�oi����E@�p�L� y���W�HZ**G���44����m�&��~���.�8+!����r3$���NYQ�B]��M�x�D܄�~ ?����GRv�k��e}�.�*�mQ#ਾR&�g�!)i�Tk`c?l2�*΅�y�Bи��B󤷦�n��Y�PY��%~��qs7 d���@�+���+��h��D��ʇ}i���@x��0�8pv�Ļl�eA���]�%v0�́�J��୙��0���{\�5簸@��(w�$&�̉����-;����a�;�F��Y� zD�X"F�̽�y(X��?� ������>^h�DIض��%�g��a��mMd�����l�M�'2��@���)���7O�׸ F� |�9��
<�1�li!a�?~W"gF3�xlK������p�O�)�_����w1hA$!y�_�%x�vv�<�ל#�r��GR�%�y��,X�U��1��T�J�П��	c�AH:l�&�~���7vc�0f���(&2 �����d@V�H����Q.~�ϸ�;��hĔ�����.��][@w�6��=8�7�\�p�D�,�\ TE�~];e�����#���F�]
���%	0N!��/����������4�M���o;���;B��qtJ&�����tf��T�8*'�!���i����&s�+ 	iHJ."�
=Ґ>��	�l��6�t*�@�u�M�]��M����l��6�t_���}?��~���"Rн�Qp���K��8���O2�c+�Y(?tJȥ�pv�������MG�n��j�Ŏ��m��B��_�&Kg-�Z�����f׺C	pam_�AK��ph�a<L�S�n���H`j�*StI���W\wǗ����	��xG>j$�a�\�q]�.3%�����}@ۡ�l)������ߡ]�!?�mG��$�6�d��n���ssٺ
���u���,IA�p	n [  aځ��zM>�<�'�S�h�*?A�"\[���k�������WƦ���>T.Dz)A)
4����#?\;�X���t�}@�o�t:�k)�>�G�dSה��盎��5 ?��Lh�=� s{)�#b��R��CWZ�`6�K7/m���%�f46 *��k�ʏ9��VW�tA���!�KH `��Y���'V���U��9�
?f�v\�|m0������&/��O���i�u~�m�ݬ����$�ꯍs�ifH=��>��h4�#+F�3����:=�k'������P@q����;���ᔒؓx��e(T��JP����BMv\���ٟ9��$#�mؚ���&z���&<�c����BF�f����+�ɠ�����
��¯�)��Y)�"���E���R?�F?A�;�
A���T� �j�ap��i" ��dvu���g>g9v�n�t'�B�"L_��{ꬭ�oQ�(%oM,$ɹ��i�T���L;A��)�᠇��g��̛(�!9<hB|�*~�S�9\
"#rAR؃�k�����]�*讨d���sv*��` �<�)�[����R�u\��mi��c���FXh�zaь�bT�\W�%�p��8S��x//�n�*�~��^�i��/@}�J��f������Z.�_@�Iɜ����|u��u�G"b"IE��֝��חtI�	���.j~�h��\XUWD1sD�g/�2_ _!�s|�f�\NLӃ�h�E ������#�[H��$��H���k�|��F��Ŷ��_���!e��j�iS5d��(
CH�G��2du w��"3T&�%Ǎ��A���lG�z��"D����I'IVA�2��H���z�vKi�A��fD"���u3��i�|Pt�˦����.��2@o�T�%*\���|O}:�r�U A��^����&����P�1zCd��U�mI�l4���sd��U	�J��?�)��b��n�H4� ��m�<��8��.�^�ŗ����,��B�H'��Aw5:�;��0��D.V�IՎZ�x1��h����TZ��ۚ(��0ᰆӕU$����!��� i$(�ʸ��݂��a��2@&�)��<�ș��t��h�ô.�����+Y��.�1|�>��w0�G�5�5��z\�N_W�a���E��nY��5a3婿�e���N�5)(X�{����d�*/I#�5R���>7���v�_T���WDEBfl�#[Z�.T$�I�ZM��]?�X���[ ��(����vD�� ��-�T�/�Tº\�%Qg���+>���`G�qN��C��}��� @�~��?���a� ��U#/�%;�ۚh2ԇ����� q�2����A1�.n�M}�y%����(|�-��էf:�f�[u����_��sA�4��^Bh��U���_q��v�����T4����ö����'�D␕����&��aS�[���<B�AJ@�m������{C-���9u�=�At,�+�n8�7x��"R���� 	��A���W!�:�Љ�?���#��\�q�����%k��I�]���͙�!�)+�WD�$��}i��{0I�K�m�=�@ď�\�NuSz��D;%=�q���{�ZR�}J�v���ߐ
�9�ʫ��)-铣�4��I��ԡ�}j������˫A��@/EQ���,G"+붓z��������Jz��3{3(=T�\l+�xW�< �P��3d��>�Os�k��J
p�iG��	�ײ��F!�zM�?�?2��� r>`x�~�����)����/�r%���~Ӿ��h��i����XֹЬj��3�[��Z����@���7Y�Ċ��������_�C      E   �  x��Y]s�8|F~E��i�$ �G[�㳭$g�ݭ{�D�BD^�������"�G.uwUR�U���L�L�J1�r:�R��Ma˭a_|eKӰ�]\_�.���d�$?M���S6�$�҅�~�*LU��N5�))W���}4!����+s�:������L��+�T��2o�¶�����:��k�^�$	P�.GH%5�&�ڰ����0���.�5�)R��ٍq�m�oMp�ue����Ed"4?8�;Sv�r�b��2�.V�����(��+���&��d義k[� ��x��*|p��A��}{�&"�G�l�	me�+�a|s.�����w�quy
T�����	�(�6 { �9��2ZI.��ln�K�Ej_�~����v�,~���d`��� HL_-��?�H����$c2)�T�lfH�ǡ��]̽y�|����q}x�������O���Пę��r���b��m�f�Wk[�l:�s�����A��0)�yS��b	�r�Ux��q�0��Xvռ��.a�ppLp�\(�]�.g禨�?�V�H)�4�j/|n-�|���ݕ+��N����=;["�w�)Q}�h� �����=^���:��8������K�`�F�J�"�l>��-��؝)����LG_�n�<>D����
� >9�	ǓX2��̄�*H}Fh���*y����
�	0oa
D̲y�>��R��rT#I�ͣ�n����/}�#���M�N�Ŗ��)�.l�H��S=x�H�]p���M-U�~��!�Z)D@?�����S��&�O���=��t�.(�߃�v�Q�S՟(@������
ױe=����R\���m�ÞSo]�LX*��O��	R�	 �e�
���
�:��=}�`ߙܰ��|�-9T5�:��{�2�bu�؁R��c�����A�3Z�^Ǯ|],��q�x49��Ԕ�`6C�F'[��ΝApw�+U��`v��99`2�����ư϶��<9�:m-�7p��nٵ���j �6t߯��7��xl|�͖}�\|['®��ݹ8�B�����}��0G�v'BU�^�,Eh���&�i�T����0�fW���"]���r��#YSE�ѓJ�+��/ � T{b)YjTxx��L������Q�t��D,��5���5�v ��(
�Y��Ea��[vv��,����<,�t��4q���
$3�#Q��#C#�A ��p4D��z�Mݻ�bbr���,v	/	�Zx˾�+;�<0\g:�;!;BM�̃{}u}�i��㉉ܻw��Q��������0v�ߓ�g?�.��
ۺW%�X.��#���N�~������#��H��Y�V�s�s�[m��1�I��0��.S�/
�=���d��g*�qC-
��>�1���1L���0`|m�n`��tAVF��<�aa`���9.$��TP;٢�x��[��`@"9�u�Tݖ��P�]���`���������Q�ˊ&���ɜ���}�宂���v�rw��qL�X��.r�=�5(E'\{���\N�.��g��V֭�v���C��ծBϚ5EM���co+
���}���"�®��ϡzh��Q��`�mK���G�G��w�2iwv�%xVXH3�_E!�� �kB[`6Z�~nLn����Q�y4�/���(�S-�!Ԃ�fS8�e�14������H	�`40���V�|ĳK�R����3F<�\BF��glw����)!��G 4A��S��XH����	�<�E�Lk��0�T�e�Bq_�"a�����f|�w�SzH�}\$�:~g �2H��抢&"�%��P�Va㟩K0�Bb�Fm��x�4�Gb����WL]�"#_�6&��v%A��
*q�(ɰ��#s����8�ƨ����o����|�م��=� NS����(5/�����(���Fw�����	�����`cĞ֡��|���ՌC�.�����<=m\��Rg�'��\�����KW?�C��s�TOs�p�K�4�*���w�7�4���y��{Օ�����]0=Y�ޱ3��f��Y�������G<��.L��	�
'���E
7�?z�0Oy�Q8�l��*���@\�7�;t#N;�?M��]�KM��cxdK���~uEN�D�Y�ڟ�9�=�.L�e��f�e�M٫��1ˎ6��_���C�e�cc�ҋ��,K`2}x�������[�����?߽{�S\�     