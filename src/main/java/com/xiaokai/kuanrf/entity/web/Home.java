package com.xiaokai.kuanrf.entity.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xiaokai.kuanrf.entity.BaseEntity;

/**
 * 首页信息存贮
 */
@Entity
@Table(name = "kuanrf_home")
public class Home extends BaseEntity
{

    private static final long serialVersionUID = -4354330479585434084L;

    /**
     * 首页大图id1
     */
    @Column(name = "banner_img1", length = 50)
    private String bannerImg1;

    /**
     * 首页大图id2
     */
    @Column(name = "banner_img2", length = 50)
    private String bannerImg2;

    /**
     * 首页大图id3
     */
    @Column(name = "banner_img3", length = 50)
    private String bannerImg3;

    /**
     * 首页大图id4
     */
    @Column(name = "banner_img4", length = 50)
    private String bannerImg4;
    
    /**
     * 品牌优势-图片1
     */
    @Column(name = "advantage_img1", length = 50)
    private String advantageImg1;
    
    /**
     * 品牌优势-文字描述1
     */
    @Column(name = "advantage_text1")
    private String advantageText1;

    /**
     * 品牌优势-图片2
     */
    @Column(name = "advantage_img2", length = 50)
    private String advantageImg2;
    
    /**
     * 品牌优势-文字描述2
     */
    @Column(name = "advantage_text2")
    private String advantageText2;

    /**
     * 品牌优势-图片3
     */
    @Column(name = "advantage_img3", length = 50)
    private String advantageImg3;
    
    /**
     * 品牌优势-文字描述1
     */
    @Column(name = "advantage_text3")
    private String advantageText3;

    /**
     * 品牌优势-图片4
     */
    @Column(name = "advantage_img4", length = 50)
    private String advantageImg4;
    
    /**
     * 品牌优势-文字描述4
     */
    @Column(name = "advantage_text4")
    private String advantageText4;

    /**
     * 品牌优势-图片5
     */
    @Column(name = "advantage_img5", length = 50)
    private String advantageImg5;
    
    /**
     * 品牌优势-文字描述1
     */
    @Column(name = "advantage_text5")
    private String advantageText5;
    
    /**
     * 探索门店-图片id1
     */
    @Column(name = "store_img1", length = 50)
    private String storeImg1;
    
    /**
     * 探索门店-图片id2
     */
    @Column(name = "store_img2", length = 50)
    private String storeImg2;
    
    /**
     * 服务项目-图片id1
     */
    @Column(name = "server_img1", length = 50)
    private String serverImg1;
    
    /**
     * 服务项目-图标id1
     */
    @Column(name = "server_icon1", length = 50)
    private String serverIcon1;
    
    /**
     * 服务项目-标题1
     */
    @Column(name = "server_title1", length = 100)
    private String serverTitle1;
    
    /**
     * 服务项目-描述1
     */
    @Column(name = "server_text1")
    private String serverText1;

    /**
     * 服务项目-图片id2
     */
    @Column(name = "server_img2", length = 50)
    private String serverImg2;
    
    /**
     * 服务项目-图标id2
     */
    @Column(name = "server_icon2", length = 50)
    private String serverIcon2;
    
    /**
     * 服务项目-标题2
     */
    @Column(name = "server_title2", length = 100)
    private String serverTitle2;
    
    /**
     * 服务项目-描述2
     */
    @Column(name = "server_text2")
    private String serverText2;

    /**
     * 服务项目-图片id3
     */
    @Column(name = "server_img3", length = 50)
    private String serverImg3;
    
    /**
     * 服务项目-图标id3
     */
    @Column(name = "server_icon3", length = 50)
    private String serverIcon3;
    
    /**
     * 服务项目-标题3
     */
    @Column(name = "server_title3", length = 100)
    private String serverTitle3;
    
    /**
     * 服务项目-描述3
     */
    @Column(name = "server_text3")
    private String serverText3;

    /**
     * 服务项目-图片id4
     */
    @Column(name = "server_img4", length = 50)
    private String serverImg4;
    
    /**
     * 服务项目-图标id4
     */
    @Column(name = "server_icon4", length = 50)
    private String serverIcon4;
    
    /**
     * 服务项目-标题4
     */
    @Column(name = "server_title4", length = 100)
    private String serverTitle4;
    
    /**
     * 服务项目-描述4
     */
    @Column(name = "server_text4")
    private String serverText4;
    
    /**
     * 发现更多-图片id1
     */
    @Column(name = "more_img1", length = 50)
    private String moreImg1;
    
    /**
     * 发现更多-描述1
     */
    @Column(name = "more_text1", length = 50)
    private String moreText1;

    /**
     * 发现更多-图片id2
     */
    @Column(name = "more_img2", length = 50)
    private String moreImg2;
    
    /**
     * 发现更多-描述2
     */
    @Column(name = "more_text2", length = 50)
    private String moreText2;

    /**
     * 发现更多-图片id3
     */
    @Column(name = "more_img3", length = 50)
    private String moreImg3;
    
    /**
     * 发现更多-描述3
     */
    @Column(name = "more_text3", length = 50)
    private String moreText3;
    
    /**
     * 实体店名称1
     */
    @Column(name = "store_name1", length = 100)
    private String storeName1;
    
    /**
     * 地址1
     */
    @Column(name = "addresss1", length = 100)
    private String addresss1;
    
    /**
     * 联系电话1
     */
    @Column(name = "phone1", length = 50)
    private String phone1;

    /**
     * 实体店名称2
     */
    @Column(name = "store_name2", length = 100)
    private String storeName2;
    
    /**
     * 地址2
     */
    @Column(name = "addresss2", length = 100)
    private String addresss2;
    
    /**
     * 联系电话2
     */
    @Column(name = "phone2", length = 50)
    private String phone2;
    
    /**
     * 二维码图片id
     */
    @Column(name = "two_bar_codes", length = 50)
    private String twoBarCodes;

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

    public String getBannerImg3()
    {
        return bannerImg3;
    }

    public void setBannerImg3(String bannerImg3)
    {
        this.bannerImg3 = bannerImg3;
    }

    public String getBannerImg4()
    {
        return bannerImg4;
    }

    public void setBannerImg4(String bannerImg4)
    {
        this.bannerImg4 = bannerImg4;
    }

    public String getAdvantageImg1()
    {
        return advantageImg1;
    }

    public void setAdvantageImg1(String advantageImg1)
    {
        this.advantageImg1 = advantageImg1;
    }

    public String getAdvantageText1()
    {
        return advantageText1;
    }

    public void setAdvantageText1(String advantageText1)
    {
        this.advantageText1 = advantageText1;
    }

    public String getAdvantageImg2()
    {
        return advantageImg2;
    }

    public void setAdvantageImg2(String advantageImg2)
    {
        this.advantageImg2 = advantageImg2;
    }

    public String getAdvantageText2()
    {
        return advantageText2;
    }

    public void setAdvantageText2(String advantageText2)
    {
        this.advantageText2 = advantageText2;
    }

    public String getAdvantageImg3()
    {
        return advantageImg3;
    }

    public void setAdvantageImg3(String advantageImg3)
    {
        this.advantageImg3 = advantageImg3;
    }

    public String getAdvantageText3()
    {
        return advantageText3;
    }

    public void setAdvantageText3(String advantageText3)
    {
        this.advantageText3 = advantageText3;
    }

    public String getAdvantageImg4()
    {
        return advantageImg4;
    }

    public void setAdvantageImg4(String advantageImg4)
    {
        this.advantageImg4 = advantageImg4;
    }

    public String getAdvantageText4()
    {
        return advantageText4;
    }

    public void setAdvantageText4(String advantageText4)
    {
        this.advantageText4 = advantageText4;
    }

    public String getAdvantageImg5()
    {
        return advantageImg5;
    }

    public void setAdvantageImg5(String advantageImg5)
    {
        this.advantageImg5 = advantageImg5;
    }

    public String getAdvantageText5()
    {
        return advantageText5;
    }

    public void setAdvantageText5(String advantageText5)
    {
        this.advantageText5 = advantageText5;
    }

    public String getStoreImg1()
    {
        return storeImg1;
    }

    public void setStoreImg1(String storeImg1)
    {
        this.storeImg1 = storeImg1;
    }

    public String getStoreImg2()
    {
        return storeImg2;
    }

    public void setStoreImg2(String storeImg2)
    {
        this.storeImg2 = storeImg2;
    }

    public String getServerImg1()
    {
        return serverImg1;
    }

    public void setServerImg1(String serverImg1)
    {
        this.serverImg1 = serverImg1;
    }

    public String getServerIcon1()
    {
        return serverIcon1;
    }

    public void setServerIcon1(String serverIcon1)
    {
        this.serverIcon1 = serverIcon1;
    }

    public String getServerTitle1()
    {
        return serverTitle1;
    }

    public void setServerTitle1(String serverTitle1)
    {
        this.serverTitle1 = serverTitle1;
    }

    public String getServerText1()
    {
        return serverText1;
    }

    public void setServerText1(String serverText1)
    {
        this.serverText1 = serverText1;
    }

    public String getServerImg2()
    {
        return serverImg2;
    }

    public void setServerImg2(String serverImg2)
    {
        this.serverImg2 = serverImg2;
    }

    public String getServerIcon2()
    {
        return serverIcon2;
    }

    public void setServerIcon2(String serverIcon2)
    {
        this.serverIcon2 = serverIcon2;
    }

    public String getServerTitle2()
    {
        return serverTitle2;
    }

    public void setServerTitle2(String serverTitle2)
    {
        this.serverTitle2 = serverTitle2;
    }

    public String getServerText2()
    {
        return serverText2;
    }

    public void setServerText2(String serverText2)
    {
        this.serverText2 = serverText2;
    }

    public String getServerImg3()
    {
        return serverImg3;
    }

    public void setServerImg3(String serverImg3)
    {
        this.serverImg3 = serverImg3;
    }

    public String getServerIcon3()
    {
        return serverIcon3;
    }

    public void setServerIcon3(String serverIcon3)
    {
        this.serverIcon3 = serverIcon3;
    }

    public String getServerTitle3()
    {
        return serverTitle3;
    }

    public void setServerTitle3(String serverTitle3)
    {
        this.serverTitle3 = serverTitle3;
    }

    public String getServerText3()
    {
        return serverText3;
    }

    public void setServerText3(String serverText3)
    {
        this.serverText3 = serverText3;
    }

    public String getServerImg4()
    {
        return serverImg4;
    }

    public void setServerImg4(String serverImg4)
    {
        this.serverImg4 = serverImg4;
    }

    public String getServerIcon4()
    {
        return serverIcon4;
    }

    public void setServerIcon4(String serverIcon4)
    {
        this.serverIcon4 = serverIcon4;
    }

    public String getServerTitle4()
    {
        return serverTitle4;
    }

    public void setServerTitle4(String serverTitle4)
    {
        this.serverTitle4 = serverTitle4;
    }

    public String getServerText4()
    {
        return serverText4;
    }

    public void setServerText4(String serverText4)
    {
        this.serverText4 = serverText4;
    }

    public String getMoreImg1()
    {
        return moreImg1;
    }

    public void setMoreImg1(String moreImg1)
    {
        this.moreImg1 = moreImg1;
    }

    public String getMoreText1()
    {
        return moreText1;
    }

    public void setMoreText1(String moreText1)
    {
        this.moreText1 = moreText1;
    }

    public String getMoreImg2()
    {
        return moreImg2;
    }

    public void setMoreImg2(String moreImg2)
    {
        this.moreImg2 = moreImg2;
    }

    public String getMoreText2()
    {
        return moreText2;
    }

    public void setMoreText2(String moreText2)
    {
        this.moreText2 = moreText2;
    }

    public String getMoreImg3()
    {
        return moreImg3;
    }

    public void setMoreImg3(String moreImg3)
    {
        this.moreImg3 = moreImg3;
    }

    public String getMoreText3()
    {
        return moreText3;
    }

    public void setMoreText3(String moreText3)
    {
        this.moreText3 = moreText3;
    }

    public String getStoreName1()
    {
        return storeName1;
    }

    public void setStoreName1(String storeName1)
    {
        this.storeName1 = storeName1;
    }

    public String getAddresss1()
    {
        return addresss1;
    }

    public void setAddresss1(String addresss1)
    {
        this.addresss1 = addresss1;
    }

    public String getPhone1()
    {
        return phone1;
    }

    public void setPhone1(String phone1)
    {
        this.phone1 = phone1;
    }

    public String getStoreName2()
    {
        return storeName2;
    }

    public void setStoreName2(String storeName2)
    {
        this.storeName2 = storeName2;
    }

    public String getAddresss2()
    {
        return addresss2;
    }

    public void setAddresss2(String addresss2)
    {
        this.addresss2 = addresss2;
    }

    public String getPhone2()
    {
        return phone2;
    }

    public void setPhone2(String phone2)
    {
        this.phone2 = phone2;
    }

    public String getTwoBarCodes()
    {
        return twoBarCodes;
    }

    public void setTwoBarCodes(String twoBarCodes)
    {
        this.twoBarCodes = twoBarCodes;
    }
    
}
