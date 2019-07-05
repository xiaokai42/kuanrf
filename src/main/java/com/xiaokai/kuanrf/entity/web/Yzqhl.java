package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 月子期护理
 * 
 */
@Entity
@Table(name = "kuanrf_yzqhl")
public class Yzqhl extends BaseEntity
{

    private static final long serialVersionUID = -1260378640489695098L;
    
    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 图片1
     */
    @Column(name = "yzqhl_img1", length = 50)
    private String yzqhlImg1;
    
    /**
     * 图片2
     */
    @Column(name = "yzqhl_img2", length = 50)
    private String yzqhlImg2;
    
    /**
     * 图片3
     */
    @Column(name = "yzqhl_img3", length = 50)
    private String yzqhlImg3;
    
    /**
     * 图片4
     */
    @Column(name = "yzqhl_img4", length = 50)
    private String yzqhlImg4;
    
    /**
     * 图片5
     */
    @Column(name = "yzqhl_img5", length = 50)
    private String yzqhlImg5;
    
    /**
     * 图片6
     */
    @Column(name = "yzqhl_img6", length = 50)
    private String yzqhlImg6;
    
    /**
     * 图片7
     */
    @Column(name = "yzqhl_img7", length = 50)
    private String yzqhlImg7;
    
    /**
     * 标题1
     */
    @Column(name = "yzqhl_title1", length = 100)
    private String yzqhlTitle1;
    
    /**
     * 标题2
     */
    @Column(name = "yzqhl_title2", length = 100)
    private String yzqhlTitle2;
    
    /**
     * 标题3
     */
    @Column(name = "yzqhl_title3", length = 100)
    private String yzqhlTitle3;
    
    /**
     * 标题4
     */
    @Column(name = "yzqhl_title4", length = 100)
    private String yzqhlTitle4;
    
    /**
     * 标题5
     */
    @Column(name = "yzqhl_title5", length = 100)
    private String yzqhlTitle5;
    
    /**
     * 标题6
     */
    @Column(name = "yzqhl_title6", length = 100)
    private String yzqhlTitle6;
    
    /**
     * 标题7
     */
    @Column(name = "yzqhl_title7", length = 100)
    private String yzqhlTitle7;

    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getYzqhlImg1()
    {
        return yzqhlImg1;
    }

    public void setYzqhlImg1(String yzqhlImg1)
    {
        this.yzqhlImg1 = yzqhlImg1;
    }

    public String getYzqhlImg2()
    {
        return yzqhlImg2;
    }

    public void setYzqhlImg2(String yzqhlImg2)
    {
        this.yzqhlImg2 = yzqhlImg2;
    }

    public String getYzqhlImg3()
    {
        return yzqhlImg3;
    }

    public void setYzqhlImg3(String yzqhlImg3)
    {
        this.yzqhlImg3 = yzqhlImg3;
    }

    public String getYzqhlImg4()
    {
        return yzqhlImg4;
    }

    public void setYzqhlImg4(String yzqhlImg4)
    {
        this.yzqhlImg4 = yzqhlImg4;
    }

    public String getYzqhlImg5()
    {
        return yzqhlImg5;
    }

    public void setYzqhlImg5(String yzqhlImg5)
    {
        this.yzqhlImg5 = yzqhlImg5;
    }

    public String getYzqhlImg6()
    {
        return yzqhlImg6;
    }

    public void setYzqhlImg6(String yzqhlImg6)
    {
        this.yzqhlImg6 = yzqhlImg6;
    }

    public String getYzqhlImg7()
    {
        return yzqhlImg7;
    }

    public void setYzqhlImg7(String yzqhlImg7)
    {
        this.yzqhlImg7 = yzqhlImg7;
    }

    public String getYzqhlTitle1()
    {
        return yzqhlTitle1;
    }

    public void setYzqhlTitle1(String yzqhlTitle1)
    {
        this.yzqhlTitle1 = yzqhlTitle1;
    }

    public String getYzqhlTitle2()
    {
        return yzqhlTitle2;
    }

    public void setYzqhlTitle2(String yzqhlTitle2)
    {
        this.yzqhlTitle2 = yzqhlTitle2;
    }

    public String getYzqhlTitle3()
    {
        return yzqhlTitle3;
    }

    public void setYzqhlTitle3(String yzqhlTitle3)
    {
        this.yzqhlTitle3 = yzqhlTitle3;
    }

    public String getYzqhlTitle4()
    {
        return yzqhlTitle4;
    }

    public void setYzqhlTitle4(String yzqhlTitle4)
    {
        this.yzqhlTitle4 = yzqhlTitle4;
    }

    public String getYzqhlTitle5()
    {
        return yzqhlTitle5;
    }

    public void setYzqhlTitle5(String yzqhlTitle5)
    {
        this.yzqhlTitle5 = yzqhlTitle5;
    }

    public String getYzqhlTitle6()
    {
        return yzqhlTitle6;
    }

    public void setYzqhlTitle6(String yzqhlTitle6)
    {
        this.yzqhlTitle6 = yzqhlTitle6;
    }

    public String getYzqhlTitle7()
    {
        return yzqhlTitle7;
    }

    public void setYzqhlTitle7(String yzqhlTitle7)
    {
        this.yzqhlTitle7 = yzqhlTitle7;
    }

}
