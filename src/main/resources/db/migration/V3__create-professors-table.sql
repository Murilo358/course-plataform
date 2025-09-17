CREATE TABLE professors
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(150)        NOT NULL,
    email      VARCHAR(150) UNIQUE NOT NULL,
    bio        TEXT,
    expertise  VARCHAR(100),
    created_at TIMESTAMP           NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP           NOT NULL DEFAULT NOW(),
    active     BOOLEAN             NOT NULL DEFAULT TRUE
);
