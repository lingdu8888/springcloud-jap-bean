package cn.zhiu.bean.cloud.disk.entity.directory;

import cn.zhiu.bean.cloud.disk.entity.enums.convert.file.StatusConverter;
import cn.zhiu.bean.cloud.disk.entity.enums.file.Status;
import cn.zhiu.framework.bean.core.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: yujuan
 * @Date: 19-4-11 10:49
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_direction")
public class UserDirectoryEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "direction_name", nullable = false)
    private String directionName;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    private String path;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_time", nullable = false)
    private Date addTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
