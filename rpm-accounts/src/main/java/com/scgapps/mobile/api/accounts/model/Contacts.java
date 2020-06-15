package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

/**
 * Contacts
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@SuppressWarnings("unused")
public class Contacts {
    @Valid
    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("faxNumber")
    private String fax = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("isFavoriteContact")
    private int isFavorite;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("cellPhone")
    private String cellPhone = null;

    @JsonProperty("workPhone")
    private String workPhone = null;

    @JsonProperty("phoneOther")
    private String phoneOther = null;

    @JsonProperty("deleted")
    private Integer deleted;

    @JsonProperty("deletedBy")
    private Integer deletedBy;

    @JsonProperty("deletedTime")
    private Instant deletedTime;

    @JsonProperty("socialMediaLink")
    private List<SocialMediaLink> socialMediaLinks;
}