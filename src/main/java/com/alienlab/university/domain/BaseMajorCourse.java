package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseMajorCourse.
 */
@Entity
@Table(name = "base_major_course")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseMajorCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "term_no")
    @ApiModelProperty(value="学期号")
    private Integer termNo;

    @Column(name = "course_memo")
    @ApiModelProperty(value="课程说明")
    private String courseMemo;

    @ManyToOne
    @ApiModelProperty(value="课程对象")
    private CourseVersion course;

    @ManyToOne
    @ApiModelProperty(value="所属人才培养方案")
    private MajorTraning traning;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTermNo() {
        return termNo;
    }

    public BaseMajorCourse termNo(Integer termNo) {
        this.termNo = termNo;
        return this;
    }

    public void setTermNo(Integer termNo) {
        this.termNo = termNo;
    }

    public String getCourseMemo() {
        return courseMemo;
    }

    public BaseMajorCourse courseMemo(String courseMemo) {
        this.courseMemo = courseMemo;
        return this;
    }

    public void setCourseMemo(String courseMemo) {
        this.courseMemo = courseMemo;
    }

    public CourseVersion getCourse() {
        return course;
    }

    public BaseMajorCourse course(CourseVersion courseVersion) {
        this.course = courseVersion;
        return this;
    }

    public void setCourse(CourseVersion courseVersion) {
        this.course = courseVersion;
    }

    public MajorTraning getTraning() {
        return traning;
    }

    public BaseMajorCourse traning(MajorTraning majorTraning) {
        this.traning = majorTraning;
        return this;
    }

    public void setTraning(MajorTraning majorTraning) {
        this.traning = majorTraning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseMajorCourse baseMajorCourse = (BaseMajorCourse) o;
        if (baseMajorCourse.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseMajorCourse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseMajorCourse{" +
            "id=" + getId() +
            ", termNo='" + getTermNo() + "'" +
            ", courseMemo='" + getCourseMemo() + "'" +
            "}";
    }
}
