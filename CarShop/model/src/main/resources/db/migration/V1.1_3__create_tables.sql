-- Create by Dmitriy Tarasenko

set schema 'tachkischema';

drop table if exists brand cascade;

drop table if exists "cars" cascade;



CREATE TABLE "brand" (
	"id" bigint NOT NULL,
	"brand" VARCHAR NOT NULL,
	CONSTRAINT brand_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "cars" (
	"id" bigint NOT NULL,
	"model" VARCHAR NOT NULL,
	"color" VARCHAR NOT NULL,
	"price" integer NOT NULL,
	"brand_id" bigint NOT NULL,
	CONSTRAINT cars_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "cars" ADD CONSTRAINT "cars_fk0" FOREIGN KEY ("brand_id") REFERENCES "brand"("id");
