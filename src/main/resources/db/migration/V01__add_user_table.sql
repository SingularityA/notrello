CREATE TABLE user_credentials
(
    id         BIGSERIAL,
    name       VARCHAR(50)  NOT NULL,
    password   VARCHAR(60) NOT NULL,
    roles      VARCHAR(100) NOT NULL,
    registered TIMESTAMP    NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id)
);