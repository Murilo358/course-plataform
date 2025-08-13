CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

CREATE TABLE courses
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    level          TEXT, --todo create enum
    category_id    BIGINT references categories(id),
    thumbnail_url  VARCHAR(500),
    total_duration INT,
    published      BOOLEAN     DEFAULT FALSE,
    requirements   TEXT[],
    professor_id   BIGINT       NOT NULL,
    created_at     TIMESTAMPTZ DEFAULT now(),
    updated_at     TIMESTAMPTZ
);


CREATE TABLE videos
(
    id                SERIAL PRIMARY KEY,
    external_video_id BIGINT,
    course_id         BIGINT references courses (id),
    title             TEXT,
    description       TEXT,
    total_duration    BIGINT,
    created_at        TIMESTAMPTZ DEFAULT NOW()
);