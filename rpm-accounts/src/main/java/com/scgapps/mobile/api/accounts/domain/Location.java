package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address_geocode")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Location implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private Long addres;

    @Column(name = "lat")
    private String latitude;

    @Column(name = "lng")
    private String longitude;



    public Long getAddres() {
        return addres;
    }

    public void setAddres(Long addres) {
        this.addres = addres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Location latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Location longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }
}
