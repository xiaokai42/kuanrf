package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 女性私密护养
 * 
 */
@Entity
@Table(name = "kuanrf_nxsmhy")
public class Nxsmhy extends BaseEntity
{

    private static final long serialVersionUID = -5074393690055627816L;
    
    /**
     * 标题
     */
    @Column(name = "title", length = 50)
    private String title;
    
    /**
     * icon
     */
    @Column(name = "icon", length = 50)
    private String icon;
    
    /**
     * img
     */
    @Column(name = "img", length = 50)
    private String img;
    
    /**
     * 描述
     */
    @Column(name = "text", columnDefinition = "text")
    private String text;
    
    /**
     * 发布状态
     */
    private Integer status;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
}
