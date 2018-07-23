package com.kafkawebsocket.rayonit.kafkawebsocket.JacksonSerializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeoJsonDeserializer extends JsonDeserializer<GeoJson> {
    @Override
    public GeoJson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String type = node.get("type").textValue();
        switch (type) {
            case "Point":
                return new GeoJsonPoint(getPoint(node.get("coordinates")));
            case "LineString":
                return new GeoJsonLineString(getPoints(node.get("coordinates")));
            case "MultiPoint":
                return new GeoJsonMultiPoint(getPoints(node.get("coordinates")));
            case "Polygon":
                GeoJsonPolygon polygon = null;
                for (int i = 0; i < node.get("coordinates").size(); i++) {
                    if (i == 0) {
                        polygon = new GeoJsonPolygon(getPoints(node.get("coordinates").get(i)));
                    } else {
                        polygon.withInnerRing(getPoints(node.get("coordinates").get(i)));
                    }
                }
                return polygon;
        }
        return null;
    }

    private Point getPoint(JsonNode jsonNode) {
        double latitude = jsonNode.get(0).asDouble();
        double longitude = jsonNode.get(1).asDouble();
        return new Point(latitude, longitude);
    }

    private List<Point> getPoints(JsonNode jsonNode) {
        List<Point> result = new ArrayList<>();
        jsonNode.forEach((elem) -> result.add(getPoint(elem)));
        return result;
    }

}