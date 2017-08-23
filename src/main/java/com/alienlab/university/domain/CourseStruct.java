package com.alienlab.university.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A CourseStruct.
 */
@Entity
@Table(name = "course_struct")
@ApiModel(value="课程结构")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseStruct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "struct_name")
    @ApiModelProperty(value="课程结构名称")
    private String structName;

    @Column(name = "struct_code")
    @ApiModelProperty(value="结构编码")
    private String structCode;

    @Column(name = "struct_pcode")
    @ApiModelProperty(value="结构父级编码")
    private String structPcode;

    @Column(name = "datatime")
    @ApiModelProperty(value="导入时间")
    private ZonedDateTime datatime;

    @OneToMany(mappedBy = "courseStruct")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @ApiModelProperty(value="课程结构的资源")
    private Set<BaseResource> resources = new HashSet<>();

    @ManyToOne
    @ApiModelProperty(value="关联课程")
    private CourseVersion course;

    @ManyToOne
    @ApiModelProperty(value="关联教师")
    private BaseTeacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructName() {
        return structName;
    }

    public CourseStruct structName(String structName) {
        this.structName = structName;
        return this;
    }

    public void setStructName(String structName) {
        this.structName = structName;
    }

    public String getStructCode() {
        return structCode;
    }

    public CourseStruct structCode(String structCode) {
        this.structCode = structCode;
        return this;
    }

    public void setStructCode(String structCode) {
        this.structCode = structCode;
    }

    public String getStructPcode() {
        return structPcode;
    }

    public CourseStruct structPcode(String structPcode) {
        this.structPcode = structPcode;
        return this;
    }

    public void setStructPcode(String structPcode) {
        this.structPcode = structPcode;
    }

    public ZonedDateTime getDatatime() {
        return datatime;
    }

    public CourseStruct datatime(ZonedDateTime datatime) {
        this.datatime = datatime;
        return this;
    }

    public void setDatatime(ZonedDateTime datatime) {
        this.datatime = datatime;
    }

    public Set<BaseResource> getResources() {
        return resources;
    }

    public CourseStruct resources(Set<BaseResource> baseResources) {
        this.resources = baseResources;
        return this;
    }

    public CourseStruct addResources(BaseResource baseResource) {
        this.resources.add(baseResource);
        baseResource.setCourseStruct(this);
        return this;
    }

    public CourseStruct removeResources(BaseResource baseResource) {
        this.resources.remove(baseResource);
        baseResource.setCourseStruct(null);
        return this;
    }

    public void setResources(Set<BaseResource> baseResources) {
        this.resources = baseResources;
    }

    public CourseVersion getCourse() {
        return course;
    }

    public CourseStruct course(CourseVersion courseVersion) {
        this.course = courseVersion;
        return this;
    }

    public void setCourse(CourseVersion courseVersion) {
        this.course = courseVersion;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public CourseStruct teacher(BaseTeacher baseTeacher) {
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
        CourseStruct courseStruct = (CourseStruct) o;
        if (courseStruct.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseStruct.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseStruct{" +
            "id=" + getId() +
            ", structName='" + getStructName() + "'" +
            ", structCode='" + getStructCode() + "'" +
            ", structPcode='" + getStructPcode() + "'" +
            ", datatime='" + getDatatime() + "'" +
            "}";
    }
}
