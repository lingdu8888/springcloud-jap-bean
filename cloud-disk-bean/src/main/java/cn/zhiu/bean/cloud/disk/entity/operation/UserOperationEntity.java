package cn.zhiu.bean.cloud.disk.entity.operation;

import cn.zhiu.bean.cloud.disk.entity.enums.convert.operation.FileOperationStatusConverter;
import cn.zhiu.bean.cloud.disk.entity.enums.convert.operation.FileOperationTypeConvert;
import cn.zhiu.bean.cloud.disk.entity.enums.operation.FileOperationStatus;
import cn.zhiu.bean.cloud.disk.entity.enums.operation.FileOperationType;
import cn.zhiu.framework.bean.core.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: yujuan
 * @Date: 19-4-11 10:50
 * @Description:
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_operation")
public class UserOperationEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "file_id", nullable = false)
    private String fileId;

    @Convert(converter = FileOperationTypeConvert.class)
    @Column(name = "type", nullable = false)
    private FileOperationType type;

    @Convert(converter = FileOperationStatusConverter.class)
    @Column(name = "status", nullable = false)
    private FileOperationStatus status;

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public FileOperationType getType() {
        return type;
    }

    public void setType(FileOperationType type) {
        this.type = type;
    }

    public FileOperationStatus getStatus() {
        return status;
    }

    public void setStatus(FileOperationStatus status) {
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
