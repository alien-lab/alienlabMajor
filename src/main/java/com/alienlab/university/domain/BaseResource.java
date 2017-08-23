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
 * A BaseResource.
 */
@Entity
@Table(name = "base_resource")
@ApiModel(value="基础资源")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name")
    @ApiModelProperty(value="资源名称")
    private String resourceName;

    @Column(name = "resource_updatetime")
    @ApiModelProperty(value="资源上传时间")
    private ZonedDateTime resourceUpdatetime;

    @Column(name = "resource_url")
    @ApiModelProperty(value="资源地址")
    private String resourceUrl;

    @Column(name = "resource_size")
    @ApiModelProperty(value="资源文件大小：字节")
    private Integer resourceSize;

    @Column(name = "resource_md_5")
    @ApiModelProperty(value="资源md5")
    private String resourceMD5;

    @Column(name = "view_count")
    @ApiModelProperty(value="资源浏览数统计")
    private Long viewCount;

    @ManyToOne
    @ApiModelProperty(value="资源类型")
    private BaseResourceType resourceType;

    @ManyToOne
    @ApiModelProperty(value="关联的课程结构")
    private CourseStruct courseStruct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public BaseResource resourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public ZonedDateTime getResourceUpdatetime() {
        return resourceUpdatetime;
    }

    public BaseResource resourceUpdatetime(ZonedDateTime resourceUpdatetime) {
        this.resourceUpdatetime = resourceUpdatetime;
        return this;
    }

    public void setResourceUpdatetime(ZonedDateTime resourceUpdatetime) {
        this.resourceUpdatetime = resourceUpdatetime;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public BaseResource resourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public BaseResource resourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
        return this;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceMD5() {
        return resourceMD5;
    }

    public BaseResource resourceMD5(String resourceMD5) {
        this.resourceMD5 = resourceMD5;
        return this;
    }

    public void setResourceMD5(String resourceMD5) {
        this.resourceMD5 = resourceMD5;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public BaseResource viewCount(Long viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public BaseResourceType getResourceType() {
        return resourceType;
    }

    public BaseResource resourceType(BaseResourceType baseResourceType) {
        this.resourceType = baseResourceType;
        return this;
    }

    public void setResourceType(BaseResourceType baseResourceType) {
        this.resourceType = baseResourceType;
    }

    public CourseStruct getCourseStruct() {
        return courseStruct;
    }

    public BaseResource courseStruct(CourseStruct courseStruct) {
        this.courseStruct = courseStruct;
        return this;
    }

    public void setCourseStruct(CourseStruct courseStruct) {
        this.courseStruct = courseStruct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseResource baseResource = (BaseResource) o;
        if (baseResource.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseResource.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseResource{" +
            "id=" + getId() +
            ", resourceName='" + getResourceName() + "'" +
            ", resourceUpdatetime='" + getResourceUpdatetime() + "'" +
            ", resourceUrl='" + getResourceUrl() + "'" +
            ", resourceSize='" + getResourceSize() + "'" +
            ", resourceMD5='" + getResourceMD5() + "'" +
            ", viewCount='" + getViewCount() + "'" +
            "}";
    }
}
