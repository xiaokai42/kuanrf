package com.xiaokai.kuanrf.entity.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 精彩活动
 * 
 */
@Entity
@Table(name = "kuanrf_active")
public class Active extends BaseEntity
{

    private static final long serialVersionUID = 7674545028765947596L;
    
    /**
     * 活动标题
     */
    @Column(name = "title", length = 255)
    private String title;

    /**
     * 活动类型：10-宽仁妈妈学院;20-在住妈妈多彩活动
     */
    private Integer type;

    /**
     * 活动时间
     */
    @Column(columnDefinition = "datetime")
    private Date activeDt;

    /**
     * 活动时间-月
     */
    @Column(length = 10)
    private String month;

    /**
     * 活动时间-日
     */
    @Column(length = 10)
    private String day;

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

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public Date getActiveDt()
    {
        return activeDt;
    }

    public void setActiveDt(Date activeDt)
    {
        this.activeDt = activeDt;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
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
