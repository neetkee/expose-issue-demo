create table demos
(
    id        serial not null
        constraint demos_pk
            primary key,
    demo_name text   not null
);
