package com.simplet.biodata.model;

import lombok.Data;

@Data
public class ResponseModel<Entity> {
    private String message;
    private Entity data;

    public ResponseModel(String message, Entity data) {
        this.message = message;
        this.data = data;
    }

    public ResponseModel() {

    }
}
