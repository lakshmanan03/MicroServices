package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ContactSummary {

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("middlename")
    private String middleName = null;

    @JsonProperty("isFavoriteContact")
    private int isFavorite;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("accountId")
    private long accountId;

    @JsonProperty("accountName")
    private String accountName = null;

    @JsonProperty("cellPhone")
    private String cellPhone = null;

    @JsonProperty("erpContactId")
    private String erpContactId;

    @JsonProperty("workPhone")
    private String workPhone = null;

    @JsonProperty("workPhoneExt")
    private String workPhoneExt = null;

    @JsonProperty("faxNumber")
    private String fax = null;

    @JsonProperty("faxExt")
    private String faxExt = null;

    @JsonProperty("phoneOther")
    private String phoneOther = null;

    @JsonProperty("phoneOtherExt")
    private String phoneOtherExt = null;

    @JsonProperty("socialMediaLink")
    private List<SocialMediaLink> socialMediaLinks;

    @JsonProperty("address")
    private Address contactAddress = null;

    @JsonProperty("notes")
    private List<Note> notes = null;

    @JsonProperty("tasks")
    private List<TaskSummary> tasks = null;


    @JsonProperty("location")
    private Location location = null;

    public ContactSummary id(Long id) {
        this.id = id;
        return this;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return formattedString(accountName);

    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get id
     *
     * @return id
     **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactSummary firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<TaskSummary> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskSummary> tasks) {
        this.tasks = tasks;
    }

    public String getTitle() {
        return formattedString(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFax() {
        return formattedString(fax);
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhoneOther() {
        return formattedString(phoneOther);
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/

    public String getFirstName() {
        return formattedString(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ContactSummary lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/

    public String getLastName() {
        return formattedString(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactSummary email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/

    public String getEmail() {
        return formattedString(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactSummary middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getMiddleName() {
        return formattedString(middleName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public ContactSummary erpContactId(String erpContactId) {
        this.erpContactId = erpContactId;
        return this;
    }

    public String getErpContactId() {
        return formattedString(erpContactId);
    }

    public void setErpContactId(String erpContactId) {
        this.erpContactId = erpContactId;
    }

    public ContactSummary workPhoneExt(String workPhoneExt) {
        this.workPhoneExt = workPhoneExt;
        return this;
    }

    public String getWorkPhoneExt() {
        return formattedString(workPhoneExt);
    }

    public void setWorkPhoneExt(String workPhoneExt) {
        this.workPhoneExt = workPhoneExt;
    }

    public ContactSummary faxExt(String faxExt) {
        this.faxExt = faxExt;
        return this;
    }

    public String getFaxExt() {
        return formattedString(faxExt);
    }

    public void setFaxExt(String faxExt) {
        this.faxExt = faxExt;
    }

    public ContactSummary phoneOtherExt(String phoneOtherExt) {
        this.phoneOtherExt = phoneOtherExt;
        return this;
    }

    public String getPhoneOtherExt() {
        return formattedString(phoneOtherExt);
    }

    public void setPhoneOtherExt(String phoneOtherExt) {
        this.phoneOtherExt = phoneOtherExt;
    }

    public ContactSummary cellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    /**
     * Get cellPhone
     *
     * @return cellPhone
     **/

    public String getCellPhone() {
        return formattedString(cellPhone);
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public ContactSummary workPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    /**
     * Get workPhone
     *
     * @return workPhone
     **/

    public String getWorkPhone() {
        return formattedString(workPhone);
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public ContactSummary contactAddress(Address contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public List<SocialMediaLink> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    /**
     * Get contactAddress
     *
     * @return contactAddress
     **/

    public Address getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(Address contactAddress) {
        this.contactAddress = contactAddress;
    }

    public ContactSummary contactNotes(List<Note> contactNotes) {
        this.notes = contactNotes;
        return this;
    }

    public ContactSummary addContactNotesItem(Note contactNotesItem) {
        if (this.notes == null) {
            this.notes = new ArrayList<>();
        }
        this.notes.add(contactNotesItem);
        return this;
    }

    public void setContactNotes(List<Note> contactNotes) {
        this.notes = contactNotes;
    }

    public ContactSummary contactTasks(List<TaskSummary> contactTasks) {
        this.tasks = contactTasks;
        return this;
    }

    public ContactSummary addContactTasksItem(TaskSummary contactTasksItem) {
        if (this.tasks == null) {
            this.tasks = new ArrayList<>();
        }
        this.tasks.add(contactTasksItem);
        return this;
    }


    public void setContactTasks(List<TaskSummary> contactTasks) {
        this.tasks = contactTasks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactSummary contacts = (ContactSummary) o;
        return this.isFavorite == contacts.isFavorite &&
                this.accountId == contacts.accountId &&
                Objects.equals(this.id, contacts.id) &&
                Objects.equals(this.title, contacts.title) &&
                Objects.equals(this.firstName, contacts.firstName) &&
                Objects.equals(this.lastName, contacts.lastName) &&
                Objects.equals(this.middleName, contacts.middleName) &&
                Objects.equals(this.email, contacts.email) &&
                Objects.equals(this.accountName, contacts.accountName) &&
                Objects.equals(this.cellPhone, contacts.cellPhone) &&
                Objects.equals(this.erpContactId, contacts.erpContactId) &&
                Objects.equals(this.workPhone, contacts.workPhone) &&
                Objects.equals(this.workPhoneExt, contacts.workPhoneExt) &&
                Objects.equals(this.fax, contacts.fax) &&
                Objects.equals(this.faxExt, contacts.faxExt) &&
                Objects.equals(this.phoneOther, contacts.phoneOther) &&
                Objects.equals(this.phoneOtherExt, contacts.phoneOtherExt) &&
                Objects.equals(this.contactAddress, contacts.contactAddress) &&
                Objects.equals(this.notes, contacts.notes) &&
                Objects.equals(this.tasks, contacts.tasks) &&
                Objects.equals(this.location, contacts.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, firstName, lastName, middleName, isFavorite, email, accountId, accountName, cellPhone, erpContactId, workPhone, workPhoneExt, fax, faxExt, phoneOther, phoneOtherExt, contactAddress, notes, tasks, location);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Contacts {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    cellPhone: ").append(toIndentedString(cellPhone)).append("\n");
        sb.append("    workPhone: ").append(toIndentedString(workPhone)).append("\n");
        sb.append("    contactAddress: ").append(toIndentedString(contactAddress)).append("\n");
        sb.append("    contactNotes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    contactTasks: ").append(toIndentedString(tasks)).append("\n");
        sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
        sb.append("    erpContactId: ").append(toIndentedString(erpContactId)).append("\n");
        sb.append("    workPhoneExt: ").append(toIndentedString(workPhoneExt)).append("\n");
        sb.append("    faxExt: ").append(toIndentedString(faxExt)).append("\n");
        sb.append("    phoneOtherExt: ").append(toIndentedString(phoneOtherExt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String formattedString(String value) {
        if (value != null) {
            return value.trim();
        }
        return value;
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
