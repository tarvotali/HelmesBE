CREATE TABLE IF NOT EXISTS user_table
(
    user_id        SERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    agree_to_terms BOOLEAN      NOT NULL
);