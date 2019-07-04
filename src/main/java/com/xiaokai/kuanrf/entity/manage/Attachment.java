package com.xiaokai.kuanrf.entity.manage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 附件，文件，图片，视频
 * 
 * @author wuy
 */
@Entity
@Table(name = "rural_manage_attachment")
public class Attachment extends BaseEntity
{

    private static final long serialVersionUID = -5367535870877929613L;

    /**
     * 类型（ 10-首页大图;11-首页品牌优势图片;12-首页探索门店图片;13-首页服务项目图片;14-首页发现更多图片;15-二维码 ）
     */
    private int type;

    /**
     * 业务关联ID
     */
    @Column(name = "business_id")
    private String businessId;

    /**
     * 文件原名称，如：图片1
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件改变后的名称，统一用uuid生成
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 文件所在磁盘，如：（D:）
     */
    @Column(name = "file_disk")
    private String fileDisk;

    /**
     * 文件根目录，如： /rural/attachment
     */
    @Column(name = "root_path")
    private String rootPath;

    /**
     * 文件相对路径，如：/10/2018/uuid.jpg
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 文件后缀，如：（.jpg/.rar/.zip）
     */
    @Column(name = "file_suffix")
    private String fileSuffix;

    /**
     * 文件大小，单位：B
     */
    @Column(name = "file_size")
    private long fileSize;

    /**
     * 上传用户ID
     */
    @Column(name = "user_id")
    private String userId;

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public long getFileSize()
    {
        return fileSize;
    }

    public void setFileSize(long fileSize)
    {
        this.fileSize = fileSize;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getFileDisk()
    {
        return fileDisk;
    }

    public void setFileDisk(String fileDisk)
    {
        this.fileDisk = fileDisk;
    }

    public String getRootPath()
    {
        return rootPath;
    }

    public void setRootPath(String rootPath)
    {
        this.rootPath = rootPath;
    }

    public String getFileSuffix()
    {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix)
    {
        this.fileSuffix = fileSuffix;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getBusinessId()
    {
        return businessId;
    }

    public void setBusinessId(String businessId)
    {
        this.businessId = businessId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

}