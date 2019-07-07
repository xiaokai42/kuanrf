package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 舒缓调理
 * 
 */
@Entity
@Table(name = "kuanrf_shtl")
public class Shtl extends BaseEntity
{

    private static final long serialVersionUID = -8230464643786622371L;

    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 图片1
     */
    @Column(name = "shtl_img1", length = 50)
    private String shtlImg1;
    
    /**
     * 图片2
     */
    @Column(name = "shtl_img2", length = 50)
    private String shtlImg2;
    
    /**
     * 图片3
     */
    @Column(name = "shtl_img3", length = 50)
    private String shtlImg3;
    
    /**
     * 标题1
     */
    @Column(name = "shtl_title1", length = 50)
    private String shtlTitle1;
    
    /**
     * 标题2
     */
    @Column(name = "shtl_title2", length = 50)
    private String shtlTitle2;
    
    /**
     * 标题3
     */
    @Column(name = "shtl_title3", length = 50)
    private String shtlTitle3;

    /**
     * 描述1
     */
    @Column(name = "shtl_text1", columnDefinition = "text")
    private String shtlText1;

    /**
     * 描述2
     */
    @Column(name = "shtl_text2", columnDefinition = "text")
    private String shtlText2;

    /**
     * 描述3
     */
    @Column(name = "shtl_text3", columnDefinition = "text")
    private String shtlText3;

    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getShtlImg1()
    {
        return shtlImg1;
    }

    public void setShtlImg1(String shtlImg1)
    {
        this.shtlImg1 = shtlImg1;
    }

    public String getShtlImg2()
    {
        return shtlImg2;
    }

    public void setShtlImg2(String shtlImg2)
    {
        this.shtlImg2 = shtlImg2;
    }

    public String getShtlImg3()
    {
        return shtlImg3;
    }

    public void setShtlImg3(String shtlImg3)
    {
        this.shtlImg3 = shtlImg3;
    }

    public String getShtlTitle1()
    {
        return shtlTitle1;
    }

    public void setShtlTitle1(String shtlTitle1)
    {
        this.shtlTitle1 = shtlTitle1;
    }

    public String getShtlTitle2()
    {
        return shtlTitle2;
    }

    public void setShtlTitle2(String shtlTitle2)
    {
        this.shtlTitle2 = shtlTitle2;
    }

    public String getShtlTitle3()
    {
        return shtlTitle3;
    }

    public void setShtlTitle3(String shtlTitle3)
    {
        this.shtlTitle3 = shtlTitle3;
    }

    public String getShtlText1()
    {
        return shtlText1;
    }

    public void setShtlText1(String shtlText1)
    {
        this.shtlText1 = shtlText1;
    }

    public String getShtlText2()
    {
        return shtlText2;
    }

    public void setShtlText2(String shtlText2)
    {
        this.shtlText2 = shtlText2;
    }

    public String getShtlText3()
    {
        return shtlText3;
    }

    public void setShtlText3(String shtlText3)
    {
        this.shtlText3 = shtlText3;
    }

}
