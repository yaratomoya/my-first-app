# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table products (
  id                        integer not null,
  name                      varchar(255),
  price                     integer,
  constraint pk_products primary key (id))
;

create table task (
  id                        integer not null,
  name                      varchar(255),
  period                    timestamp,
  constraint pk_task primary key (id))
;

create sequence products_seq;

create sequence task_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists products;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists products_seq;

drop sequence if exists task_seq;

