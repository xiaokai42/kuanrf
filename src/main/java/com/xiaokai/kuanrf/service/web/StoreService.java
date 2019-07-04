package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Store;

/**
 * 门店信息
 * @author xiaokai
 * 2019年6月29日
 */
public interface StoreService
{
    /**
     * 查询门店信息
     * @author xiaokai
     * 2019年6月29日
     */
    Store findStoreInfo();
    
    /**
     * 保存门店信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int save(Map<String, Object> obj);

}
