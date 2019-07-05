package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Bbhl;
import com.xiaokai.kuanrf.entity.web.Crqxtzd;
import com.xiaokai.kuanrf.entity.web.Yyss;
import com.xiaokai.kuanrf.entity.web.Yzqhl;

/**
 * 母婴照护
 * @author xiaokai
 * 2019年6月29日
 */
public interface MyzhService
{
    /**
     * 查询月子期护理信息
     * @author xiaokai
     * 2019年6月29日
     */
    Yzqhl findYzqhlInfo();
    
    /**
     * 保存月子期护理信息
     * @author xiaokai
     * 2019年6月29日
     */
    int saveYzqhl(Map<String, Object> obj);
    
    /**
     * 查询产褥期形体指导信息
     * @author xiaokai
     * 2019年6月29日
     */
    Crqxtzd findCrqxtzdInfo();
    
    /**
     * 保存产褥期形体指导信息
     * @author xiaokai
     * 2019年6月29日
     */
    int saveCrqxtzd(Map<String, Object> obj);
    
    /**
     * 查询营养膳食信息
     * @author xiaokai
     * 2019年6月29日
     */
    Yyss findYyssInfo();
    
    /**
     * 保存产营养膳食信息
     * @author xiaokai
     * 2019年6月29日
     */
    int saveYyss(Map<String, Object> obj);
    
    /**
     * 查询宝宝护理信息
     * @author xiaokai
     * 2019年6月29日
     */
    Bbhl findBbhlInfo();
    
    /**
     * 保存宝宝护理信息
     * @author xiaokai
     * 2019年6月29日
     */
    int saveBbhl(Map<String, Object> obj);

}
