package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseCourse.
 */
@Entity
@Table(name = "base_course")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "course_desc")
    private String courseDesc;

    @Column(name = "course_status")
    private String courseStatus;

    @ManyToOne
    private BaseTeacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public BaseCourse courseCode(String courseCode) {
        this.courseCode = courseCode;
        return this;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public BaseCourse courseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public BaseCourse courseType(String courseType) {
        this.courseType = courseType;
        return this;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public BaseCourse courseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
        return this;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public BaseCourse courseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
        return this;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public BaseCourse teacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
        return this;
    }

    public void setTeacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseCourse baseCourse = (BaseCourse) o;
        if (baseCourse.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseCourse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseCourse{" +
            "id=" + getId() +
            ", courseCode='" + getCourseCode() + "'" +
            ", courseName='" + getCourseName() + "'" +
            ", courseType='" + getCourseType() + "'" +
            ", courseDesc='" + getCourseDesc() + "'" +
            ", courseStatus='" + getCourseStatus() + "'" +
            "}";
    }
}
