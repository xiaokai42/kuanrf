package com.xiaokai.kuanrf.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据基础实体类
 * 
 * @author wuy
 */
@MappedSuperclass
public class BaseEntity implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -4460573345534648382L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "create_date", columnDefinition = "datetime", nullable = true)
    private Date createDate;

    @Column(name = "update_date", columnDefinition = "datetime", nullable = true)
    private Date updateDate;

    /**
     * 构造方法
     */
    public BaseEntity()
    {
        this.setId(UUID.randomUUID().toString());
        this.setCreateDate(Calendar.getInstance().getTime());
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

}
