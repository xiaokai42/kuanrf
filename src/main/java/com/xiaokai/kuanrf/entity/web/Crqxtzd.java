package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 产褥期形体指导
 * 
 */
@Entity
@Table(name = "kuanrf_crqxtzd")
public class Crqxtzd extends BaseEntity
{
    
    private static final long serialVersionUID = -5042686095527571905L;

    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 图片1
     */
    @Column(name = "crqxtzd_img1", length = 50)
    private String crqxtzdImg1;
    
    /**
     * 图片2
     */
    @Column(name = "crqxtzd_img2", length = 50)
    private String crqxtzdImg2;
    
    /**
     * 图片3
     */
    @Column(name = "crqxtzd_img3", length = 50)
    private String crqxtzdImg3;
    
    /**
     * 标题1
     */
    @Column(name = "crqxtzd_title1", length = 100)
    private String crqxtzdTitle1;
    
    /**
     * 标题2
     */
    @Column(name = "crqxtzd_title2", length = 100)
    private String crqxtzdTitle2;
    
    /**
     * 标题3
     */
    @Column(name = "crqxtzd_title3", length = 100)
    private String crqxtzdTitle3;
    
    /**
     * 描述1
     */
    @Column(name = "crqxtzd_text1", columnDefinition = "text")
    private String crqxtzdText1;
    
    /**
     * 描述2
     */
    @Column(name = "crqxtzd_text2", columnDefinition = "text")
    private String crqxtzdText2;
    
    /**
     * 描述3
     */
    @Column(name = "crqxtzd_text3", columnDefinition = "text")
    private String crqxtzdText3;
    
    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getCrqxtzdImg1()
    {
        return crqxtzdImg1;
    }

    public void setCrqxtzdImg1(String crqxtzdImg1)
    {
        this.crqxtzdImg1 = crqxtzdImg1;
    }

    public String getCrqxtzdImg2()
    {
        return crqxtzdImg2;
    }

    public void setCrqxtzdImg2(String crqxtzdImg2)
    {
        this.crqxtzdImg2 = crqxtzdImg2;
    }

    public String getCrqxtzdImg3()
    {
        return crqxtzdImg3;
    }

    public void setCrqxtzdImg3(String crqxtzdImg3)
    {
        this.crqxtzdImg3 = crqxtzdImg3;
    }

    public String getCrqxtzdTitle1()
    {
        return crqxtzdTitle1;
    }

    public void setCrqxtzdTitle1(String crqxtzdTitle1)
    {
        this.crqxtzdTitle1 = crqxtzdTitle1;
    }

    public String getCrqxtzdTitle2()
    {
        return crqxtzdTitle2;
    }

    public void setCrqxtzdTitle2(String crqxtzdTitle2)
    {
        this.crqxtzdTitle2 = crqxtzdTitle2;
    }

    public String getCrqxtzdTitle3()
    {
        return crqxtzdTitle3;
    }

    public void setCrqxtzdTitle3(String crqxtzdTitle3)
    {
        this.crqxtzdTitle3 = crqxtzdTitle3;
    }

    public String getCrqxtzdText1()
    {
        return crqxtzdText1;
    }

    public void setCrqxtzdText1(String crqxtzdText1)
    {
        this.crqxtzdText1 = crqxtzdText1;
    }

    public String getCrqxtzdText2()
    {
        return crqxtzdText2;
    }

    public void setCrqxtzdText2(String crqxtzdText2)
    {
        this.crqxtzdText2 = crqxtzdText2;
    }

    public String getCrqxtzdText3()
    {
        return crqxtzdText3;
    }

    public void setCrqxtzdText3(String crqxtzdText3)
    {
        this.crqxtzdText3 = crqxtzdText3;
    }

}
