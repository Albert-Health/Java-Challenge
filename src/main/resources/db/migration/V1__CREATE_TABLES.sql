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
     description    TEXT,
     created_at     TIMESTAMP,
     deleted_at     TIMESTAMP

  );

