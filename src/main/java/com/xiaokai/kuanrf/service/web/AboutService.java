package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.About;

/**
 * 关于我们信息
 * @author xiaokai
 * 2019年6月29日
 */
public interface AboutService
{
    /**
     * 查询关于我们信息
     * @author xiaokai
     * 2019年6月29日
     */
    About findAboutInfo();
    
    /**
     * 保存关于我们信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int save(Map<String, Object> obj);

}
