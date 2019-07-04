package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 关于我们
 * 
 */
@Entity
@Table(name = "kuanrf_about")
public class About extends BaseEntity
{

    private static final long serialVersionUID = 7012066219725658545L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 关于我们图片1
     */
    @Column(name = "about_img1", length = 50)
    private String aboutImg1;
    
    /**
     * 关于我们图片2
     */
    @Column(name = "about_img2", length = 50)
    private String aboutImg2;

    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getAboutImg1()
    {
        return aboutImg1;
    }

    public void setAboutImg1(String aboutImg1)
    {
        this.aboutImg1 = aboutImg1;
    }

    public String getAboutImg2()
    {
        return aboutImg2;
    }

    public void setAboutImg2(String aboutImg2)
    {
        this.aboutImg2 = aboutImg2;
    }

}
