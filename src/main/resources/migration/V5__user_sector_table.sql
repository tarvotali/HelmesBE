CREATE TABLE IF NOT EXISTS user_sector
(
    user_id   BIGINT REFERENCES user_table (user_id),
    sector_id BIGINT REFERENCES sectors (id),
    PRIMARY KEY (user_id, sector_id)
);