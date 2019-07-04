package com.xiaokai.kuanrf.service.manage.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.xiaokai.kuanrf.dao.manage.SysUserDao;
import com.xiaokai.kuanrf.service.manage.SysManageService;
import com.xiaokai.kuanrf.util.StringUtil;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.entity.Role;
import cn.proem.core.entity.User;
import cn.proem.core.entity.UserRole;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.Order;
import cn.proem.core.model.OrderType;
import cn.proem.core.model.QueryBuilder;
import cn.proem.core.model.QueryCondition;
import cn.proem.core.util.BeanUtils;

/**
 * 系统管理
 *
 * @author wuy
 */
@Service
public class SysManageSerivceImpl implements SysManageService {
    @Resource
    private GeneralDao generalDao;

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public DataGrid<UserRole> findUsers(DataGridQuery query) {
        DataGrid<UserRole> dataGrid = new DataGrid<UserRole>();
        if (null != query) {
            dataGrid.setNowPage(query.getNowPage());
            dataGrid.setPageSize(query.getPageSize());
            query.matchQueryCondition("name", null, ConditionType.EQ, FieldType.STRING, "user");
            query.matchQueryCondition("username", null, ConditionType.EQ, FieldType.STRING, "user");
            query.matchQueryCondition("phone", null, ConditionType.EQ, FieldType.STRING, "user");
            query.matchQueryCondition("status", null, ConditionType.EQ, FieldType.INTEGER, "user");
            query.matchQueryCondition("id", null, ConditionType.EQ, FieldType.STRING, "role");
            QueryBuilder queryBuilder = query.generateQueryBuilder();
            queryBuilder.addCondition(new QueryCondition("id", "admin", ConditionType.NEQ, FieldType.STRING, "user"));
            int recordCount = generalDao.countByCriteria(UserRole.class, queryBuilder);
            dataGrid.setRecordCount(recordCount);
            if (recordCount > 0) {
                List<UserRole> data = generalDao.queryByCriteria(
                        UserRole.class,
                        queryBuilder,
                        new Order[]{new Order("id", OrderType.ASC, "user")},
                        dataGrid.getStartRecord(),
                        dataGrid.getPageSize());
                dataGrid.setExhibitDatas(data);
            }
        }

        return dataGrid;
    }

    @Override
    public List<Role> findRoles() {
        Order[] orders = new Order[]{new Order("id", OrderType.ASC)};
        return generalDao.queryByCriteria(Role.class, null, orders, 0, 0);
    }

    @Override
    @Transactional
    public String saveUser(Map<String, Object> obj) {
        String ret = "no";
        String id = String.valueOf(obj.get("id")).replace("null", "").toString();
        String roleId = String.valueOf(obj.get("roleId")).replace("null", "").toString();
        String password = String.valueOf(obj.get("password")).replace("null", "").toString();
        User nowUser = BeanUtils.cloneObject(User.class, obj);
        if ("0".equals(id.trim())) {
            User u = generalDao.findUniqueByProperty("username", nowUser.getUsername(), User.class);
            if (null == u) {
                nowUser.setId(UUID.randomUUID().toString());
                if (password.equals("")) {
                    nowUser.setPassword(StringUtil.PWD);
                } else {
                    nowUser.setPassword(password);
                }
                generalDao.save(nowUser);
                UserRole uRole = new UserRole();
                uRole.setId(UUID.randomUUID().toString());
                uRole.setUser(nowUser);
                uRole.setState(0);
                uRole.setRole(generalDao.findById(roleId, Role.class));
                generalDao.save(uRole);
                ret = "yes";
            } else {
                ret = "exist";
            }
        } else {
            UserRole uRole = generalDao.findById(id, UserRole.class);
            User oldUser = uRole.getUser();
            oldUser.setName(nowUser.getName());
            oldUser.setGender(nowUser.getGender());
            oldUser.setStatus(nowUser.getStatus());
            oldUser.setPhone(nowUser.getPhone());
            oldUser.setResource(nowUser.getResource());
            generalDao.update(oldUser);
            if (!uRole.getRole().getId().equals(roleId)) {
                uRole.setRole(generalDao.findById(roleId, Role.class));
                generalDao.update(uRole);
            }
            ret = "yes";
        }
        return ret;
    }

    @Override
    @Transactional
    public void resetUser(List<Map<String, Object>> objs) {
        if (!CollectionUtils.isEmpty(objs)) {
            for (Map<String, Object> obj : objs) {
                String id = String.valueOf(obj.get("id"));
                UserRole uRole = generalDao.findById(id, UserRole.class);
                if (null != uRole) {
                    User u = uRole.getUser();
                    u.setPassword(StringUtil.PWD);
                    generalDao.update(u);
                }
            }
        }
    }

    @Override
    @Transactional
    public String savePerson(Map<String, Object> obj, User u) {
        String ret = "no";
        User nowUser = BeanUtils.cloneObject(User.class, obj);
        String pwd = String.valueOf(obj.get("nowPwd")).replace("null", "");
        if (null != u) {
            u.setName(nowUser.getName());
            u.setGender(nowUser.getGender());
            u.setPhone(nowUser.getPhone());
            if (StringUtils.isBlank(nowUser.getPassword())) {
                generalDao.update(u);
                ret = "yes";
            } else {
                if (!StringUtils.isBlank(pwd) && nowUser.getPassword().equals(u.getPassword())) {
                    u.setPassword(pwd);
                    generalDao.update(u);
                    ret = "yes";
                } else {
                    ret = "noPwd";
                }
            }
        }

        return ret;
    }
}
