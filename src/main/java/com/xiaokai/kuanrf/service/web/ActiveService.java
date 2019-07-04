package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Active;
import com.xiaokai.kuanrf.entity.web.ActiveImg;

import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;

public interface ActiveService
{

    /**
     * 分页查询
     * @param query
     * @return
     */
    DataGrid<Active> list(DataGridQuery query);
    
    /**
     * 根据id查询活动信息
     * @author xiaokai
     * 2019年4月8日
     */
    Active findbyId(String id);
    
    /**
     * 新增或修改 
     * @author xiaokai
     * 2019年4月4日
     */
    int edit(Map<String, Object> obj);
    
    /**
     * 查询活动页大图
     * @author xiaokai
     * 2019年7月1日
     */
    ActiveImg findActiveImgInfo();
    
    /**
     * 新增或修改活动页大图
     * @author xiaokai
     * 2019年7月1日
     */
    int saveImg(Map<String, Object> obj);
    
    /**
     * 查询活动信息
     * @author xiaokai
     * 2019年7月1日
     */
    Map<String, Object> findActiveInfo();
}
