package cn.zhiu.bean.user.entity.user;

import cn.zhiu.bean.user.entity.enums.convert.user.SexTypeConverter;
import cn.zhiu.bean.user.entity.enums.convert.user.UserStatusConverter;
import cn.zhiu.bean.user.entity.enums.user.SexType;
import cn.zhiu.bean.user.entity.enums.user.UserStatus;
import cn.zhiu.framework.bean.core.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_info")
public class UserInfoEntity implements BaseEntity {

    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String userId;

    /**
     * 账号
     */
    @Column(name = "account", nullable = false)
    private String account;

    /**
     * 昵称
     */
    @Column(name = "nick_name", nullable = false)
    private String nickName;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 性别(0:男,1:女,2:通用)
     */
    @Convert(converter = SexTypeConverter.class)
    @Column(name = "sex", nullable = false)
    private SexType sex;

    /**
     * 注册来源
     */
    @Column(name = "source")
    private String source;

    /**
     * 状态(0:正常,1:锁定)
     */
    @Convert(converter = UserStatusConverter.class)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    /**
     * 最后登录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_time", updatable = false, nullable = false)
    private Date addTime;

    /**
     * 最后登陆地址
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    private Date updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @PrePersist
    public void onCreate() {
        if (this.getAddTime() == null) {
            this.addTime = new Date();
        }
        if (this.getUpdateTime() == null) {
            this.updateTime = new Date();
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updateTime = new Date();
    }
}
