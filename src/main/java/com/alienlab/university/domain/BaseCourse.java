package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="课程基础信息")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code")
    @ApiModelProperty(value="课程代码")
    private String courseCode;

    @Column(name = "course_name")
    @ApiModelProperty(value="课程名称")
    private String courseName;

    @Column(name = "course_type")
    @ApiModelProperty(value="课程类型：讲授课、实训课、任选课")
    private String courseType;

    @Column(name = "course_desc")
    @ApiModelProperty(value="课程描述")
    private String courseDesc;

    @Column(name = "course_status")
    @ApiModelProperty(value="课程状态：正常，停用")
    private String courseStatus;

    @ManyToOne
    @ApiModelProperty(value="课程负责人")
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
