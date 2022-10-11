INSERT INTO users(username, email, password, created_at)
VALUES(
    'test',
    'test@.com',
    '123456',
    current_timestamp
);

INSERT INTO slots(description,  created_at)
VALUES(
    'Lorem Ipsum is simply dummy text of the printing and typesetting',
    current_timestamp
);