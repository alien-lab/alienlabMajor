package com.alienlab.university.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A CourseGroupItem.
 */
@Entity
@Table(name = "course_group_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseGroupItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BaseCourse course;

    @ManyToOne
    private CourseGroup group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseCourse getCourse() {
        return course;
    }

    public CourseGroupItem course(BaseCourse baseCourse) {
        this.course = baseCourse;
        return this;
    }

    public void setCourse(BaseCourse baseCourse) {
        this.course = baseCourse;
    }

    public CourseGroup getGroup() {
        return group;
    }

    public CourseGroupItem group(CourseGroup courseGroup) {
        this.group = courseGroup;
        return this;
    }

    public void setGroup(CourseGroup courseGroup) {
        this.group = courseGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseGroupItem courseGroupItem = (CourseGroupItem) o;
        if (courseGroupItem.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseGroupItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseGroupItem{" +
            "id=" + getId() +
            "}";
    }
}
