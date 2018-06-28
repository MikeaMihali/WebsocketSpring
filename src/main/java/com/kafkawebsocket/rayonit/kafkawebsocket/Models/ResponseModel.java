package com.kafkawebsocket.rayonit.kafkawebsocket.Models;

public class ResponseModel {
    String content;

    public ResponseModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
