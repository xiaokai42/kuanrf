package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 产后体形重塑
 * 
 */
@Entity
@Table(name = "kuanrf_chtxcs")
public class Chtxcs extends BaseEntity
{

    private static final long serialVersionUID = -4327852171461158106L;
    
    /**
     * 主要描述
     */
    @Column(name = "main_text", columnDefinition = "text")
    private String mainText;
    
    /**
     * 图片1
     */
    @Column(name = "chtxcs_img1", length = 50)
    private String chtxcsImg1;
    
    /**
     * 图片2
     */
    @Column(name = "chtxcs_img2", length = 50)
    private String chtxcsImg2;
    
    /**
     * 标题1
     */
    @Column(name = "chtxcs_title1", length = 50)
    private String chtxcsTitle1;
    
    /**
     * 标题2
     */
    @Column(name = "chtxcs_title2", length = 50)
    private String chtxcsTitle2;

    /**
     * 描述1
     */
    @Column(name = "chtxcs_text1", columnDefinition = "text")
    private String chtxcsText1;

    /**
     * 描述2
     */
    @Column(name = "chtxcs_text2", columnDefinition = "text")
    private String chtxcsText2;

    public String getMainText()
    {
        return mainText;
    }

    public void setMainText(String mainText)
    {
        this.mainText = mainText;
    }

    public String getChtxcsImg1()
    {
        return chtxcsImg1;
    }

    public void setChtxcsImg1(String chtxcsImg1)
    {
        this.chtxcsImg1 = chtxcsImg1;
    }

    public String getChtxcsImg2()
    {
        return chtxcsImg2;
    }

    public void setChtxcsImg2(String chtxcsImg2)
    {
        this.chtxcsImg2 = chtxcsImg2;
    }

    public String getChtxcsTitle1()
    {
        return chtxcsTitle1;
    }

    public void setChtxcsTitle1(String chtxcsTitle1)
    {
        this.chtxcsTitle1 = chtxcsTitle1;
    }

    public String getChtxcsTitle2()
    {
        return chtxcsTitle2;
    }

    public void setChtxcsTitle2(String chtxcsTitle2)
    {
        this.chtxcsTitle2 = chtxcsTitle2;
    }

    public String getChtxcsText1()
    {
        return chtxcsText1;
    }

    public void setChtxcsText1(String chtxcsText1)
    {
        this.chtxcsText1 = chtxcsText1;
    }

    public String getChtxcsText2()
    {
        return chtxcsText2;
    }

    public void setChtxcsText2(String chtxcsText2)
    {
        this.chtxcsText2 = chtxcsText2;
    }

}
