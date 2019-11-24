package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 移动端web储存信息
 * 
 */
@Entity
@Table(name = "kuanrf_app_info")
public class AppInfo extends BaseEntity
{

    private static final long serialVersionUID = -7279564298371253175L;

    /**
     * 首页banner大图
     */
    @Column(name = "banner_img", length = 50)
    private String bannerImg;
    
    /**
     * 首页图片1
     */
    @Column(name = "home_img1", length = 50)
    private String homeImg1;
    
    /**
     * 首页图片1宽度
     */
    @Column(name = "home_img1_width", length = 50)
    private String homeImg1Width;
    
    /**
     * 首页图片1高度
     */
    @Column(name = "home_img1_height", length = 50)
    private String homeImg1Height;
    
    /**
     * 首页图片2
     */
    @Column(name = "home_img2", length = 50)
    private String homeImg2;
    
    /**
     * 首页图片2宽度
     */
    @Column(name = "home_img2_width", length = 50)
    private String homeImg2Width;
    
    /**
     * 首页图片2高度
     */
    @Column(name = "home_img2_height", length = 50)
    private String homeImg2Height;
    
    /**
     * 首页图片3
     */
    @Column(name = "home_img3", length = 50)
    private String homeImg3;
    
    /**
     * 首页图片3宽度
     */
    @Column(name = "home_img3_width", length = 50)
    private String homeImg3Width;
    
    /**
     * 首页图片3高度
     */
    @Column(name = "home_img3_height", length = 50)
    private String homeImg3Height;
    
    /**
     * 首页图片4
     */
    @Column(name = "home_img4", length = 50)
    private String homeImg4;
    
    /**
     * 首页图片4宽度
     */
    @Column(name = "home_img4_width", length = 50)
    private String homeImg4Width;
    
    /**
     * 首页图片4高度
     */
    @Column(name = "home_img4_height", length = 50)
    private String homeImg4Height;
    
    /**
     * 菜单页图片1
     */
    @Column(name = "menu_img1", length = 50)
    private String menuImg1;
    
    /**
     * 菜单页图片1宽度
     */
    @Column(name = "menu_img1_width", length = 50)
    private String menuImg1Width;
    
    /**
     * 菜单页图片1高度
     */
    @Column(name = "menu_img1_height", length = 50)
    private String menuImg1Height;
    
    /**
     * 菜单页图片2
     */
    @Column(name = "menu_img2", length = 50)
    private String menuImg2;
    
    /**
     * 菜单页图片2宽度
     */
    @Column(name = "menu_img2_width", length = 50)
    private String menuImg2Width;
    
    /**
     * 菜单页图片2高度
     */
    @Column(name = "menu_img2_height", length = 50)
    private String menuImg2Height;
    
    /**
     * 菜单页图片3
     */
    @Column(name = "menu_img3", length = 50)
    private String menuImg3;
    
    /**
     * 菜单页图片3宽度
     */
    @Column(name = "menu_img3_width", length = 50)
    private String menuImg3Width;
    
    /**
     * 菜单页图片3高度
     */
    @Column(name = "menu_img3_height", length = 50)
    private String menuImg3Height;
    
    /**
     * 活动页banner大图
     */
    @Column(name = "banner_img1", length = 50)
    private String bannerImg1;
    
    /**
     * 人才招聘banner大图
     */
    @Column(name = "banner_img2", length = 50)
    private String bannerImg2;

    public String getBannerImg()
    {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg)
    {
        this.bannerImg = bannerImg;
    }

    public String getHomeImg1()
    {
        return homeImg1;
    }

    public void setHomeImg1(String homeImg1)
    {
        this.homeImg1 = homeImg1;
    }

    public String getHomeImg1Width()
    {
        return homeImg1Width;
    }

    public void setHomeImg1Width(String homeImg1Width)
    {
        this.homeImg1Width = homeImg1Width;
    }

    public String getHomeImg1Height()
    {
        return homeImg1Height;
    }

    public void setHomeImg1Height(String homeImg1Height)
    {
        this.homeImg1Height = homeImg1Height;
    }

    public String getHomeImg2()
    {
        return homeImg2;
    }

    public void setHomeImg2(String homeImg2)
    {
        this.homeImg2 = homeImg2;
    }

    public String getHomeImg2Width()
    {
        return homeImg2Width;
    }

    public void setHomeImg2Width(String homeImg2Width)
    {
        this.homeImg2Width = homeImg2Width;
    }

    public String getHomeImg2Height()
    {
        return homeImg2Height;
    }

    public void setHomeImg2Height(String homeImg2Height)
    {
        this.homeImg2Height = homeImg2Height;
    }

    public String getHomeImg3()
    {
        return homeImg3;
    }

    public void setHomeImg3(String homeImg3)
    {
        this.homeImg3 = homeImg3;
    }

    public String getHomeImg3Width()
    {
        return homeImg3Width;
    }

    public void setHomeImg3Width(String homeImg3Width)
    {
        this.homeImg3Width = homeImg3Width;
    }

    public String getHomeImg3Height()
    {
        return homeImg3Height;
    }

    public void setHomeImg3Height(String homeImg3Height)
    {
        this.homeImg3Height = homeImg3Height;
    }

    public String getHomeImg4()
    {
        return homeImg4;
    }

    public void setHomeImg4(String homeImg4)
    {
        this.homeImg4 = homeImg4;
    }

    public String getHomeImg4Width()
    {
        return homeImg4Width;
    }

    public void setHomeImg4Width(String homeImg4Width)
    {
        this.homeImg4Width = homeImg4Width;
    }

    public String getHomeImg4Height()
    {
        return homeImg4Height;
    }

    public void setHomeImg4Height(String homeImg4Height)
    {
        this.homeImg4Height = homeImg4Height;
    }

    public String getMenuImg1()
    {
        return menuImg1;
    }

    public void setMenuImg1(String menuImg1)
    {
        this.menuImg1 = menuImg1;
    }

    public String getMenuImg1Width()
    {
        return menuImg1Width;
    }

    public void setMenuImg1Width(String menuImg1Width)
    {
        this.menuImg1Width = menuImg1Width;
    }

    public String getMenuImg1Height()
    {
        return menuImg1Height;
    }

    public void setMenuImg1Height(String menuImg1Height)
    {
        this.menuImg1Height = menuImg1Height;
    }

    public String getMenuImg2()
    {
        return menuImg2;
    }

    public void setMenuImg2(String menuImg2)
    {
        this.menuImg2 = menuImg2;
    }

    public String getMenuImg2Width()
    {
        return menuImg2Width;
    }

    public void setMenuImg2Width(String menuImg2Width)
    {
        this.menuImg2Width = menuImg2Width;
    }

    public String getMenuImg2Height()
    {
        return menuImg2Height;
    }

    public void setMenuImg2Height(String menuImg2Height)
    {
        this.menuImg2Height = menuImg2Height;
    }

    public String getMenuImg3()
    {
        return menuImg3;
    }

    public void setMenuImg3(String menuImg3)
    {
        this.menuImg3 = menuImg3;
    }

    public String getMenuImg3Width()
    {
        return menuImg3Width;
    }

    public void setMenuImg3Width(String menuImg3Width)
    {
        this.menuImg3Width = menuImg3Width;
    }

    public String getMenuImg3Height()
    {
        return menuImg3Height;
    }

    public void setMenuImg3Height(String menuImg3Height)
    {
        this.menuImg3Height = menuImg3Height;
    }

    public String getBannerImg1()
    {
        return bannerImg1;
    }

    public void setBannerImg1(String bannerImg1)
    {
        this.bannerImg1 = bannerImg1;
    }

    public String getBannerImg2()
    {
        return bannerImg2;
    }

    public void setBannerImg2(String bannerImg2)
    {
        this.bannerImg2 = bannerImg2;
    }

}
