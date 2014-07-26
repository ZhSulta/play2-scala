# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "CAT" ("name" VARCHAR(254) NOT NULL PRIMARY KEY,"color" VARCHAR(254) NOT NULL);
create table "PERSON" ("id" BIGINT NOT NULL PRIMARY KEY,"name" VARCHAR(254) NOT NULL);

# --- !Downs

drop table "PERSON";
drop table "CAT";

