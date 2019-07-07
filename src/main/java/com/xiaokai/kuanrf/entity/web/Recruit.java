package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 人才招聘
 * 
 */
@Entity
@Table(name = "kuanrf_recruit")
public class Recruit extends BaseEntity
{

    private static final long serialVersionUID = 6857359432929544762L;

    /**
     * icon
     */
    @Column(name = "recruit_icon", length = 50)
    private String recruitIcon;
    
    /**
     * 职位
     */
    @Column(length = 100)
    private String work;
    
    /**
     * 职位薪资
     */
    @Column(length = 100)
    private String money;

    /**
     * 岗位要求
     */
    @Column(columnDefinition = "text")
    private String duty;

    /**
     * 公司福利
     */
    @Column(columnDefinition = "text")
    private String welfare;
    
    /**
     * 联系方式
     */
    @Column(length = 50)
    private String phone;
    
    /**
     * 联系人
     */
    @Column(length = 50)
    private String person;
    
    /**
     * 发布状态
     */
    private Integer status;

    public String getRecruitIcon()
    {
        return recruitIcon;
    }

    public void setRecruitIcon(String recruitIcon)
    {
        this.recruitIcon = recruitIcon;
    }

    public String getWork()
    {
        return work;
    }

    public void setWork(String work)
    {
        this.work = work;
    }

    public String getMoney()
    {
        return money;
    }

    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getDuty()
    {
        return duty;
    }

    public void setDuty(String duty)
    {
        this.duty = duty;
    }

    public String getWelfare()
    {
        return welfare;
    }

    public void setWelfare(String welfare)
    {
        this.welfare = welfare;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPerson()
    {
        return person;
    }

    public void setPerson(String person)
    {
        this.person = person;
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
