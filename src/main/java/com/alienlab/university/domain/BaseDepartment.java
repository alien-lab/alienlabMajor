package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseDepartment.
 */
@Entity
@Table(name = "base_department")
@ApiModel(value="部门")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dep_code")
    @ApiModelProperty(value="部门代码")
    private String depCode;

    @Column(name = "dep_name")
    @ApiModelProperty(value="部门名称")
    private String depName;

    @Column(name = "dep_type")
    @ApiModelProperty(value="部门类型：教学、行政")
    private String depType;

    @Column(name = "dep_shot_name")
    @ApiModelProperty(value="部门简称")
    private String depShotName;

    @Column(name = "dep_sort")
    @ApiModelProperty(value="排序")
    private Integer depSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepCode() {
        return depCode;
    }

    public BaseDepartment depCode(String depCode) {
        this.depCode = depCode;
        return this;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public BaseDepartment depName(String depName) {
        this.depName = depName;
        return this;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepType() {
        return depType;
    }

    public BaseDepartment depType(String depType) {
        this.depType = depType;
        return this;
    }

    public void setDepType(String depType) {
        this.depType = depType;
    }

    public String getDepShotName() {
        return depShotName;
    }

    public BaseDepartment depShotName(String depShotName) {
        this.depShotName = depShotName;
        return this;
    }

    public void setDepShotName(String depShotName) {
        this.depShotName = depShotName;
    }

    public Integer getDepSort() {
        return depSort;
    }

    public BaseDepartment depSort(Integer depSort) {
        this.depSort = depSort;
        return this;
    }

    public void setDepSort(Integer depSort) {
        this.depSort = depSort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseDepartment baseDepartment = (BaseDepartment) o;
        if (baseDepartment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseDepartment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseDepartment{" +
            "id=" + getId() +
            ", depCode='" + getDepCode() + "'" +
            ", depName='" + getDepName() + "'" +
            ", depType='" + getDepType() + "'" +
            ", depShotName='" + getDepShotName() + "'" +
            ", depSort='" + getDepSort() + "'" +
            "}";
    }
}
