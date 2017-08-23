package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(value = "课程组")
@Entity
@Table(name = "course_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    @ApiModelProperty(value="课程组名称")
    private String groupName;

    @Column(name = "group_sort")
    @ApiModelProperty(value="课程组排序")
    private Integer groupSort;

    @Column(name = "group_type")
    @ApiModelProperty(value="课程组类型：")
    private String groupType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public CourseGroup groupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupSort() {
        return groupSort;
    }

    public CourseGroup groupSort(Integer groupSort) {
        this.groupSort = groupSort;
        return this;
    }

    public void setGroupSort(Integer groupSort) {
        this.groupSort = groupSort;
    }

    public String getGroupType() {
        return groupType;
    }

    public CourseGroup groupType(String groupType) {
        this.groupType = groupType;
        return this;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseGroup courseGroup = (CourseGroup) o;
        if (courseGroup.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseGroup.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseGroup{" +
            "id=" + getId() +
            ", groupName='" + getGroupName() + "'" +
            ", groupSort='" + getGroupSort() + "'" +
            ", groupType='" + getGroupType() + "'" +
            "}";
    }
}
