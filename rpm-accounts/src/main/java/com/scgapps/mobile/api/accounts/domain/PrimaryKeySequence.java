package com.scgapps.mobile.api.accounts.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ADMIN_PK_IDS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PrimaryKeySequence implements Serializable {

    @Id
    @Column(name="SFA_TABLE_NAME")
    private String tableName;


    @Column(name="NEXT_VALUE")
    private long nextValue;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public long getNextValue() {
        return nextValue;
    }

    public void setNextValue(long nextValue) {
        this.nextValue = nextValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimaryKeySequence)) return false;
        PrimaryKeySequence that = (PrimaryKeySequence) o;
        return Objects.equals(getTableName(), that.getTableName()) &&
                Objects.equals(getNextValue(), that.getNextValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTableName(), getNextValue());
    }

    @Override
    public String toString() {
        return "PrimaryKeySequence{" +
                "tableName='" + tableName + '\'' +
                ", nextValue='" + nextValue + '\'' +
                '}';
    }
}
