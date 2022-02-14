
CREATE TABLE post (
     id SERIAL PRIMARY KEY,
     name TEXT,
     description text,
     create_date timestamp default localtimestamp
);

create table cities
(
    id   serial primary key,
    city_name varchar(100)
);


create TABLE candidates
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    create_date timestamp default localtimestamp,
    city_id     int references cities (id)
);

