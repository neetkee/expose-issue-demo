create table demos
(
    id        serial not null
        constraint files_pk
            primary key,
    demo_name text   not null
);
