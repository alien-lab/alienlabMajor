package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseClasses.
 */
@Entity
@Table(name = "base_classes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseClasses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_year")
    private String termYear;

    @Column(name = "class_no")
    private String classNo;

    @Column(name = "class_name")
    private String className;

    @Column(name = "is_over")
    private String isOver;

    @ManyToOne
    private BaseMajor major;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermYear() {
        return termYear;
    }

    public BaseClasses termYear(String termYear) {
        this.termYear = termYear;
        return this;
    }

    public void setTermYear(String termYear) {
        this.termYear = termYear;
    }

    public String getClassNo() {
        return classNo;
    }

    public BaseClasses classNo(String classNo) {
        this.classNo = classNo;
        return this;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public BaseClasses className(String className) {
        this.className = className;
        return this;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIsOver() {
        return isOver;
    }

    public BaseClasses isOver(String isOver) {
        this.isOver = isOver;
        return this;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public BaseMajor getMajor() {
        return major;
    }

    public BaseClasses major(BaseMajor baseMajor) {
        this.major = baseMajor;
        return this;
    }

    public void setMajor(BaseMajor baseMajor) {
        this.major = baseMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseClasses baseClasses = (BaseClasses) o;
        if (baseClasses.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseClasses.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseClasses{" +
            "id=" + getId() +
            ", termYear='" + getTermYear() + "'" +
            ", classNo='" + getClassNo() + "'" +
            ", className='" + getClassName() + "'" +
            ", isOver='" + getIsOver() + "'" +
            "}";
    }
}
