CREATE TABLE device_tokens (
    id BIGSERIAL PRIMARY KEY,
    device_token VARCHAR(500) UNIQUE NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_device_tokens_user_id
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_device_tokens_user_id ON device_tokens(user_id);
CREATE INDEX idx_device_tokens_device_token ON device_tokens(device_token);
CREATE INDEX idx_device_tokens_deleted_at ON device_tokens(deleted_at);