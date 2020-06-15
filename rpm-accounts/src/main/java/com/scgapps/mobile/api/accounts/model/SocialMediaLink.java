package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialMediaLink {
    @JsonProperty("id")
    private long id;

    @JsonProperty("typeId")
    private long typeId;

    @JsonProperty("url")
    private String url;

}
