package com.xiaokai.kuanrf.service.web;

import java.util.List;
import java.util.Map;

import com.xiaokai.kuanrf.entity.web.Chtxcs;
import com.xiaokai.kuanrf.entity.web.Chtztl;
import com.xiaokai.kuanrf.entity.web.Nxsmhy;
import com.xiaokai.kuanrf.entity.web.Shtl;

import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;

/**
 * 产后修复
 * @author xiaokai
 * 2019年6月29日
 */
public interface ChxfService
{
    /**
     * 查询产后体质调理信息
     * @author xiaokai
     * 2019年6月29日
     */
    Chtztl findChtztlInfo();
    
    /**
     * 保存产后体质调理信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int saveChtztl(Map<String, Object> obj);

    /**
     * 查询产后体形重塑信息
     * @author xiaokai
     * 2019年6月29日
     */
    Chtxcs findChtxcsInfo();
    
    /**
     * 保存产后体形重塑信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int saveChtxcs(Map<String, Object> obj);
    
    /**
     * 查询舒缓调理信息
     * @author xiaokai
     * 2019年6月29日
     */
    Shtl findShtlInfo();
    
    /**
     * 保存舒缓调理信息
     * @author xiaokai
     * 2019年6月29日
     */
    public int saveShtl(Map<String, Object> obj);
    
    /**
     * 女性私密护养分页信息
     * @author xiaokai
     * 2019年7月7日
     */
    DataGrid<Nxsmhy> list(DataGridQuery query);
    
    /**
     * 根据id查询女性私密护养信息
     * @author xiaokai
     * 2019年4月8日
     */
    Nxsmhy findbyId(String id);
    
    /**
     * 新增或修改 
     * @author xiaokai
     * 2019年4月4日
     */
    int saveNxsmhy(Map<String, Object> obj);
    
    /**
     * 查询列表信息
     * @author xiaokai
     * 2019年7月7日
     */
    List<Nxsmhy> findNxsmhyInfo();
}
