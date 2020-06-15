package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Addresses
 */
@Validated
@SuppressWarnings("unused")
public class Address   {
    @JsonProperty("id")
    private long id;

    @JsonProperty("formattedAddress")
    private String formattedAddress = null;

    /**
     * Get addressId
     * @return addressId
     **/

    @Valid

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get formattedAddress
     * @return formattedAddress
     **/

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address addresses = (Address) o;
        return Objects.equals(this.id, addresses.id) &&
                Objects.equals(this.formattedAddress, addresses.formattedAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formattedAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Addresses {\n");

        sb.append("    addressId: ").append(toIndentedString(id)).append("\n");
        sb.append("    formattedAddress: ").append(toIndentedString(formattedAddress)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

