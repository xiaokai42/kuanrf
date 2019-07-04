package com.xiaokai.kuanrf.dao.manage;

import com.xiaokai.kuanrf.entity.manage.SysUser;

import cn.proem.core.dao.BaseDao;

/**
 * 用户
 * 
 * @author wuy
 */
public interface SysUserDao extends BaseDao<SysUser>
{

    /**
     * 修改用户角色为三师一家
     * 
     * @param userId
     */
    public void updateRole(String userId);
}
