package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Home;
import com.xiaokai.kuanrf.entity.web.Preference;

/**
 * 首页信息
 * @author xiaokai
 * 2019年6月29日
 */
public interface HomeService
{
    /**
     * 查询首页信息
     * @author xiaokai
     * 2019年6月29日
     */
    Home findHomeInfo();
    
    /**
     * 保存首页信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int save(Map<String, Object> obj);
    /**
     * 查询优惠信息
     * @author xiaokai
     * 2019年6月29日
     */
    Preference findPreferenceInfo();
    
    /**
     * 保存优惠信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int savePreference(Map<String, Object> obj);

}
