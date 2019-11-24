package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.AppInfo;

/**
 * 移动端信息
 * @author xiaokai
 * 2019年6月29日
 */
public interface AppInfoService
{
    /**
     * 查询移动端信息
     * @author xiaokai
     * 2019年6月29日
     */
    AppInfo findAppInfo();
    
    /**
     * 保存移动端信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int save(Map<String, Object> obj);

}
