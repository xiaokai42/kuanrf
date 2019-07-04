package com.xiaokai.kuanrf.dao.manage.ipml;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.xiaokai.kuanrf.dao.manage.SysUserDao;
import com.xiaokai.kuanrf.entity.manage.SysUser;

import cn.proem.core.dao.impl.BaseDaoImpl;

/**
 * 用户
 * 
 * @author wuy
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao
{
    @Override
    public void updateRole(String userId)
    {
        String sql = "UPDATE ptp_user_role SET role_id =:roleId WHERE user_id =:userId";
        SQLQuery query = getSQLQuery(sql, null, null, false);
        query.setString("userId", userId);
        query.setString("roleId", "402880f36947c4b7016947d15fae0007");
        query.executeUpdate();
    }
}
