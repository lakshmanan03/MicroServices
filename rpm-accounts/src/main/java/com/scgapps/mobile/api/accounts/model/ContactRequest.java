package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactRequest {

    private long id;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    private Instant created;
    private Integer createdBy;
    private String title;
    private String email;
    private String cellPhone;
    private String workPhone;
    private String workPhoneExt;
    private String phoneOther;
    private String phoneOtherExt;
    private String fax;
    private String faxExt;
    private int isFavorite;
    private Instant lastModified;
    private int lastModifiedBy;
    private int deleted;
    private int modifiable;
    private long contactAddress;
    private String notes;
    private long accountId;
    private List<SocialMediaLink> socialMediaLinks;
}
