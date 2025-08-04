CREATE TABLE courses
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    level          VARCHAR(50),
    category       VARCHAR(100),
    thumbnail_url  VARCHAR(500),
    total_duration INT,
    published      BOOLEAN     DEFAULT FALSE,
    requirements   TEXT[],
    professor_id   INT          NOT NULL,
    create_at      TIMESTAMPTZ DEFAULT now(),
    updated_at     TIMESTAMPTZ
);
