CREATE USER lms WITH PASSWORD 'lms';
create database lmsdb owner lms;
create table users
(
    id bigserial,
    username varchar(128) not null,
    password varchar(128) not null,
    enabled boolean default true not null,
    constraint users_pk
        primary key (id)
);

create unique index users_user_name_uindex
    on users (username);

create table authorities
(
    id bigserial,
    authority_name varchar(128) not null,
    active boolean default true not null,
    constraint authorities_pk
        primary key (id)
);

create unique index authorities_authority_name_uindex
    on authorities (authority_name);

create table user_authorities
(
    user_id int not null,
    authority_id int not null
);

create unique index user_authorities_user_id_authority_id_uindex
    on user_authorities (user_id, authority_id);