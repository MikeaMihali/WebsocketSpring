package com.kafkawebsocket.rayonit.kafkawebsocket.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "events")
public class EventResponseMainModel {

    @Id
    private String id;

    private String notificationType;

    private String source;
    @Field
    private List<Data> data;

    public EventResponseMainModel(String id,String notificationType, String source, List<Data> data) {
        this.notificationType = notificationType;
        this.source = source;
        this.data = data;
        this.id = id;
    }

    public EventResponseMainModel() {

    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
