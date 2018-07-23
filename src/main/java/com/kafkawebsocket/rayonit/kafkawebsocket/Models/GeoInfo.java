package com.kafkawebsocket.rayonit.kafkawebsocket.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kafkawebsocket.rayonit.kafkawebsocket.JacksonSerializer.GeoJsonDeserializer;
import com.kafkawebsocket.rayonit.kafkawebsocket.JacksonSerializer.GeoJsonSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;
@Document(collection = "geoInfo")
public class GeoInfo {
    @Id
    private String id;
    @JsonSerialize(using = GeoJsonSerializer.class)
    @JsonDeserialize(using=GeoJsonDeserializer.class)
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @Field
    private GeoJson geometry;

    private Map<String, String> properties;

    public GeoInfo(String id, GeoJson geometry, Map<String, String> properties) {
        this.id = id;
        this.geometry = geometry;
        this.properties = properties;
    }

    public GeoInfo() {
    }

    public GeoInfo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoJson getGeometry() {
        return geometry;
    }

    public void setGeometry(GeoJson geometry) {
        this.geometry = geometry;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
