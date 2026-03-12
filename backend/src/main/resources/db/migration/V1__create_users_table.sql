CREATE TABLE users (
    id                    BIGSERIAL PRIMARY KEY,
    email                 VARCHAR(255) NOT NULL UNIQUE,
    name                  VARCHAR(255),
    profile_picture_url   VARCHAR(500),
    google_id             VARCHAR(255) UNIQUE,
    google_access_token   TEXT,
    google_refresh_token  TEXT,
    token_expiry          TIMESTAMP,
    created_at            TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at            TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_google_id ON users(google_id);
