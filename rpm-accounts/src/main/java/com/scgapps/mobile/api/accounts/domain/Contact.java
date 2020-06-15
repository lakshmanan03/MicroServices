package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A Contact.
 */
@Entity
@Table(name = "contacts")
@Where(clause = "deleted = " + 0)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "contact")
    private long id;

    @OneToMany(mappedBy = "accountContact", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AccountContact> accountContact;


    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SocialMediaLink> socialMediaLinks;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address contactAddress;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "created")
    private Instant created;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "creator_product_line_id")
    private Integer creatorProductLineId;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "deleted_time")
    private Instant deletedTime;

    @Column(name = "email")
    private String email;

    @Column(name = "erp_contact_id")
    private String erpContactId;

    @Column(name = "fax")
    private String fax;

    @Column(name = "fax_ext")
    private String faxExt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "last_modified_by")
    private Integer lastModifiedBy;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "modifiable")
    private Integer modifiable;

    @Column(name = "phone_other")
    private String phoneOther;

    @Column(name = "phone_other_ext")
    private String phoneOtherExt;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "title")
    private String title;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "work_phone_ext")
    private String workPhoneExt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "address", name = "address_id", insertable = false, updatable = false)
    private Location location;

    @ManyToMany(cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "note_contacts",
            joinColumns = @JoinColumn(name = "contact", referencedColumnName = "contact"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Notes> notes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "account_contacts",
            joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account"))
    private Account account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AccountContact> getAccountContact() {
        return accountContact;
    }

    public void setAccountContact(List<AccountContact> accountContact) {
        this.accountContact = accountContact;
    }

    public List<SocialMediaLink> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public Contact cellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Instant getCreated() {
        return created;
    }

    public Location getLocation() {
        return location;
    }

    public Contact location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Contact createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Address getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(Address contactAddress) {
        this.contactAddress = contactAddress;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatorProductLineId() {
        return creatorProductLineId;
    }

    public Contact creatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
        return this;
    }

    public void setCreatorProductLineId(Integer creatorProductLineId) {
        this.creatorProductLineId = creatorProductLineId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public Contact deleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public Contact deletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Instant getDeletedTime() {
        return deletedTime;
    }

    public Contact deletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
        return this;
    }

    public void setDeletedTime(Instant deletedTime) {
        this.deletedTime = deletedTime;
    }

    public String getEmail() {
        return email;
    }

    public Contact email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErpContactId() {
        return erpContactId;
    }

    public Contact erpContactId(String erpContactId) {
        this.erpContactId = erpContactId;
        return this;
    }

    public void setErpContactId(String erpContactId) {
        this.erpContactId = erpContactId;
    }

    public String getFax() {
        return fax;
    }

    public Contact fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFaxExt() {
        return faxExt;
    }

    public Contact faxExt(String faxExt) {
        this.faxExt = faxExt;
        return this;
    }

    public void setFaxExt(String faxExt) {
        this.faxExt = faxExt;
    }

    public String getFirstName() {
        return firstName;
    }

    public Contact firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public Contact lastModified(Instant lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Contact lastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Contact middlename(String middlename) {
        this.middleName = middlename;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getModifiable() {
        return modifiable;
    }

    public Contact modifiable(Integer modifiable) {
        this.modifiable = modifiable;
        return this;
    }

    public void setModifiable(Integer modifiable) {
        this.modifiable = modifiable;
    }

    public String getPhoneOther() {
        return phoneOther;
    }

    public Contact phoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
        return this;
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public String getPhoneOtherExt() {
        return phoneOtherExt;
    }

    public Contact phoneOtherExt(String phoneOtherExt) {
        this.phoneOtherExt = phoneOtherExt;
        return this;
    }

    public void setPhoneOtherExt(String phoneOtherExt) {
        this.phoneOtherExt = phoneOtherExt;
    }

    public String getSalutation() {
        return salutation;
    }

    public Contact salutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getTitle() {
        return title;
    }

    public Contact title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public Contact workPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkPhoneExt() {
        return workPhoneExt;
    }

    public Contact workPhoneExt(String workPhoneExt) {
        this.workPhoneExt = workPhoneExt;
        return this;
    }

    public void setWorkPhoneExt(String workPhoneExt) {
        this.workPhoneExt = workPhoneExt;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public Contact notes(List<Notes> notes) {
        this.notes = notes;
        return this;
    }

    public Contact addNote(Notes notes) {
        this.notes.add(notes);
        notes.setContact(new ArrayList<>());
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Contact removeNote(Notes notes) {
        this.notes.remove(notes);
        notes.setContact(null);
        return this;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove
}