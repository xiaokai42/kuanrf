package com.xiaokai.kuanrf.service.web;

import java.util.Map;

import com.xiaokai.kuanrf.entity.web.MyzhImg;
import com.xiaokai.kuanrf.entity.web.Yqkt;

import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;

public interface YqktService
{

    /**
     * 分页查询
     * @param query
     * @return
     */
    DataGrid<Yqkt> list(DataGridQuery query);
    
    /**
     * 根据id查询孕期课堂信息
     * @author xiaokai
     * 2019年4月8日
     */
    Yqkt findbyId(String id);
    
    /**
     * 新增或修改 
     * @author xiaokai
     * 2019年4月4日
     */
    int edit(Map<String, Object> obj);
    
    /**
     * 查询母婴照护大图
     * @author xiaokai
     * 2019年7月1日
     */
    MyzhImg findMyzhImgInfo();
    
    /**
     * 新增或修改母婴照护大图
     * @author xiaokai
     * 2019年7月1日
     */
    int saveImg(Map<String, Object> obj);
}
