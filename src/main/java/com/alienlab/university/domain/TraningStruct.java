package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TraningStruct.
 */
@Entity
@Table(name = "traning_struct")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TraningStruct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "struct_code")
    @ApiModelProperty(value="结构代码")
    private String structCode;

    @Column(name = "struct_name")
    @ApiModelProperty(value="结构名称")
    private String structName;

    @Column(name = "struct_status")
    @ApiModelProperty(value="结构状态")
    private String structStatus;

    @Column(name = "struct_json")
    @ApiModelProperty(value="结构配置JSON")
    private String structJSON;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructCode() {
        return structCode;
    }

    public TraningStruct structCode(String structCode) {
        this.structCode = structCode;
        return this;
    }

    public void setStructCode(String structCode) {
        this.structCode = structCode;
    }

    public String getStructName() {
        return structName;
    }

    public TraningStruct structName(String structName) {
        this.structName = structName;
        return this;
    }

    public void setStructName(String structName) {
        this.structName = structName;
    }

    public String getStructStatus() {
        return structStatus;
    }

    public TraningStruct structStatus(String structStatus) {
        this.structStatus = structStatus;
        return this;
    }

    public void setStructStatus(String structStatus) {
        this.structStatus = structStatus;
    }

    public String getStructJSON() {
        return structJSON;
    }

    public TraningStruct structJSON(String structJSON) {
        this.structJSON = structJSON;
        return this;
    }

    public void setStructJSON(String structJSON) {
        this.structJSON = structJSON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraningStruct traningStruct = (TraningStruct) o;
        if (traningStruct.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), traningStruct.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TraningStruct{" +
            "id=" + getId() +
            ", structCode='" + getStructCode() + "'" +
            ", structName='" + getStructName() + "'" +
            ", structStatus='" + getStructStatus() + "'" +
            ", structJSON='" + getStructJSON() + "'" +
            "}";
    }
}
