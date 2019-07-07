package com.xiaokai.kuanrf.service.web;

import java.util.List;
import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Recruit;

import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;

public interface RecruitService
{

    /**
     * 分页查询
     * @param query
     * @return
     */
    DataGrid<Recruit> list(DataGridQuery query);
    
    /**
     * 根据id查询人才招聘信息
     * @author xiaokai
     * 2019年4月8日
     */
    Recruit findbyId(String id);
    
    /**
     * 新增或修改 
     * @author xiaokai
     * 2019年4月4日
     */
    int edit(Map<String, Object> obj);
    
    /**
     * 查询人才招聘信息
     * @author xiaokai
     * 2019年6月29日
     */
    List<Recruit> findRecruitInfo();
}
