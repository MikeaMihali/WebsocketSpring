package com.kafkawebsocket.rayonit.kafkawebsocket.Models;

public class Properties {

     private String markerColor;

     private String markerSymbol;

    public Properties(String markerColor, String markerSymbol) {
        this.markerColor = markerColor;
        this.markerSymbol = markerSymbol;
    }

    public String getMarkerColor() {
        return markerColor;
    }

    public void setMarkerColor(String markerColor) {
        this.markerColor = markerColor;
    }

    public String getMarkerSymbol() {
        return markerSymbol;
    }

    public void setMarkerSymbol(String markerSymbol) {
        this.markerSymbol = markerSymbol;
    }
}
