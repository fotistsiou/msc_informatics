CREATE TABLE airport(
    airp_code VARCHAR(3) CHECK (char_length(airp_code) = 3),
    airp_name VARCHAR(20) NOT NULL,
    airp_city VARCHAR(20) NOT NULL,
    airp_timezone TEXT NOT NULL,
    PRIMARY KEY(airp_code)
);

CREATE TABLE aircraft(
    airc_code VARCHAR(3) CHECK (airc_code ~ '^(\d{3})?$'), 
    airc_name VARCHAR(20) NOT NULL,
    airc_capacity INT UNIQUE, 
    airc_range INT UNIQUE, 
    airp_code VARCHAR(3),
    PRIMARY KEY (airc_code),
    FOREIGN KEY (airp_code) REFERENCES airport ON DELETE CASCADE
);

CREATE TABLE flight (
    fl_code VARCHAR(10),
    airc_range INT,
    fl_distance INT NOT NULL CHECK (fl_distance <= airc_range),
    depart_airp_code VARCHAR(20) CHECK (depart_airp_code <> arr_airp_code),
    depart_time_sche TIME,
    arr_airp_code VARCHAR(20) CHECK (depart_airp_code <> arr_airp_code),
    arr_time_sche TIME,
    fl_duration TIME GENERATED ALWAYS AS (arr_time_sche - depart_time_sche) STORED,
    fl_status VARCHAR(15),
    PRIMARY KEY(fl_code),
    FOREIGN KEY(depart_airp_code) REFERENCES airport ON DELETE SET NULL,
    FOREIGN KEY(arr_airp_code) REFERENCES airport,
    FOREIGN KEY(airc_range) REFERENCES aircraft(airc_range) ON DELETE SET NULL
);

CREATE TABLE flight_date(
    fl_code VARCHAR(10),
    fl_date DATE,
    PRIMARY KEY(fl_code, fl_date),
    FOREIGN KEY(fl_code) REFERENCES flight ON DELETE CASCADE
);

CREATE TABLE flight_depart_act(
    fl_code VARCHAR(10),
    depart_date_act TIMESTAMP,
    PRIMARY KEY(fl_code, depart_date_act),
    FOREIGN KEY(fl_code) REFERENCES flight ON DELETE CASCADE
);

CREATE TABLE flight_arr_act(
    fl_code VARCHAR(10),
    arr_date_act TIMESTAMP,
    PRIMARY KEY(fl_code, arr_date_act),
    FOREIGN KEY(fl_code) REFERENCES flight ON DELETE CASCADE
);

CREATE TABLE book(
    book_ref VARCHAR(6) UNIQUE CHECK (char_length(book_ref) = 6),
    fl_code VARCHAR(10),
    fl_date DATE,
    book_date TIMESTAMP NOT NULL CHECK (fl_date - book_date <= '1 mon'),
    book_tprice DOUBLE PRECISION,
    PRIMARY KEY(book_ref),
    FOREIGN KEY(fl_code, fl_date) REFERENCES flight_date(fl_code, fl_date) ON DELETE CASCADE
);

CREATE TABLE ticket(
    t_no VARCHAR(13) CHECK (t_no ~ '^(\d{13})?$'),
    t_pass_fname VARCHAR(20),
    t_pass_lname VARCHAR(20),
    t_pass_id VARCHAR(15) NOT NULL,
    t_pass_email VARCHAR(50) NOT NULL,
    t_pass_tel VARCHAR(20) NOT NULL,
    t_pass_addr VARCHAR(40) NOT NULL,
    t_tprice DOUBLE PRECISION,
    book_ref VARCHAR(6),
    PRIMARY KEY(t_no, t_pass_fname, t_pass_lname),
    FOREIGN KEY(book_ref) REFERENCES book(book_ref) ON DELETE CASCADE
);

CREATE TABLE ticket_flight (
    t_no VARCHAR(13),
    t_pass_fname VARCHAR(20),
    t_pass_lname VARCHAR(20),
    fl_code VARCHAR(10),
    t_fl_date DATE NOT NULL,
    t_price DOUBLE PRECISION NOT NULL,
    t_fare VARCHAR(15) NOT NULL CHECK (t_fare IN ('Economy', 'Business', 'First class')),
    PRIMARY KEY(t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date),
    FOREIGN KEY(t_no, t_pass_fname, t_pass_lname) REFERENCES ticket(t_no, t_pass_fname, t_pass_lname) ON DELETE CASCADE,
    FOREIGN KEY(fl_code) REFERENCES flight(fl_code) ON DELETE CASCADE
);

CREATE TABLE boarding(
    airc_capacity INT,
    board_no INT CHECK (board_no <= airc_capacity),
    board_seat_no INT,
    t_no VARCHAR(13),
    t_pass_fname VARCHAR(20),
    t_pass_lname VARCHAR(20),
    fl_code VARCHAR(10),
    t_fl_date DATE,
    PRIMARY KEY (board_no, board_seat_no, fl_code, t_fl_date),
    FOREIGN KEY(airc_capacity) REFERENCES aircraft(airc_capacity) ON DELETE SET NULL,
    FOREIGN KEY (t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date) REFERENCES ticket_flight(t_no, t_pass_fname, t_pass_lname, fl_code, t_fl_date) ON DELETE CASCADE
);