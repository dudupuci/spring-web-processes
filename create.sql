create sequence hibernate_sequence start 1 increment 1;

    create table pessoa (
       id int8 not null,
        cpf varchar(255),
        data_cadastro date,
        data_nascimento date,
        nome varchar(255),
        processo_id int8,
        primary key (id)
    );

    create table processo (
       id int8 not null,
        ano int4,
        data_cadastro date,
        numero int8,
        primary key (id)
    );

    alter table if exists pessoa 
       add constraint FKnavabijyjkqnin4bupnckd6yj 
       foreign key (processo_id) 
       references processo;
create sequence hibernate_sequence start 1 increment 1;
create table pessoa (id int8 not null, cpf varchar(255), data_cadastro date, data_nascimento date, nome varchar(255), processo_id int8, primary key (id));
create table processo (id int8 not null, ano int4, data_cadastro date, numero int8, primary key (id));
alter table if exists pessoa add constraint FKnavabijyjkqnin4bupnckd6yj foreign key (processo_id) references processo;
create sequence hibernate_sequence start 1 increment 1;
create table pessoa (id int8 not null, cpf varchar(255), data_cadastro date, data_nascimento date, nome varchar(255), processo_id int8, primary key (id));
create table processo (id int8 not null, ano int4, data_cadastro date, numero int8, primary key (id));
alter table if exists pessoa add constraint FKnavabijyjkqnin4bupnckd6yj foreign key (processo_id) references processo;
create sequence hibernate_sequence start 1 increment 1;

    create table pessoa (
       id int8 not null,
        cpf varchar(255),
        data_cadastro date,
        data_nascimento date,
        nome varchar(255),
        processo_id int8,
        primary key (id)
    );

    create table processo (
       id int8 not null,
        ano int4,
        data_cadastro date,
        numero int8,
        primary key (id)
    );

    alter table if exists pessoa 
       add constraint FKnavabijyjkqnin4bupnckd6yj 
       foreign key (processo_id) 
       references processo;
create sequence hibernate_sequence start 1 increment 1;

    create table processo (
       id int8 not null,
        ano int4,
        data_cadastro date,
        numero int8,
        primary key (id)
    );

    create table tb_pessoa (
       id int8 not null,
        cpf varchar(255),
        data_cadastro date,
        data_nascimento date,
        nome varchar(255),
        processo_id int8,
        primary key (id)
    );

    alter table if exists tb_pessoa 
       add constraint FKaoyl4y9vai8j6a4wvr1x6h7h1 
       foreign key (processo_id) 
       references processo;
