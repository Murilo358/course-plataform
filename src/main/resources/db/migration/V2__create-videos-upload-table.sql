DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_type where typname = 'video_status') THEN
            CREATE TYPE video_status as ENUM (
                'waiting',
                'uploading',
                'ready',
                'errored',
                'expired'
            );
        END IF;
END$$;


CREATE TABLE IF NOT EXISTS videos_upload
(
    id                BIGSERIAL primary key,
    upload_url        TEXT,
    created_at        TIMESTAMPTZ  DEFAULT NOW(),
    status            video_status default 'waiting',
    error_message     TEXT,
    expires_at TIMESTAMPZ default (NOW() + interval '1 hour'),
    external_video_id TEXT,
    video_id          BIGINT REFERENCES videos (id)
);