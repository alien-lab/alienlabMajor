package com.alienlab.university.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TraningData.
 */
@Entity
@Table(name = "traning_data")
@ApiModel(value="人才培养方案数据")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TraningData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "struct_key")
    @ApiModelProperty(value="结构key")
    private String structKey;

    @Column(name = "struct_lable")
    @ApiModelProperty(value="结构标题")
    private String structLable;

    @Column(name = "struct_value")
    @ApiModelProperty(value="结构值")
    private String structValue;

    @ManyToOne
    @ApiModelProperty(value="结构与人才培养方案关联关系")
    private TraningStructRelation relation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStructKey() {
        return structKey;
    }

    public TraningData structKey(String structKey) {
        this.structKey = structKey;
        return this;
    }

    public void setStructKey(String structKey) {
        this.structKey = structKey;
    }

    public String getStructLable() {
        return structLable;
    }

    public TraningData structLable(String structLable) {
        this.structLable = structLable;
        return this;
    }

    public void setStructLable(String structLable) {
        this.structLable = structLable;
    }

    public String getStructValue() {
        return structValue;
    }

    public TraningData structValue(String structValue) {
        this.structValue = structValue;
        return this;
    }

    public void setStructValue(String structValue) {
        this.structValue = structValue;
    }

    public TraningStructRelation getRelation() {
        return relation;
    }

    public TraningData relation(TraningStructRelation traningStructRelation) {
        this.relation = traningStructRelation;
        return this;
    }

    public void setRelation(TraningStructRelation traningStructRelation) {
        this.relation = traningStructRelation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraningData traningData = (TraningData) o;
        if (traningData.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), traningData.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TraningData{" +
            "id=" + getId() +
            ", structKey='" + getStructKey() + "'" +
            ", structLable='" + getStructLable() + "'" +
            ", structValue='" + getStructValue() + "'" +
            "}";
    }
}
