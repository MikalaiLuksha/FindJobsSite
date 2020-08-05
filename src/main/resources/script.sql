create table applicant
(
    id         serial not null
        constraint user_pk
            primary key,
    first_name varchar,
    password   varchar,
    email      varchar,
    last_name  varchar
);

alter table applicant
    owner to postgres;

create unique index user_id_uindex
    on applicant (id);

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


