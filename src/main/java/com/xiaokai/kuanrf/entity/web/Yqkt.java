package com.xiaokai.kuanrf.entity.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 孕期课堂
 * 
 */
@Entity
@Table(name = "kuanrf_yqkt")
public class Yqkt extends BaseEntity
{

    private static final long serialVersionUID = 7730656346987398164L;

    /**
     * 标题
     */
    @Column(name = "title", length = 255)
    private String title;

    /**
     * 发布时间
     */
    @Column(columnDefinition = "datetime")
    private Date activeDt;

    /**
     * 首页显示图片id
     */
    @Column(name = "first_img", length = 50)
    private String firstImg;

    /**
     * 内容
     */
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 内容的纯文本
     */
    @Column(columnDefinition = "text")
    private String txt;
    
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

    public Date getActiveDt()
    {
        return activeDt;
    }

    public void setActiveDt(Date activeDt)
    {
        this.activeDt = activeDt;
    }

    public String getFirstImg()
    {
        return firstImg;
    }

    public void setFirstImg(String firstImg)
    {
        this.firstImg = firstImg;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTxt()
    {
        return txt;
    }

    public void setTxt(String txt)
    {
        this.txt = txt;
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
