package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 宝宝护理
 * 
 */
@Entity
@Table(name = "kuanrf_bbhl")
public class Bbhl extends BaseEntity
{

    private static final long serialVersionUID = -4267121331330499159L;

    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 图片1
     */
    @Column(name = "bbhl_img1", length = 50)
    private String bbhlImg1;
    
    /**
     * 图片2
     */
    @Column(name = "bbhl_img2", length = 50)
    private String bbhlImg2;
    
    /**
     * 图片3
     */
    @Column(name = "bbhl_img3", length = 50)
    private String bbhlImg3;
    
    /**
     * 图片4
     */
    @Column(name = "bbhl_img4", length = 50)
    private String bbhlImg4;
    
    /**
     * 图片5
     */
    @Column(name = "bbhl_img5", length = 50)
    private String bbhlImg5;
    
    /**
     * 图片1-描述1
     */
    @Column(name = "bbhl_img1_text1")
    private String bbhlImg1Text1;
    
    /**
     * 图片1-描述2
     */
    @Column(name = "bbhl_img1_text2")
    private String bbhlImg1Text2;
    
    /**
     * 图片1-描述3
     */
    @Column(name = "bbhl_img1_text3")
    private String bbhlImg1Text3;
    
    /**
     * 图片2-描述1
     */
    @Column(name = "bbhl_img2_text1")
    private String bbhlImg2Text1;
    
    /**
     * 图片2-描述2
     */
    @Column(name = "bbhl_img2_text2")
    private String bbhlImg2Text2;
    
    /**
     * 图片2-描述3
     */
    @Column(name = "bbhl_img2_text3")
    private String bbhlImg2Text3;
    
    /**
     * 图片3-描述1
     */
    @Column(name = "bbhl_img3_text1")
    private String bbhlImg3Text1;
    
    /**
     * 图片3-描述2
     */
    @Column(name = "bbhl_img3_text2")
    private String bbhlImg3Text2;
    
    /**
     * 图片3-描述3
     */
    @Column(name = "bbhl_img3_text3")
    private String bbhlImg3Text3;
    
    /**
     * 图片4-描述1
     */
    @Column(name = "bbhl_img4_text1")
    private String bbhlImg4Text1;
    
    /**
     * 图片4-描述2
     */
    @Column(name = "bbhl_img4_text2")
    private String bbhlImg4Text2;
    
    /**
     * 图片4-描述3
     */
    @Column(name = "bbhl_img4_text3")
    private String bbhlImg4Text3;
    
    /**
     * 图片5-描述1
     */
    @Column(name = "bbhl_img5_text1")
    private String bbhlImg5Text1;
    
    /**
     * 图片5-描述2
     */
    @Column(name = "bbhl_img5_text2")
    private String bbhlImg5Text2;
    
    /**
     * 图片5-描述3
     */
    @Column(name = "bbhl_img5_text3")
    private String bbhlImg5Text3;

    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getBbhlImg1()
    {
        return bbhlImg1;
    }

    public void setBbhlImg1(String bbhlImg1)
    {
        this.bbhlImg1 = bbhlImg1;
    }

    public String getBbhlImg2()
    {
        return bbhlImg2;
    }

    public void setBbhlImg2(String bbhlImg2)
    {
        this.bbhlImg2 = bbhlImg2;
    }

    public String getBbhlImg3()
    {
        return bbhlImg3;
    }

    public void setBbhlImg3(String bbhlImg3)
    {
        this.bbhlImg3 = bbhlImg3;
    }

    public String getBbhlImg4()
    {
        return bbhlImg4;
    }

    public void setBbhlImg4(String bbhlImg4)
    {
        this.bbhlImg4 = bbhlImg4;
    }

    public String getBbhlImg5()
    {
        return bbhlImg5;
    }

    public void setBbhlImg5(String bbhlImg5)
    {
        this.bbhlImg5 = bbhlImg5;
    }

    public String getBbhlImg1Text1()
    {
        return bbhlImg1Text1;
    }

    public void setBbhlImg1Text1(String bbhlImg1Text1)
    {
        this.bbhlImg1Text1 = bbhlImg1Text1;
    }

    public String getBbhlImg1Text2()
    {
        return bbhlImg1Text2;
    }

    public void setBbhlImg1Text2(String bbhlImg1Text2)
    {
        this.bbhlImg1Text2 = bbhlImg1Text2;
    }

    public String getBbhlImg1Text3()
    {
        return bbhlImg1Text3;
    }

    public void setBbhlImg1Text3(String bbhlImg1Text3)
    {
        this.bbhlImg1Text3 = bbhlImg1Text3;
    }

    public String getBbhlImg2Text1()
    {
        return bbhlImg2Text1;
    }

    public void setBbhlImg2Text1(String bbhlImg2Text1)
    {
        this.bbhlImg2Text1 = bbhlImg2Text1;
    }

    public String getBbhlImg2Text2()
    {
        return bbhlImg2Text2;
    }

    public void setBbhlImg2Text2(String bbhlImg2Text2)
    {
        this.bbhlImg2Text2 = bbhlImg2Text2;
    }

    public String getBbhlImg2Text3()
    {
        return bbhlImg2Text3;
    }

    public void setBbhlImg2Text3(String bbhlImg2Text3)
    {
        this.bbhlImg2Text3 = bbhlImg2Text3;
    }

    public String getBbhlImg3Text1()
    {
        return bbhlImg3Text1;
    }

    public void setBbhlImg3Text1(String bbhlImg3Text1)
    {
        this.bbhlImg3Text1 = bbhlImg3Text1;
    }

    public String getBbhlImg3Text2()
    {
        return bbhlImg3Text2;
    }

    public void setBbhlImg3Text2(String bbhlImg3Text2)
    {
        this.bbhlImg3Text2 = bbhlImg3Text2;
    }

    public String getBbhlImg3Text3()
    {
        return bbhlImg3Text3;
    }

    public void setBbhlImg3Text3(String bbhlImg3Text3)
    {
        this.bbhlImg3Text3 = bbhlImg3Text3;
    }

    public String getBbhlImg4Text1()
    {
        return bbhlImg4Text1;
    }

    public void setBbhlImg4Text1(String bbhlImg4Text1)
    {
        this.bbhlImg4Text1 = bbhlImg4Text1;
    }

    public String getBbhlImg4Text2()
    {
        return bbhlImg4Text2;
    }

    public void setBbhlImg4Text2(String bbhlImg4Text2)
    {
        this.bbhlImg4Text2 = bbhlImg4Text2;
    }

    public String getBbhlImg4Text3()
    {
        return bbhlImg4Text3;
    }

    public void setBbhlImg4Text3(String bbhlImg4Text3)
    {
        this.bbhlImg4Text3 = bbhlImg4Text3;
    }

    public String getBbhlImg5Text1()
    {
        return bbhlImg5Text1;
    }

    public void setBbhlImg5Text1(String bbhlImg5Text1)
    {
        this.bbhlImg5Text1 = bbhlImg5Text1;
    }

    public String getBbhlImg5Text2()
    {
        return bbhlImg5Text2;
    }

    public void setBbhlImg5Text2(String bbhlImg5Text2)
    {
        this.bbhlImg5Text2 = bbhlImg5Text2;
    }

    public String getBbhlImg5Text3()
    {
        return bbhlImg5Text3;
    }

    public void setBbhlImg5Text3(String bbhlImg5Text3)
    {
        this.bbhlImg5Text3 = bbhlImg5Text3;
    }

}
