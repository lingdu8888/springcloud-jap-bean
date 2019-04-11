package cn.zhiu.bean.user.entity.userlog;

import cn.zhiu.framework.bean.core.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_log")
public class UserLogEntity implements BaseEntity {

    /**
     * 记录id
     */
    @Id
    @Column(name = "log_id")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String logId;

    /**
     * 用户id
     */
    @Column(name = "user_id", nullable = false)
    private String userId;

    /**
     * 登录IP
     */
    @Column(name = "login_ip", nullable = false)
    private String loginIp;

    /**
     * 登录地址
     */
    @Column(name = "login_address", nullable = false)
    private String loginAddress;

    /**
     * 登陆时间
     */
    @Column(name = "login_time", nullable = false)
    private Date loginTime;


    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

}
