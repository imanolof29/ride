CREATE TABLE rides (
    id BIGSERIAL PRIMARY KEY,
    passenger_id BIGINT NOT NULL,
    passenger_location geometry(Point, 4326) NOT NULL,
    destination_location geometry(Point, 4326) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,

    CONSTRAINT fk_rid_passenger FOREIGN KEY (passenger_id)
        REFERENCES users(id) ON DELETE RESTRICT
);

CREATE INDEX idx_rides_passenger_id ON rides(passenger_id);
CREATE INDEX idx_rides_deleted_at ON rides(deleted_at);
CREATE INDEX idx_rides_passenger_location ON rides USING GIST(passenger_location);
CREATE INDEX idx_rides_destination_location ON rides USING GIST(destination_location);