package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 优惠
 * 
 */
@Entity
@Table(name = "kuanrf_preference")
public class Preference extends BaseEntity
{

    private static final long serialVersionUID = 352950908275605509L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 关于我们图片1
     */
    @Column(name = "img", length = 50)
    private String img;
    
    /**
     * qq1
     */
    @Column(name = "qq1", length = 50)
    private String qq1;
    
    /**
     * qq2
     */
    @Column(name = "qq2", length = 50)
    private String qq2;
    
    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getQq1()
    {
        return qq1;
    }

    public void setQq1(String qq1)
    {
        this.qq1 = qq1;
    }

    public String getQq2()
    {
        return qq2;
    }

    public void setQq2(String qq2)
    {
        this.qq2 = qq2;
    }

}
