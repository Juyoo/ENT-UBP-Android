package com.ent_ubp_android.app.model.teacher.contact.email;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

@JsonPropertyOrder({"id"})
public class Email {

    private Long id;
    private EmailDetails details;

    @JsonCreator
    public Email(@JsonProperty("details") EmailDetails details) {
        if (details == null) {
            throw new IllegalArgumentException("Cannot build a " + getClass().getName() + " without an email");
        }
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email that = (Email) o;
        return Objects.equal(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(details);
    }

}
