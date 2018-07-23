package com.kafkawebsocket.rayonit.kafkawebsocket.Repository;

import com.kafkawebsocket.rayonit.kafkawebsocket.Models.EventResponseMainModel;
import com.kafkawebsocket.rayonit.kafkawebsocket.Models.GeoInfo;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GeoInfoRepository extends MongoRepository<GeoInfo,String> {
    GeoInfo findTopByGeometryWithinOrderByIdDesc(Polygon polygon);
    void deleteAll();
}
