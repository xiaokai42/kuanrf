package com.xiaokai.kuanrf.service.manage;

import java.util.List;
import java.util.Map;

import cn.proem.core.entity.Role;
import cn.proem.core.entity.User;
import cn.proem.core.entity.UserRole;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;

/**
 * 系统管理
 * 
 * @author wuy
 */
public interface SysManageService
{
    /**
     * 查询所有角色
     * 
     * @return
     */
    public List<Role> findRoles();

    /**
     * 查询账号信息
     * 
     * @param query
     * @return
     */
    public DataGrid<UserRole> findUsers(DataGridQuery query);

    /**
     * 保存账号信息
     * 
     * @param obj
     * @return
     */
    public String saveUser(Map<String, Object> obj);

    /**
     * 重置密码
     * 
     * @param objs
     * @return
     */
    public void resetUser(List<Map<String, Object>> objs);

    /**
     * 保存个人信息
     * 
     * @param obj
     * @return
     */
    public String savePerson(Map<String, Object> obj, User u);
}
