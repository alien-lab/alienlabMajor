package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A CourseVersion.
 */
@Entity
@Table(name = "course_version")
@ApiModel(value="课程具体信息")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_count")
    @ApiModelProperty(value="总课时")
    private Integer courseCount;

    @Column(name = "course_do_count")
    @ApiModelProperty(value="实训课时")
    private Integer courseDoCount;

    @Column(name = "course_learn_count")
    @ApiModelProperty(value="理论课时")
    private Integer courseLearnCount;

    @Column(name = "course_grade")
    @ApiModelProperty(value="总学分")
    private Float courseGrade;

    @Column(name = "course_desc")
    @ApiModelProperty(value="课程描述")
    private String courseDesc;

    @Column(name = "course_book")
    @ApiModelProperty(value="教材信息")
    private String courseBook;

    @Column(name = "course_status")
    @ApiModelProperty(value="课程状态")
    private String courseStatus;

    @ManyToOne
    private BaseCourse course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public CourseVersion courseCount(Integer courseCount) {
        this.courseCount = courseCount;
        return this;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public Integer getCourseDoCount() {
        return courseDoCount;
    }

    public CourseVersion courseDoCount(Integer courseDoCount) {
        this.courseDoCount = courseDoCount;
        return this;
    }

    public void setCourseDoCount(Integer courseDoCount) {
        this.courseDoCount = courseDoCount;
    }

    public Integer getCourseLearnCount() {
        return courseLearnCount;
    }

    public CourseVersion courseLearnCount(Integer courseLearnCount) {
        this.courseLearnCount = courseLearnCount;
        return this;
    }

    public void setCourseLearnCount(Integer courseLearnCount) {
        this.courseLearnCount = courseLearnCount;
    }

    public Float getCourseGrade() {
        return courseGrade;
    }

    public CourseVersion courseGrade(Float courseGrade) {
        this.courseGrade = courseGrade;
        return this;
    }

    public void setCourseGrade(Float courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public CourseVersion courseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
        return this;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseBook() {
        return courseBook;
    }

    public CourseVersion courseBook(String courseBook) {
        this.courseBook = courseBook;
        return this;
    }

    public void setCourseBook(String courseBook) {
        this.courseBook = courseBook;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public CourseVersion courseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
        return this;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public BaseCourse getCourse() {
        return course;
    }

    public CourseVersion course(BaseCourse baseCourse) {
        this.course = baseCourse;
        return this;
    }

    public void setCourse(BaseCourse baseCourse) {
        this.course = baseCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseVersion courseVersion = (CourseVersion) o;
        if (courseVersion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseVersion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseVersion{" +
            "id=" + getId() +
            ", courseCount='" + getCourseCount() + "'" +
            ", courseDoCount='" + getCourseDoCount() + "'" +
            ", courseLearnCount='" + getCourseLearnCount() + "'" +
            ", courseGrade='" + getCourseGrade() + "'" +
            ", courseDesc='" + getCourseDesc() + "'" +
            ", courseBook='" + getCourseBook() + "'" +
            ", courseStatus='" + getCourseStatus() + "'" +
            "}";
    }
}
