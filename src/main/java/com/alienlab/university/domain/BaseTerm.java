package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A BaseTerm.
 */
@Entity
@Table(name = "base_term")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseTerm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_code")
    private String termCode;

    @Column(name = "term_name")
    private String termName;

    @Column(name = "term_status")
    private String termStatus;

    @Column(name = "term_startdate")
    private ZonedDateTime termStartdate;

    @Column(name = "term_enddate")
    private ZonedDateTime termEnddate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermCode() {
        return termCode;
    }

    public BaseTerm termCode(String termCode) {
        this.termCode = termCode;
        return this;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermName() {
        return termName;
    }

    public BaseTerm termName(String termName) {
        this.termName = termName;
        return this;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTermStatus() {
        return termStatus;
    }

    public BaseTerm termStatus(String termStatus) {
        this.termStatus = termStatus;
        return this;
    }

    public void setTermStatus(String termStatus) {
        this.termStatus = termStatus;
    }

    public ZonedDateTime getTermStartdate() {
        return termStartdate;
    }

    public BaseTerm termStartdate(ZonedDateTime termStartdate) {
        this.termStartdate = termStartdate;
        return this;
    }

    public void setTermStartdate(ZonedDateTime termStartdate) {
        this.termStartdate = termStartdate;
    }

    public ZonedDateTime getTermEnddate() {
        return termEnddate;
    }

    public BaseTerm termEnddate(ZonedDateTime termEnddate) {
        this.termEnddate = termEnddate;
        return this;
    }

    public void setTermEnddate(ZonedDateTime termEnddate) {
        this.termEnddate = termEnddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseTerm baseTerm = (BaseTerm) o;
        if (baseTerm.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseTerm.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseTerm{" +
            "id=" + getId() +
            ", termCode='" + getTermCode() + "'" +
            ", termName='" + getTermName() + "'" +
            ", termStatus='" + getTermStatus() + "'" +
            ", termStartdate='" + getTermStartdate() + "'" +
            ", termEnddate='" + getTermEnddate() + "'" +
            "}";
    }
}
