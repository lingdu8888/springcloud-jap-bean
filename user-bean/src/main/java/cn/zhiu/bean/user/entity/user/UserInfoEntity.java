package cn.zhiu.bean.user.entity.user;

import cn.zhiu.bean.user.entity.enums.convert.user.UserStatusConverter;
import cn.zhiu.bean.user.entity.enums.user.UserStatus;
import cn.zhiu.framework.bean.core.entity.BaseEntity;

import javax.persistence.*;

/**
 * The type User info.
 *
 * @author zhuzz
 * @time 2019 /04/03 18:24:29
 */
@Entity
@Table(name = "user_info")
public class UserInfoEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(name = "user_name")
    private String userName;


    @Convert(converter = UserStatusConverter.class)
    @Column(name = "status", nullable = false)
    private UserStatus status;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
