package com.scgapps.mobile.api.accounts.domain;

import com.scgapps.mobile.api.accounts.config.Constant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Accounts.
 */
@Entity
@Table(name = "accounts")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_ranking")
    private Integer accountRanking;

    @Column(name = "created")
    private Instant created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "creator_product_line_id")
    private Integer creatorProductLineId;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "deleted_time")
    private Instant deletedTime;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "gc")
    private String gc;

    @Column(name = "home_page")
    private String homePage;

    @Column(name = "is_protected")
    private Integer isProtected;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "lastmodifiedby")
    private Integer lastModifiedBy;

    @Column(name = "main_phone")
    private String mainPhone;

    @Column(name = "name")
    private String name;

    @Column(name = "parent")
    private Integer parent;

    @OneToOne
    @JoinColumn(name="primary_contact_id")
    private Contact primaryContact;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="primary_address_id")
     private Address primaryAddress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName="address",name = "primary_address_id",insertable=false,updatable=false)
    private Location location;

    @OneToMany(targetEntity = Notes.class, mappedBy = "account", fetch = FetchType.LAZY)
      private List<Notes> notes = new ArrayList<>();

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
       @JoinTable(name = "account_contacts",
        joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account"),
        inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact"))
    private Set<Contact> contacts = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "account_addresses",
        joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account"),
        inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private Set<Address> addresses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountRanking() {
        return accountRanking;
    }

    public Account accountRanking(Integer accountRanking) {
        this.accountRanking = accountRanking;
        return this;
    }

    public void setAccountRanking(Integer accountRanking) {
        this.accountRanking = accountRanking;
    }

    public Instant getCreated() {
        return created;
    }

    public Account created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Account createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatorProductLineId() {
        return creatorProductLineId;
    }

    public Account creatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
        return this;
    }

    public void setCreatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public Account currencyId(Integer currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Account deleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public Account deletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Instant getDeletedTime() {
        return deletedTime;
    }

    public Account deletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
        return this;
    }

    public void setDeletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getEmail() {
        return email;
    }

    public Account email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public Account fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGc() {
        return gc;
    }

    public Account gc(String gc) {
        this.gc = gc;
        return this;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getHomePage() {
        return homePage;
    }

    public Account homePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Integer getIsProtected() {
        return isProtected;
    }

    public Account isProtected(Integer isProtected) {
        this.isProtected = isProtected;
        return this;
    }

    public void setIsProtected(Integer isProtected) {
        this.isProtected = isProtected;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public Account lastModified(Instant lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Account lastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public Account mainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
        return this;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getName() {
        return name;
    }

    public Account name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public Account parent(Integer parent) {
        this.parent = parent;
        return this;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Contact getPrimaryContact() {
        return primaryContact;
    }

    public Account primaryContact(Contact contact) {
        this.primaryContact = contact;
        return this;
    }

    public void setPrimaryContact(Contact contact) {
        this.primaryContact = contact;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Account primaryAddress(Address address) {
        this.primaryAddress = address;
        return this;
    }

    public void setPrimaryAddress(Address address) {
        this.primaryAddress = address;
    }

    public Location getLocation() {
        return location;
    }

    public Account location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public Account notes(List<Notes> notes) {
        this.notes = notes;
        return this;
    }

    public Account addNote(Notes notes) {
        this.notes.add(notes);
        notes.setAccount(this);
        return this;
    }

    public Account removeNote(Notes notes) {
        this.notes.remove(notes);
        notes.setAccount(null);
        return this;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public Account contacts(Set<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Account addContact(Contact contact) {
        this.contacts.add(contact);
              return this;
    }

    public Account removeContact(Contact contact) {
        this.contacts.remove(contact);

        return this;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Account addresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        return id != null && id.equals(((Account) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountRanking=" + accountRanking +
                ", created=" + created +
                ", createdBy=" + createdBy +
                ", creatorProductLineId=" + creatorProductLineId +
                ", currencyId=" + currencyId +
                ", deleted=" + deleted +
                ", deletedBy=" + deletedBy +
                ", deletedTime=" + deletedTime +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", gc='" + gc + '\'' +
                ", homePage='" + homePage + '\'' +
                ", isProtected=" + isProtected +
                ", lastModified=" + lastModified +
                ", lastModifiedBy=" + lastModifiedBy +
                ", mainPhone='" + mainPhone + '\'' +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", primaryContact=" + primaryContact +
                ", primaryAddress=" + primaryAddress +
                ", location=" + location +
                ", notes=" + notes +
                ", contacts=" + contacts +
                ", addresses=" + addresses +
                '}';
    }
}
