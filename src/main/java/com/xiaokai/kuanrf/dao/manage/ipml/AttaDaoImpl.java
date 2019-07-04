package com.xiaokai.kuanrf.dao.manage.ipml;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.xiaokai.kuanrf.dao.manage.AttaDao;
import com.xiaokai.kuanrf.entity.manage.Attachment;

import cn.proem.core.dao.impl.BaseDaoImpl;

/**
 * 文件信息
 * 
 * @author wuy
 */
@Repository
public class AttaDaoImpl extends BaseDaoImpl<Attachment> implements AttaDao
{

    @Override
    public void updatefile(String businessId, List<String> srclist, String type)
    {
        String sql = "";
        if ("file".equals(type)) {
            sql = "UPDATE rural_manage_attachment SET business_id =:businessId WHERE id in (:srclist)";
        } else {
            sql = "UPDATE rural_manage_attachment SET business_id =:businessId WHERE file_path in (:srclist)";
        }
        SQLQuery query = getSQLQuery(sql, null, null, false);
        query.setString("businessId", businessId);
        query.setParameterList("srclist", srclist);
        query.executeUpdate();
    }

}
