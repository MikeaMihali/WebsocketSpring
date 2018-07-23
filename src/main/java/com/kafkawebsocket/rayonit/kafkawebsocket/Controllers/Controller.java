package com.kafkawebsocket.rayonit.kafkawebsocket.Controllers;

import com.kafkawebsocket.rayonit.kafkawebsocket.Models.EventResponseMainModel;
import com.kafkawebsocket.rayonit.kafkawebsocket.Models.GeoInfo;
import com.kafkawebsocket.rayonit.kafkawebsocket.Repository.EventsRepository;
import com.kafkawebsocket.rayonit.kafkawebsocket.Repository.GeoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    GeoInfoRepository geoInfoRepository;
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    SimpMessagingTemplate template;
    @Autowired
    MongoTemplate mongoTemplate;
    public static final Polygon USER_ZONE =new GeoJsonPolygon(
            new Point( 12.309494018554688,
                    41.918628865183045),
            new Point(12.411117553710938,
                    41.7508241355329),
            new Point(12.677536010742188,
                    41.789232915019845),
            new Point(  12.678909301757812,
                    41.99726342796974),
            new Point( 12.455062866210936,
                    42.02991418347818),
            new Point(  12.309494018554688,
                    41.918628865183045)
    );
    @PostMapping("/update")
    public ResponseEntity getUpdates(@RequestBody EventResponseMainModel data){
        eventsRepository.save(data);
        GeoInfo req = geoInfoRepository.save(data.getData().get(0).getGeoData().get(0));

        GeoInfo res= geoInfoRepository.findTopByGeometryWithinOrderByIdDesc(
                USER_ZONE
                );
        if(res.getId().equals(req.getId())){
         template.convertAndSend("/events",data);
         return new ResponseEntity(res, HttpStatus.OK);
        }
         return new ResponseEntity(HttpStatus.FORBIDDEN);
   }
   @GetMapping("/events")
   public List<?> getEvents(@RequestParam(name = "minLat") Double minLat ,
                            @RequestParam(name = "maxLat") Double maxLat ,
                            @RequestParam(name = "minLng") Double minLng ,
                            @RequestParam(name = "maxLng") Double maxLng ){
//        eventsRepository.deleteAll();
//        geoInfoRepository.deleteAll();
      double[] southWest={minLat,minLng};
      double[] northEast={maxLat,maxLng};
      Box bounds=new Box(northEast,southWest);
      return mongoTemplate.find(new Query(Criteria.where("data.0.geoData.0.geometry").within(bounds).within(USER_ZONE)),EventResponseMainModel.class);
//       return eventsRepository.findByGeometryWithin(b);
//       return eventsRepository.findAll();
    }
}

