create table books
(
	id bigserial,
	title text not null,
	location text not null,
	author_name text not null
);

create unique index books_id_uindex
	on books (id);

create unique index books_title_uindex
	on books (title);

alter table books
    add quantity Integer default 1 not null;



