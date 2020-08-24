create table "user"
(
    id       serial not null
        constraint user_pk
            primary key,
    login    varchar,
    password varchar
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

create table nationality
(
    id   serial not null
        constraint nationality_pk
            primary key,
    name varchar
);

alter table nationality
    owner to postgres;

create unique index nationality_id_uindex
    on nationality (id);

create table employer
(
    id         serial not null
        constraint employer_pk
            primary key,
    first_name varchar,
    last_name  varchar,
    email      varchar,
    phone      varchar,
    company    varchar,
    password   varchar
);

alter table employer
    owner to postgres;

create unique index employer_id_uindex
    on employer (id);

create table applicant
(
    id        serial not null
        constraint applicant_pk
            primary key,
    firstname varchar,
    lastname  varchar,
    password  varchar,
    email     varchar,
    birthday  timestamp,
    gender    varchar,
    telephone varchar
);

alter table applicant
    owner to postgres;

create unique index applicant_id_uindex
    on applicant (id);

create table applicant_nationality
(
    applicant_id   integer,
    nationality_id integer
);

alter table applicant_nationality
    owner to postgres;

create table profession
(
    id   serial not null
        constraint profession_pk
            primary key,
    name varchar
);

alter table profession
    owner to postgres;

create unique index profession_id_uindex
    on profession (id);

create table language
(
    id   serial not null
        constraint language_pk
            primary key,
    name varchar
);

alter table language
    owner to postgres;

create unique index language_id_uindex
    on language (id);


