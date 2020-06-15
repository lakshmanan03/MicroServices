package com.scgapps.mobile.api.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccountSummary
 */
@Validated
@SuppressWarnings("unused")
public class AccountSummary {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("gc")
    private String gc = null;

    @JsonProperty("mainPhone")
    private String mainPhone = null;

    @JsonProperty("lastAction")
    private Instant lastAction = Instant.now();

    @JsonProperty("totalSales")
    private String totalSales = "616,20.98";

    @JsonProperty("primary")
    private String primary = "Not available";


    @JsonProperty("primaryAddress")
    private Address primaryAddress = null;

    @JsonProperty("contacts")
    private List<Contacts> contacts = new ArrayList<>();

    @JsonProperty("addresses")
    private List<Address> addresses = new ArrayList<>();

    @JsonProperty("notes")
    private List<Note> notes = new ArrayList<>();

    @JsonProperty("tasks")
    private List<TaskSummary> tasks = new ArrayList<>();

    @JsonProperty("location")
    private Location location = null;

    /**
     * Get id
     *
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
     * Get name
     *
     * @return name
     **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get accountGc
     *
     * @return accountGc
     **/

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    /**
     * Get mainPhone
     *
     * @return mainPhone
     **/

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    /**
     * Get Last Action on Account
     *
     * @return -- lastAction
     */
    public Instant getLastAction() {
        return lastAction;
    }

    public void setLastAction(Instant lastAction) {
        this.lastAction = lastAction;
    }

    /**
     * Get Account Total Sales
     *
     * @return -- account totalSales
     */
    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Get Account Primary
     *
     * @return -- account primary
     */
    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    /**
     * Get primaryAddress
     *
     * @return primaryAddress
     **/

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     * Get accountContacts
     *
     * @return accountContacts
     **/

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    /**
     * Get accountAddress
     *
     * @return accountAddress
     **/
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Get accountNotes
     *
     * @return accountNotes
     **/

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * Get account Tasks
     *
     * @return accountTasks
     **/
    public List<TaskSummary> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskSummary> tasks) {
        this.tasks = tasks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gc='" + gc + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", lastAction=" + lastAction +
                ", totalSales='" + totalSales + '\'' +
                ", primary='" + primary + '\'' +
                ", primaryAddress=" + primaryAddress +
                ", contacts=" + contacts +
                ", addresses=" + addresses +
                ", notes=" + notes +
                ", tasks=" + tasks +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountSummary that = (AccountSummary) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(gc, that.gc) &&
                Objects.equals(mainPhone, that.mainPhone) &&
                Objects.equals(lastAction, that.lastAction) &&
                Objects.equals(totalSales, that.totalSales) &&
                Objects.equals(primary, that.primary) &&
                Objects.equals(primaryAddress, that.primaryAddress) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(addresses, that.addresses) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(tasks, that.tasks) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gc, mainPhone, lastAction, totalSales, primary, primaryAddress, contacts, addresses, notes, tasks, location);
    }
}

