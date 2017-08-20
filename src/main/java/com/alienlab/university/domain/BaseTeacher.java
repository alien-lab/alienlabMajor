package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseTeacher.
 */
@Entity
@Table(name = "base_teacher")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_code")
    @ApiModelProperty(value="教工号")
    private String teacherCode;

    @Column(name = "teacher_name")
    @ApiModelProperty(value="教师姓名")
    private String teacherName;

    @Column(name = "teacher_title")
    @ApiModelProperty(value="教师职称")
    private String teacherTitle;

    @Column(name = "teacher_type")
    @ApiModelProperty(value="教师类型：校内教师、外聘教师")
    private String teacherType;

    @Column(name = "teacher_status")
    @ApiModelProperty(value="教师状态：正常、停用")
    private String teacherStatus;

    @ManyToOne
    @ApiModelProperty(value="所属部门")
    private BaseDepartment department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public BaseTeacher teacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
        return this;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public BaseTeacher teacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public BaseTeacher teacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
        return this;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public BaseTeacher teacherType(String teacherType) {
        this.teacherType = teacherType;
        return this;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public BaseTeacher teacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
        return this;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public BaseDepartment getDepartment() {
        return department;
    }

    public BaseTeacher department(BaseDepartment baseDepartment) {
        this.department = baseDepartment;
        return this;
    }

    public void setDepartment(BaseDepartment baseDepartment) {
        this.department = baseDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseTeacher baseTeacher = (BaseTeacher) o;
        if (baseTeacher.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseTeacher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseTeacher{" +
            "id=" + getId() +
            ", teacherCode='" + getTeacherCode() + "'" +
            ", teacherName='" + getTeacherName() + "'" +
            ", teacherTitle='" + getTeacherTitle() + "'" +
            ", teacherType='" + getTeacherType() + "'" +
            ", teacherStatus='" + getTeacherStatus() + "'" +
            "}";
    }
}
