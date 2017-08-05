package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A TeacherResource.
 */
@Entity
@Table(name = "teacher_resource")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TeacherResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_private")
    private String isPrivate;

    @Column(name = "add_time")
    private ZonedDateTime addTime;

    @Column(name = "title")
    private String title;

    @ManyToOne
    private BaseTeacher teacher;

    @ManyToOne
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

    public TeacherResource isPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
        return this;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public ZonedDateTime getAddTime() {
        return addTime;
    }

    public TeacherResource addTime(ZonedDateTime addTime) {
        this.addTime = addTime;
        return this;
    }

    public void setAddTime(ZonedDateTime addTime) {
        this.addTime = addTime;
    }

    public String getTitle() {
        return title;
    }

    public TeacherResource title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public TeacherResource teacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
        return this;
    }

    public void setTeacher(BaseTeacher baseTeacher) {
        this.teacher = baseTeacher;
    }

    public BaseResource getResource() {
        return resource;
    }

    public TeacherResource resource(BaseResource baseResource) {
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
        TeacherResource teacherResource = (TeacherResource) o;
        if (teacherResource.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), teacherResource.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TeacherResource{" +
            "id=" + getId() +
            ", isPrivate='" + getIsPrivate() + "'" +
            ", addTime='" + getAddTime() + "'" +
            ", title='" + getTitle() + "'" +
            "}";
    }
}
