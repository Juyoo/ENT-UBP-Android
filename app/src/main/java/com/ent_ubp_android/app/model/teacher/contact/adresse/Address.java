package com.ent_ubp_android.app.model.teacher.contact.adresse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

@JsonPropertyOrder({"id"})
public class Address {

    private Long id;
    private AddressDetails details;

    @JsonCreator
    public Address(@JsonProperty("details") AddressDetails details) {
        if (details == null) {
            throw new IllegalArgumentException("Cannot build a " + getClass().getName() + " without an address");
        }
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return Objects.equal(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(details);
    }

}
