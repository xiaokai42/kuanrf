package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 母婴照护
 * 
 */
@Entity
@Table(name = "kuanrf_myzh_img")
public class MyzhImg extends BaseEntity
{

    private static final long serialVersionUID = 6752317327424629223L;

    /**
     * banner大图id-母婴照护
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;

    /**
     * banner大图id-人才招聘
     */
    @Column(name = "banner_img1", length = 50)
    private String bannerImg1;

    /**
     * banner大图id-最新优惠
     */
    @Column(name = "banner_img2", length = 50)
    private String bannerImg2;

    /**
     * 孕期课堂-文本内容
     */
    @Column(name = "myzh_text", columnDefinition = "text")
    private String myzhText;
    
    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getMyzhText()
    {
        return myzhText;
    }

    public void setMyzhText(String myzhText)
    {
        this.myzhText = myzhText;
    }

}
