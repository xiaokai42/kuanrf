package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 营养膳食
 * 
 */
@Entity
@Table(name = "kuanrf_yyss")
public class Yyss extends BaseEntity
{

    private static final long serialVersionUID = 1575048870860369799L;

    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 轮播图片1
     */
    @Column(name = "slide_img1", length = 50)
    private String slideImg1;
    
    /**
     * 轮播图片2
     */
    @Column(name = "slide_img2", length = 50)
    private String slideImg2;
    
    /**
     * 轮播图片3
     */
    @Column(name = "slide_img3", length = 50)
    private String slideImg3;
    
    /**
     * 轮播图片4
     */
    @Column(name = "slide_img4", length = 50)
    private String slideImg4;
    
    /**
     * 轮播图片5
     */
    @Column(name = "slide_img5", length = 50)
    private String slideImg5;
    
    /**
     * icon
     */
    @Column(name = "yyss_icon", length = 50)
    private String yyssIcon;
    
    /**
     * 标题1
     */
    @Column(name = "yyss_title1", length = 50)
    private String yyssTitle1;
    
    /**
     * 标题2
     */
    @Column(name = "yyss_title2", length = 50)
    private String yyssTitle2;
    
    /**
     * 标题3
     */
    @Column(name = "yyss_title3", length = 50)
    private String yyssTitle3;
    
    /**
     * 标题4
     */
    @Column(name = "yyss_title4", length = 50)
    private String yyssTitle4;
    
    /**
     * 描述1
     */
    @Column(name = "yyss_text1", length = 255)
    private String yyssText1;
    
    /**
     * 描述2
     */
    @Column(name = "yyss_text2", length = 255)
    private String yyssText2;
    
    /**
     * 描述3
     */
    @Column(name = "yyss_text3", length = 255)
    private String yyssText3;
    
    /**
     * 描述4
     */
    @Column(name = "yyss_text4", length = 255)
    private String yyssText4;

    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getSlideImg1()
    {
        return slideImg1;
    }

    public void setSlideImg1(String slideImg1)
    {
        this.slideImg1 = slideImg1;
    }

    public String getSlideImg2()
    {
        return slideImg2;
    }

    public void setSlideImg2(String slideImg2)
    {
        this.slideImg2 = slideImg2;
    }

    public String getSlideImg3()
    {
        return slideImg3;
    }

    public void setSlideImg3(String slideImg3)
    {
        this.slideImg3 = slideImg3;
    }

    public String getSlideImg4()
    {
        return slideImg4;
    }

    public void setSlideImg4(String slideImg4)
    {
        this.slideImg4 = slideImg4;
    }

    public String getSlideImg5()
    {
        return slideImg5;
    }

    public void setSlideImg5(String slideImg5)
    {
        this.slideImg5 = slideImg5;
    }

    public String getYyssIcon()
    {
        return yyssIcon;
    }

    public void setYyssIcon(String yyssIcon)
    {
        this.yyssIcon = yyssIcon;
    }

    public String getYyssTitle1()
    {
        return yyssTitle1;
    }

    public void setYyssTitle1(String yyssTitle1)
    {
        this.yyssTitle1 = yyssTitle1;
    }

    public String getYyssTitle2()
    {
        return yyssTitle2;
    }

    public void setYyssTitle2(String yyssTitle2)
    {
        this.yyssTitle2 = yyssTitle2;
    }

    public String getYyssTitle3()
    {
        return yyssTitle3;
    }

    public void setYyssTitle3(String yyssTitle3)
    {
        this.yyssTitle3 = yyssTitle3;
    }

    public String getYyssTitle4()
    {
        return yyssTitle4;
    }

    public void setYyssTitle4(String yyssTitle4)
    {
        this.yyssTitle4 = yyssTitle4;
    }

    public String getYyssText1()
    {
        return yyssText1;
    }

    public void setYyssText1(String yyssText1)
    {
        this.yyssText1 = yyssText1;
    }

    public String getYyssText2()
    {
        return yyssText2;
    }

    public void setYyssText2(String yyssText2)
    {
        this.yyssText2 = yyssText2;
    }

    public String getYyssText3()
    {
        return yyssText3;
    }

    public void setYyssText3(String yyssText3)
    {
        this.yyssText3 = yyssText3;
    }

    public String getYyssText4()
    {
        return yyssText4;
    }

    public void setYyssText4(String yyssText4)
    {
        this.yyssText4 = yyssText4;
    }
    
}
