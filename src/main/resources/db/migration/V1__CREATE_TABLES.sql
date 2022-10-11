CREATE TABLE users (
     id             SERIAL PRIMARY KEY,
     username       VARCHAR(255),
     email          VARCHAR(255),
     password       VARCHAR(255),
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP

  );
  CREATE TABLE slots (
     id             SERIAL PRIMARY KEY,
     user_id        Integer,
     description    TEXT,
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP

  );
  CREATE TABLE user_slots (
     id                 SERIAL PRIMARY KEY,
     user_id            INTEGER,
     slot_id            INTEGER,
     appointment_time   TIMESTAMP,
     created_at         TIMESTAMP,
     deleted_at         TIMESTAMP

  );

