create table user
(
    id        int auto_increment
        primary key,
    user_name varchar(30) not null,
    password  varchar(50) not null,
    constraint user_name_uindex
        unique (user_name)
);

create table template
(
    id                  int auto_increment
        primary key,
    name                varchar(50)  null,
    iconUrl             varchar(100) null,
    primaryOwnerProfile text         null,
    user_Id             int          null,
    constraint template_user_id_fk
        foreign key (user_Id) references user (id)
            on update cascade on delete cascade
);

create table channel
(
    id         int auto_increment
        primary key,
    name       varchar(80)  null,
    topic      varchar(250) null,
    purpose    varchar(250) null,
    templateId int          null,
    constraint channel_template_id_fk
        foreign key (templateId) references template (id)
            on update cascade on delete cascade
);

create table user_role
(
    id        int auto_increment
        primary key,
    role_name varchar(30) not null,
    user_id   int         not null,
    user_name varchar(30) not null,
    constraint user_role_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

