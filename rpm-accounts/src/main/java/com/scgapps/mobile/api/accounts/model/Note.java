package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Objects;

/**
 * Notes
 */
@Validated
@SuppressWarnings("unused")
public class Note  {
    @JsonProperty("id")
    private long id;

    @JsonProperty("subject")
    private String subject = null;

    @JsonProperty("comments")
    private String comments = null;

    @JsonProperty("type")
    private int type;

    @JsonProperty("lastModified")
    private Instant lastModified = null;


    /**
     * Get id
     * @return id
     **/

    @Valid

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get subject
     * @return subject
     **/

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Get comments
     * @return comments
     **/

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Get type
     * @return type
     **/

    @Valid

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * Get lastModified
     * @return lastModified
     **/

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Note notes = (Note) o;
        return Objects.equals(this.id, notes.id) &&
                Objects.equals(this.subject, notes.subject) &&
                Objects.equals(this.comments, notes.comments) &&
                Objects.equals(this.type, notes.type) &&
                Objects.equals(this.lastModified, notes.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, comments, type, lastModified);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Notes {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
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

