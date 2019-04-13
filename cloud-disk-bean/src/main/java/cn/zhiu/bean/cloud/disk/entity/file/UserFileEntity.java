package cn.zhiu.bean.cloud.disk.entity.file;

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
@Table(name = "user_file")
public class UserFileEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_id", nullable = false)
    private String fileId;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "file_extension", nullable = false)
    private String fileExtension;

    @Column(name = "dir_id", nullable = false)
    private Long dirId;

    @Column(name = "path", nullable = false)
    private String path;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "file_update_time", nullable = false)
    private Date fileUpdateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_time", insertable = false, updatable = false, nullable = false)
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Long getDirId() {
        return dirId;
    }

    public void setDirId(Long dirId) {
        this.dirId = dirId;
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

    public Date getFileUpdateTime() {
        return fileUpdateTime;
    }

    public void setFileUpdateTime(Date fileUpdateTime) {
        this.fileUpdateTime = fileUpdateTime;
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
