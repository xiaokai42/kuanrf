package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 门店信息
 * 
 */
@Entity
@Table(name = "kuanrf_store")
public class Store extends BaseEntity
{

    private static final long serialVersionUID = -4264059834709547885L;

    /**
     * banner大图id
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 门店信息-解放碑店-文字描述
     */
    @Column(name = "jfb_text1", length = 500)
    private String jfbText;

    /**
     * 门店信息-解放碑店-图片
     */
    @Column(name = "jfb_img", length = 50)
    private String jfbImg;

    /**
     * 门店信息-解放碑店-地图
     */
    @Column(name = "jfb_map", length = 50)
    private String jfbMap;
    
    /**
     * 门店信息-沙坪坝店-文字描述
     */
    @Column(name = "spb_text1", length = 500)
    private String spbText;

    /**
     * 门店信息-沙坪坝店-图片
     */
    @Column(name = "spb_img", length = 50)
    private String spbImg;

    /**
     * 门店信息-沙坪坝店-地图
     */
    @Column(name = "spb_map", length = 50)
    private String spbMap;

    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getJfbText()
    {
        return jfbText;
    }

    public void setJfbText(String jfbText)
    {
        this.jfbText = jfbText;
    }

    public String getJfbImg()
    {
        return jfbImg;
    }

    public void setJfbImg(String jfbImg)
    {
        this.jfbImg = jfbImg;
    }

    public String getJfbMap()
    {
        return jfbMap;
    }

    public void setJfbMap(String jfbMap)
    {
        this.jfbMap = jfbMap;
    }

    public String getSpbText()
    {
        return spbText;
    }

    public void setSpbText(String spbText)
    {
        this.spbText = spbText;
    }

    public String getSpbImg()
    {
        return spbImg;
    }

    public void setSpbImg(String spbImg)
    {
        this.spbImg = spbImg;
    }

    public String getSpbMap()
    {
        return spbMap;
    }

    public void setSpbMap(String spbMap)
    {
        this.spbMap = spbMap;
    }

}
