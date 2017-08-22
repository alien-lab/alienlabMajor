package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A CourseTree.
 */
@Entity
@Table(name = "course_tree")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tree_desc")
    @ApiModelProperty(value="课程树关系描述")
    private String treeDesc;

    @ManyToOne
    @ApiModelProperty(value="关联课程")
    private CourseVersion courseVersion;

    @ManyToOne
    @ApiModelProperty(value="前序课程")
    private CourseVersion preCourseVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public CourseTree treeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
        return this;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public CourseVersion getCourseVersion() {
        return courseVersion;
    }

    public CourseTree courseVersion(CourseVersion courseVersion) {
        this.courseVersion = courseVersion;
        return this;
    }

    public void setCourseVersion(CourseVersion courseVersion) {
        this.courseVersion = courseVersion;
    }

    public CourseVersion getPreCourseVersion() {
        return preCourseVersion;
    }

    public CourseTree preCourseVersion(CourseVersion courseVersion) {
        this.preCourseVersion = courseVersion;
        return this;
    }

    public void setPreCourseVersion(CourseVersion courseVersion) {
        this.preCourseVersion = courseVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseTree courseTree = (CourseTree) o;
        if (courseTree.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseTree.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseTree{" +
            "id=" + getId() +
            ", treeDesc='" + getTreeDesc() + "'" +
            "}";
    }
}
