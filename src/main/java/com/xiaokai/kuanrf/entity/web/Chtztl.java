package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 产后体质调理
 * 
 */
@Entity
@Table(name = "kuanrf_chtztl")
public class Chtztl extends BaseEntity
{

    private static final long serialVersionUID = -8076931491029725932L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 描述
     */
    @Column(name = "text", columnDefinition = "text")
    private String text;
    
    /**
     * 图片
     */
    @Column(name = "img", length = 50)
    private String img;

    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

}
