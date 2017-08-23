package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A CourseOnClass.
 */
@Entity
@Table(name = "course_on_class")
@ApiModel(value="课程课堂")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseOnClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_pre")
    @ApiModelProperty(value="课程课前准备内容")
    private String coursePre;

    @Column(name = "course_after")
    @ApiModelProperty(value="课程课后内容")
    private String courseAfter;

    @Column(name = "course_ing")
    @ApiModelProperty(value="课程上课时")
    private String courseIng;

    @Column(name = "course_time")
    @ApiModelProperty(value="上课时间")
    private ZonedDateTime courseTime;

    @ManyToOne
    @ApiModelProperty(value="关联课程")
    private CourseVersion course;

    @ManyToOne
    @ApiModelProperty(value="关联教师")
    private BaseTeacher teacher;

    @ManyToOne
    @ApiModelProperty(value="关联课程信息")
    private BaseClasses classInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursePre() {
        return coursePre;
    }

    public CourseOnClass coursePre(String coursePre) {
        this.coursePre = coursePre;
        return this;
    }

    public void setCoursePre(String coursePre) {
        this.coursePre = coursePre;
    }

    public String getCourseAfter() {
        return courseAfter;
    }

    public CourseOnClass courseAfter(String courseAfter) {
        this.courseAfter = courseAfter;
        return this;
    }

    public void setCourseAfter(String courseAfter) {
        this.courseAfter = courseAfter;
    }

    public String getCourseIng() {
        return courseIng;
    }

    public CourseOnClass courseIng(String courseIng) {
        this.courseIng = courseIng;
        return this;
    }

    public void setCourseIng(String courseIng) {
        this.courseIng = courseIng;
    }

    public ZonedDateTime getCourseTime() {
        return courseTime;
    }

    public CourseOnClass courseTime(ZonedDateTime courseTime) {
        this.courseTime = courseTime;
        return this;
    }

    public void setCourseTime(ZonedDateTime courseTime) {
        this.courseTime = courseTime;
    }

    public CourseVersion getCourse() {
        return course;
    }

    public CourseOnClass course(CourseVersion courseVersion) {
        this.course = courseVersion;
        return this;
    }

    public void setCourse(CourseVersion courseVersion) {
        this.course = courseVersion;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public CourseOnClass teacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
        return this;
    }

    public void setTeacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
    }

    public BaseClasses getClassInfo() {
        return classInfo;
    }

    public CourseOnClass classInfo(BaseClasses baseClasses) {
        this.classInfo = baseClasses;
        return this;
    }

    public void setClassInfo(BaseClasses baseClasses) {
        this.classInfo = baseClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseOnClass courseOnClass = (CourseOnClass) o;
        if (courseOnClass.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseOnClass.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseOnClass{" +
            "id=" + getId() +
            ", coursePre='" + getCoursePre() + "'" +
            ", courseAfter='" + getCourseAfter() + "'" +
            ", courseIng='" + getCourseIng() + "'" +
            ", courseTime='" + getCourseTime() + "'" +
            "}";
    }
}
