package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Address.
 */
@Entity
@Table(name = "addresses")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_line_3")
    private String addressLine3;

    @Column(name = "address_line_4")
    private String addressLine4;

    @Column(name = "address_line_5")
    private String addressLine5;

    @Column(name = "address_line_6")
    private String addressLine6;

    @Column(name = "building")
    private String building;

    @Column(name = "city1")
    private String city1;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "county")
    private String county;

    @Column(name = "created")
    private Instant created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "creator_product_line_id")
    private Integer creatorProductLineId;

    @Column(name = "display_postal_code")
    private String displayPostalCode;

    @Column(name = "erp_address_format_id")
    private String erpAddressFormatId;

    @Column(name = "erp_address_id")
    private String erpAddressId;

    @Column(name = "erp_city1_id")
    private String erpCity1Id;

    @Column(name = "erp_geo_code")
    private String erpGeoCode;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "floor")
    private String floor;

    @Column(name = "formatted_address")
    private String formattedAddress;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

    @Column(name = "modifiable")
    private Integer modifiable;

    @Column(name = "name1")
    private String name1;

    @Column(name = "name2")
    private String name2;

    @Column(name = "other_number")
    private String otherNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "post_office_box_number")
    private String postOfficeBoxNumber;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "street1")
    private String street1;

    @Column(name = "street2")
    private String street2;

    @Column(name = "unit")
    private String unit;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "account_addresses",
        joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account"))
    private Set<Account> accounts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public Address addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public Address addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String  getAddressLine3() {
        return addressLine3;
    }

    public Address addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public Address addressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
        return this;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getAddressLine5() {
        return addressLine5;
    }

    public Address addressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
        return this;
    }

    public void setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }

    public String getAddressLine6() {
        return addressLine6;
    }

    public Address addressLine6(String addressLine6) {
        this.addressLine6 = addressLine6;
        return this;
    }

    public void setAddressLine6(String addressLine6) {
        this.addressLine6 = addressLine6;
    }

    public String getBuilding() {
        return building;
    }

    public Address building(String building) {
        this.building = building;
        return this;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity1() {
        return city1;
    }

    public Address city1(String city1) {
        this.city1 = city1;
        return this;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Address countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCounty() {
        return county;
    }

    public Address county(String county) {
        this.county = county;
        return this;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Instant getCreated() {
        return created;
    }

    public Address created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Address createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatorProductLineId() {
        return creatorProductLineId;
    }

    public Address creatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
        return this;
    }

    public void setCreatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
    }

    public String getDisplayPostalCode() {
        return displayPostalCode;
    }

    public Address displayPostalCode(String displayPostalCode) {
        this.displayPostalCode = displayPostalCode;
        return this;
    }

    public void setDisplayPostalCode(String displayPostalCode) {
        this.displayPostalCode = displayPostalCode;
    }

    public String getErpAddressFormatId() {
        return erpAddressFormatId;
    }

    public Address erpAddressFormatId(String erpAddressFormatId) {
        this.erpAddressFormatId = erpAddressFormatId;
        return this;
    }

    public void setErpAddressFormatId(String erpAddressFormatId) {
        this.erpAddressFormatId = erpAddressFormatId;
    }

    public String getErpAddressId() {
        return erpAddressId;
    }

    public Address erpAddressId(String erpAddressId) {
        this.erpAddressId = erpAddressId;
        return this;
    }

    public void setErpAddressId(String erpAddressId) {
        this.erpAddressId = erpAddressId;
    }

    public String getErpCity1Id() {
        return erpCity1Id;
    }

    public Address erpCity1Id(String erpCity1Id) {
        this.erpCity1Id = erpCity1Id;
        return this;
    }

    public void setErpCity1Id(String erpCity1Id) {
        this.erpCity1Id = erpCity1Id;
    }

    public String getErpGeoCode() {
        return erpGeoCode;
    }

    public Address erpGeoCode(String erpGeoCode) {
        this.erpGeoCode = erpGeoCode;
        return this;
    }

    public void setErpGeoCode(String erpGeoCode) {
        this.erpGeoCode = erpGeoCode;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public Address faxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    public void setFaxNumber(String  faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFloor() {
        return floor;
    }

    public Address floor(String floor) {
        this.floor = floor;
        return this;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public Address formattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
        return this;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Address houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public Address lastModified(Instant lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Address lastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getModifiable() {
        return modifiable;
    }

    public Address modifiable(Integer modifiable) {
        this.modifiable = modifiable;
        return this;
    }

    public void setModifiable(Integer modifiable) {
        this.modifiable = modifiable;
    }

    public String getName1() {
        return name1;
    }

    public Address name1(String name1) {
        this.name1 = name1;
        return this;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public Address name2(String name2) {
        this.name2 = name2;
        return this;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public Address otherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
        return this;
    }

    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostOfficeBoxNumber() {
        return postOfficeBoxNumber;
    }

    public Address postOfficeBoxNumber(String postOfficeBoxNumber) {
        this.postOfficeBoxNumber = postOfficeBoxNumber;
        return this;
    }

    public void setPostOfficeBoxNumber(String postOfficeBoxNumber) {
        this.postOfficeBoxNumber = postOfficeBoxNumber;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public Address routeCode(String routeCode) {
        this.routeCode = routeCode;
        return this;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public Address stateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStreet1() {
        return street1;
    }

    public Address street1(String street1) {
        this.street1 = street1;
        return this;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public Address street2(String street2) {
        this.street2 = street2;
        return this;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getUnit() {
        return unit;
    }

    public Address unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        return id != null && id.equals(((Address) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + getId() +
            ", addressLine1='" + getAddressLine1() + "'" +
            ", addressLine2='" + getAddressLine2() + "'" +
//            ", addressLine3=" + getAddressLine3() + "'" +
            ", addressLine4='" + getAddressLine4() + "'" +
            ", addressLine5='" + getAddressLine5() + "'" +
            ", addressLine6='" + getAddressLine6() + "'" +
            ", building='" + getBuilding() + "'" +
            ", city1='" + getCity1() + "'" +
            ", countryCode='" + getCountryCode() + "'" +
            ", county='" + getCounty() + "'" +
            ", created='" + getCreated() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", creatorProductLineId=" + getCreatorProductLineId() +
            ", displayPostalCode='" + getDisplayPostalCode() + "'" +
            ", erpAddressFormatId='" + getErpAddressFormatId() + "'" +
            ", erpAddressId='" + getErpAddressId() + "'" +
            ", erpCity1Id='" + getErpCity1Id() + "'" +
            ", erpGeoCode='" + getErpGeoCode() + "'" +
            ", faxNumber=" + getFaxNumber() +
            ", floor='" + getFloor() + "'" +
            ", formattedAddress='" + getFormattedAddress() + "'" +
            ", houseNumber='" + getHouseNumber() + "'" +
            ", lastModified='" + getLastModified() + "'" +
            ", lastModifiedBy=" + getLastModifiedBy() +
            ", modifiable=" + getModifiable() +
            ", name1='" + getName1() + "'" +
            ", name2='" + getName2() + "'" +
            ", otherNumber='" + getOtherNumber() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", postOfficeBoxNumber='" + getPostOfficeBoxNumber() + "'" +
            ", routeCode='" + getRouteCode() + "'" +
            ", stateCode='" + getStateCode() + "'" +
            ", street1='" + getStreet1() + "'" +
            ", street2='" + getStreet2() + "'" +
            ", unit='" + getUnit() + "'" +
            "}";
    }
}
