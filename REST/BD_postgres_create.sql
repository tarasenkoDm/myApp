CREATE TABLE "Brand" (
	"id" bigint NOT NULL,
	"brand" TEXT NOT NULL,
	CONSTRAINT Brand_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Cars" (
	"id" bigint NOT NULL,
	"model" TEXT NOT NULL,
	"color" varchar NOT NULL,
	"price" integer NOT NULL,
	"brand_id" bigint NOT NULL,
	CONSTRAINT Cars_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "Cars" ADD CONSTRAINT "Cars_fk0" FOREIGN KEY ("brand_id") REFERENCES "Brand"("id");

