create table file_model (
                         id int8 not null,
                         name varchar(255),
                         mimetype varchar(255),
                         pic bytea,
                         primary key (id)
);