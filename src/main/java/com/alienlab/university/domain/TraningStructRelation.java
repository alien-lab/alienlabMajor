package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A TraningStructRelation.
 */
@Entity
@Table(name = "traning_struct_relation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TraningStructRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "relation_status")
    private String relationStatus;

    @Column(name = "relation_date")
    private ZonedDateTime relationDate;

    @Column(name = "relation_year")
    private String relationYear;

    @ManyToOne
    private MajorTraning traning;

    @ManyToOne
    private TraningStruct struct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelationStatus() {
        return relationStatus;
    }

    public TraningStructRelation relationStatus(String relationStatus) {
        this.relationStatus = relationStatus;
        return this;
    }

    public void setRelationStatus(String relationStatus) {
        this.relationStatus = relationStatus;
    }

    public ZonedDateTime getRelationDate() {
        return relationDate;
    }

    public TraningStructRelation relationDate(ZonedDateTime relationDate) {
        this.relationDate = relationDate;
        return this;
    }

    public void setRelationDate(ZonedDateTime relationDate) {
        this.relationDate = relationDate;
    }

    public String getRelationYear() {
        return relationYear;
    }

    public TraningStructRelation relationYear(String relationYear) {
        this.relationYear = relationYear;
        return this;
    }

    public void setRelationYear(String relationYear) {
        this.relationYear = relationYear;
    }

    public MajorTraning getTraning() {
        return traning;
    }

    public TraningStructRelation traning(MajorTraning majorTraning) {
        this.traning = majorTraning;
        return this;
    }

    public void setTraning(MajorTraning majorTraning) {
        this.traning = majorTraning;
    }

    public TraningStruct getStruct() {
        return struct;
    }

    public TraningStructRelation struct(TraningStruct traningStruct) {
        this.struct = traningStruct;
        return this;
    }

    public void setStruct(TraningStruct traningStruct) {
        this.struct = traningStruct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraningStructRelation traningStructRelation = (TraningStructRelation) o;
        if (traningStructRelation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), traningStructRelation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TraningStructRelation{" +
            "id=" + getId() +
            ", relationStatus='" + getRelationStatus() + "'" +
            ", relationDate='" + getRelationDate() + "'" +
            ", relationYear='" + getRelationYear() + "'" +
            "}";
    }
}
