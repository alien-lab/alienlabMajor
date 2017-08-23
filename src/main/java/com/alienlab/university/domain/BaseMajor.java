package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseMajor.
 */
@Entity
@Table(name = "base_major")
@ApiModel(value="专业基础信息")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseMajor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "major_code")
    @ApiModelProperty(value="专业代码")
    private String majorCode;

    @Column(name = "major_name")
    @ApiModelProperty(value="专业名称")
    private String majorName;

    @Column(name = "major_status")
    @ApiModelProperty(value="专业状态：正常、停用")
    private String majorStatus;

    @ManyToOne
    @ApiModelProperty(value="所属部门")
    private BaseDepartment department;

    @ManyToOne
    @ApiModelProperty(value="专业负责人")
    private BaseTeacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public BaseMajor majorCode(String majorCode) {
        this.majorCode = majorCode;
        return this;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public BaseMajor majorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorStatus() {
        return majorStatus;
    }

    public BaseMajor majorStatus(String majorStatus) {
        this.majorStatus = majorStatus;
        return this;
    }

    public void setMajorStatus(String majorStatus) {
        this.majorStatus = majorStatus;
    }

    public BaseDepartment getDepartment() {
        return department;
    }

    public BaseMajor department(BaseDepartment baseDepartment) {
        this.department = baseDepartment;
        return this;
    }

    public void setDepartment(BaseDepartment baseDepartment) {
        this.department = baseDepartment;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public BaseMajor teacher(BaseTeacher baseTeacher) {
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
        BaseMajor baseMajor = (BaseMajor) o;
        if (baseMajor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseMajor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseMajor{" +
            "id=" + getId() +
            ", majorCode='" + getMajorCode() + "'" +
            ", majorName='" + getMajorName() + "'" +
            ", majorStatus='" + getMajorStatus() + "'" +
            "}";
    }
}
