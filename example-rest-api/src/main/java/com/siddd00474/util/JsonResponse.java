package com.siddd00474.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

public class JsonResponse {
    private int status;
    private String message;
    private Object data;
    @JsonIgnore

    private static Gson gson = new Gson();
    public int getStatus() {
        return status;
    }

    public JsonResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResponse setData(Object data) {
        this.data = data;
        return this;
    }
    public String toJsonString(){
        return gson.toJson(this);
    }
}
