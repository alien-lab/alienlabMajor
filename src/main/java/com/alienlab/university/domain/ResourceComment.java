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
 * A ResourceComment.
 */
@Entity
@Table(name = "resource_comment")
@ApiModel(value="资源评论")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ResourceComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_time")
    @ApiModelProperty(value="评论时间")
    private ZonedDateTime commentTime;

    @Column(name = "nick_name")
    @ApiModelProperty(value="昵称")
    private String nickName;

    @Column(name = "icon")
    @ApiModelProperty(value="头像")
    private String icon;

    @Column(name = "openid")
    @ApiModelProperty(value="第三方身份id")
    private String openid;

    @Column(name = "memo")
    @ApiModelProperty(value="评论内容")
    private String memo;

    @Column(name = "grade")
    @ApiModelProperty(value="打分")
    private Integer grade;

    @ManyToOne
    @ApiModelProperty(value="关联课程资源")
    private CourseResource resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCommentTime() {
        return commentTime;
    }

    public ResourceComment commentTime(ZonedDateTime commentTime) {
        this.commentTime = commentTime;
        return this;
    }

    public void setCommentTime(ZonedDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public String getNickName() {
        return nickName;
    }

    public ResourceComment nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public ResourceComment icon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOpenid() {
        return openid;
    }

    public ResourceComment openid(String openid) {
        this.openid = openid;
        return this;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMemo() {
        return memo;
    }

    public ResourceComment memo(String memo) {
        this.memo = memo;
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getGrade() {
        return grade;
    }

    public ResourceComment grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public CourseResource getResource() {
        return resource;
    }

    public ResourceComment resource(CourseResource courseResource) {
        this.resource = courseResource;
        return this;
    }

    public void setResource(CourseResource courseResource) {
        this.resource = courseResource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResourceComment resourceComment = (ResourceComment) o;
        if (resourceComment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), resourceComment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ResourceComment{" +
            "id=" + getId() +
            ", commentTime='" + getCommentTime() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", icon='" + getIcon() + "'" +
            ", openid='" + getOpenid() + "'" +
            ", memo='" + getMemo() + "'" +
            ", grade='" + getGrade() + "'" +
            "}";
    }
}
