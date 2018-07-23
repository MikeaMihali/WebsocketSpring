package com.kafkawebsocket.rayonit.kafkawebsocket.Models;

import java.util.List;

public class Data {
    private String id;

    private String eventCode;

    private String eventType;

    private String soc;

    private List<GeoInfo> geoData;

    public Data() {
    }

    public Data(String id, String eventCode, String eventType, String soc, List<GeoInfo> geoData) {
        this.id = id;
        this.eventCode = eventCode;
        this.eventType = eventType;
        this.soc = soc;
        this.geoData = geoData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public List<GeoInfo> getGeoData() {
        return geoData;
    }

    public void setGeoData(List<GeoInfo> geoData) {
        this.geoData = geoData;
    }
}
