package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "account_contacts")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@SuppressWarnings("unused")
public class AccountContact implements Serializable {
    @Id
    @Column(name = "id")
    private long id;


    @Column(name = "account_id")
    private long accountId;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "contact")
    private Contact accountContact;

    @Column(name = "invoice_to")
    private Integer invoiceTo = 1;

    @Column(name = "ship_to")
    private Integer shipTo = 1;

    @Column(name = "sold_to")
    private Integer soldTo = 1;

    @Column(name = "pay_by")
    private Integer payBy = 1;

    @Column(name = "obsolete")
    private Integer obsolete = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Contact getAccountContact() {
        return  this.accountContact;
    }

    public void setAccountContact(Contact accountContact) {
        this.accountContact = accountContact;
    }

    public Integer getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(Integer invoiceTo) {
        this.invoiceTo = invoiceTo;
    }

    public Integer getShipTo() {
        return shipTo;
    }

    public void setShipTo(Integer shipTo) {
        this.shipTo = shipTo;
    }

    public Integer getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(Integer soldTo) {
        this.soldTo = soldTo;
    }

    public Integer getPayBy() {
        return payBy;
    }

    public void setPayBy(Integer payBy) {
        this.payBy = payBy;
    }

    public Integer getObsolete() {
        return obsolete;
    }

    public void setObsolete(Integer obsolete) {
        this.obsolete = obsolete;
    }
}
