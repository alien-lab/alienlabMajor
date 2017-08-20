package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A CourseResource.
 */
@Entity
@Table(name = "course_resource")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_private")
    @ApiModelProperty(value="是否私有资源，私有资源仅自己可见、自己可分享")
    private String isPrivate;

    @Column(name = "add_time")
    @ApiModelProperty(value="课程资源添加时间")
    private ZonedDateTime addTime;

    @Column(name = "title")
    @ApiModelProperty(value="资源标题")
    private String title;

    @ManyToOne
    @ApiModelProperty(value="资源上传教师")
    private BaseTeacher teacher;

    @ManyToOne
    @ApiModelProperty(value="关联的基础资源")
    private BaseResource resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public CourseResource isPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public ZonedDateTime getAddTime() {
        return addTime;
    }

    public CourseResource addTime(ZonedDateTime addTime) {
        this.addTime = addTime;
        return this;
    }

    public void setAddTime(ZonedDateTime addTime) {
        this.addTime = addTime;
    }

    public String getTitle() {
        return title;
    }

    public CourseResource title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public CourseResource teacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
        return this;
    }

    public void setTeacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
    }

    public BaseResource getResource() {
        return resource;
    }

    public CourseResource resource(BaseResource baseResource) {
        this.resource = baseResource;
        return this;
    }

    public void setResource(BaseResource baseResource) {
        this.resource = baseResource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseResource courseResource = (CourseResource) o;
        if (courseResource.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseResource.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseResource{" +
            "id=" + getId() +
            ", isPrivate='" + getIsPrivate() + "'" +
            ", addTime='" + getAddTime() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }
}
