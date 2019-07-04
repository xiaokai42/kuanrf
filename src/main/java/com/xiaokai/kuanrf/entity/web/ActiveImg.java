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
@Table(name = "kuanrf_active_img")
public class ActiveImg extends BaseEntity
{

    private static final long serialVersionUID = 7012066219725658545L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

}
