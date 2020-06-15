package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("message")
    private String message = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
