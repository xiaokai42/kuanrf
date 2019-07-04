package com.xiaokai.kuanrf.dao.manage;

import java.util.List;

import com.xiaokai.kuanrf.entity.manage.Attachment;

import cn.proem.core.dao.BaseDao;

/**
 * 文件信息
 * 
 * @author wuy
 */
public interface AttaDao extends BaseDao<Attachment>
{
    /**
     * 根据id集合关联文件businessId
     * @author xiaokai
     * 2019年4月8日
     */
    public void updatefile(String businessId, List<String> srclist, String type);
}
