package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A BaseResourceType.
 */
@Entity
@Table(name = "base_resource_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseResourceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_type_name")
    @ApiModelProperty(value="资源类型名称：作业、课件、教学视频")
    private String resourceTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public BaseResourceType resourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
        return this;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseResourceType baseResourceType = (BaseResourceType) o;
        if (baseResourceType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseResourceType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseResourceType{" +
            "id=" + getId() +
            ", resourceTypeName='" + getResourceTypeName() + "'" +
            "}";
    }
}
