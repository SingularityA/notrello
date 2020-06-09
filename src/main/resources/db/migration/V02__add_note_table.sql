CREATE TABLE note
(
    id           BIGSERIAL,
    title        VARCHAR(50)  NOT NULL,
    text         VARCHAR(800) NOT NULL,
    created      TIMESTAMP    NOT NULL DEFAULT NOW(),
    last_updated TIMESTAMP    NOT NULL DEFAULT NOW(),
    user_id      BIGINT       NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user_credentials (id)
);