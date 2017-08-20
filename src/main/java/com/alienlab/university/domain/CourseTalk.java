package com.alienlab.university.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A CourseTalk.
 */
@Entity
@Table(name = "course_talk")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseTalk implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "talk_time")
    @ApiModelProperty(value="课程互动时间")
    private ZonedDateTime talkTime;

    @Column(name = "nick_name")
    @ApiModelProperty(value="互动者昵称")
    private String nickName;

    @Column(name = "icon")
    @ApiModelProperty(value="互动者头像")
    private String icon;

    @Column(name = "openid")
    @ApiModelProperty(value="互动者第三方身份id")
    private String openid;

    @Column(name = "memo")
    @ApiModelProperty(value="互动内容")
    private String memo;

    @Column(name = "code")
    @ApiModelProperty(value="互动编码，自动生成")
    private String code;

    @Column(name = "pcode")
    @ApiModelProperty(value="互动父级编码，与编码字段形成层级关系")
    private String pcode;

    @Column(name = "reply_to")
    @ApiModelProperty(value="互动回复")
    private String replyTo;

    @ManyToOne
    @ApiModelProperty(value="课程课堂")
    private CourseOnClass courseOnClass;

    @ManyToOne
    @ApiModelProperty(value="关联教师")
    private BaseTeacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getTalkTime() {
        return talkTime;
    }

    public CourseTalk talkTime(ZonedDateTime talkTime) {
        this.talkTime = talkTime;
        return this;
    }

    public void setTalkTime(ZonedDateTime talkTime) {
        this.talkTime = talkTime;
    }

    public String getNickName() {
        return nickName;
    }

    public CourseTalk nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public CourseTalk icon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getOpenid() {
        return openid;
    }

    public CourseTalk openid(String openid) {
        this.openid = openid;
        return this;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMemo() {
        return memo;
    }

    public CourseTalk memo(String memo) {
        this.memo = memo;
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCode() {
        return code;
    }

    public CourseTalk code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPcode() {
        return pcode;
    }

    public CourseTalk pcode(String pcode) {
        this.pcode = pcode;
        return this;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public CourseTalk replyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public CourseOnClass getCourseOnClass() {
        return courseOnClass;
    }

    public CourseTalk courseOnClass(CourseOnClass courseOnClass) {
        this.courseOnClass = courseOnClass;
        return this;
    }

    public void setCourseOnClass(CourseOnClass courseOnClass) {
        this.courseOnClass = courseOnClass;
    }

    public BaseTeacher getTeacher() {
        return teacher;
    }

    public CourseTalk teacher(BaseTeacher baseTeacher) {
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
        CourseTalk courseTalk = (CourseTalk) o;
        if (courseTalk.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseTalk.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseTalk{" +
            "id=" + getId() +
            ", talkTime='" + getTalkTime() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", icon='" + getIcon() + "'" +
            ", openid='" + getOpenid() + "'" +
            ", memo='" + getMemo() + "'" +
            ", code='" + getCode() + "'" +
            ", pcode='" + getPcode() + "'" +
            ", replyTo='" + getReplyTo() + "'" +
            "}";
    }
}
