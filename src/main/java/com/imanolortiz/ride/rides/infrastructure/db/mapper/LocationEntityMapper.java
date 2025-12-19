package com.imanolortiz.ride.rides.infrastructure.db.mapper;

import com.imanolortiz.ride.rides.domain.model.Location;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class LocationEntityMapper {

    public static Location toDomain(Point point) {
        return Location.builder()
                .latitude(point.getX())
                .longitude(point.getY())
                .build();
    }

    public static Point toEntity(Location model) {
        Coordinate coordinate = new Coordinate(model.getLatitude(), model.getLongitude());
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(coordinate);
        point.setSRID(4326);
        return point;
    }

}
