package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Advantage;

/**
 * 品牌介绍信息
 * @author xiaokai
 * 2019年6月29日
 */
public interface AdvantageService
{
    /**
     * 查询品牌介绍信息
     * @author xiaokai
     * 2019年6月29日
     */
    Advantage findAdvantageInfo();
    
    /**
     * 保存品牌介绍信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int save(Map<String, Object> obj);

}
