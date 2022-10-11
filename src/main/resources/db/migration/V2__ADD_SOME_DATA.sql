INSERT INTO users(username, email, password, created_at)
VALUES(
    'test',
    'test@com',
    '123456',
    current_timestamp
),
(
    'guest',
    'guest@com',
    '123456',
    current_timestamp
),
(
    'host',
    'host@com',
    '456789',
    current_timestamp
);

INSERT INTO slots(description, user_id, created_at)
VALUES(
    'Lorem Ipsum is simply dummy text of the printing and typesetting',
    2,
    current_timestamp
),
(
    'Lorem Ipsum has been the industrys standard dummy',
    3,
    current_timestamp
),
(
    'ing, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containin',
    2,
    current_timestamp
),
(
    'professor at Hampden-Sydney College in Virginia, looked up one of',
    3,
    current_timestamp
),
(
    'literature, discovered the undoubtable source. Lorem Ipsum',
    3,
    current_timestamp
);