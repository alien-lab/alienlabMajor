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
 * A MajorTraning.
 */
@Entity
@Table(name = "major_traning")
@ApiModel(value="专业人才培养方案")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MajorTraning implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "traning_type")
    @ApiModelProperty(value="人才培养方案类型：五年制、三年制、高中、中职")
    private String traningType;

    @Column(name = "traning_status")
    @ApiModelProperty(value="人才培养方案状态")
    private String traningStatus;

    @Column(name = "traning_version")
    @ApiModelProperty(value="版本号")
    private Integer traningVersion;

    @Column(name = "traning_year")
    @ApiModelProperty(value="年份")
    private String traningYear;

    @Column(name = "create_time")
    @ApiModelProperty(value="创建时间")
    private ZonedDateTime createTime;

    @ManyToOne
    @ApiModelProperty(value="关联专业")
    private BaseMajor major;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTraningType() {
        return traningType;
    }

    public MajorTraning traningType(String traningType) {
        this.traningType = traningType;
        return this;
    }

    public void setTraningType(String traningType) {
        this.traningType = traningType;
    }

    public String getTraningStatus() {
        return traningStatus;
    }

    public MajorTraning traningStatus(String traningStatus) {
        this.traningStatus = traningStatus;
        return this;
    }

    public void setTraningStatus(String traningStatus) {
        this.traningStatus = traningStatus;
    }

    public Integer getTraningVersion() {
        return traningVersion;
    }

    public MajorTraning traningVersion(Integer traningVersion) {
        this.traningVersion = traningVersion;
        return this;
    }

    public void setTraningVersion(Integer traningVersion) {
        this.traningVersion = traningVersion;
    }

    public String getTraningYear() {
        return traningYear;
    }

    public MajorTraning traningYear(String traningYear) {
        this.traningYear = traningYear;
        return this;
    }

    public void setTraningYear(String traningYear) {
        this.traningYear = traningYear;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public MajorTraning createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public BaseMajor getMajor() {
        return major;
    }

    public MajorTraning major(BaseMajor baseMajor) {
        this.major = baseMajor;
        return this;
    }

    public void setMajor(BaseMajor baseMajor) {
        this.major = baseMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MajorTraning majorTraning = (MajorTraning) o;
        if (majorTraning.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), majorTraning.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MajorTraning{" +
            "id=" + getId() +
            ", traningType='" + getTraningType() + "'" +
            ", traningStatus='" + getTraningStatus() + "'" +
            ", traningVersion='" + getTraningVersion() + "'" +
            ", traningYear='" + getTraningYear() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}
