package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 品牌介绍
 * 
 */
@Entity
@Table(name = "kuanrf_advantage")
public class Advantage extends BaseEntity
{

    private static final long serialVersionUID = 8839634490938660842L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 描述
     */
    @Column(name = "about_text", length = 500)
    private String aboutText;

    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getAboutText()
    {
        return aboutText;
    }

    public void setAboutText(String aboutText)
    {
        this.aboutText = aboutText;
    }

}
