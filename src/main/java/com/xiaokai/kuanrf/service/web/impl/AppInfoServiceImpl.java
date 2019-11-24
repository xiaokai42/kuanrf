package com.xiaokai.kuanrf.service.web.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.xiaokai.kuanrf.entity.web.AppInfo;
import com.xiaokai.kuanrf.service.web.AppInfoService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.Order;
import cn.proem.core.util.BeanUtils;

/**
 * 移动端信息service
 * @author xiaokai
 * 2019年11月24日
 */
@Service
public class AppInfoServiceImpl implements AppInfoService
{
    public static final Logger LOG = LoggerFactory.getLogger(AppInfoServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;

    @Override
    public AppInfo findAppInfo()
    {
        List<AppInfo> list = generalDao.queryByCriteria(AppInfo.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int save(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                AppInfo appInfo = BeanUtils.cloneObject(AppInfo.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(appInfo.getId())) {
                    generalDao.save(appInfo);
                    result = 1;
                } else {    
                    generalDao.update(appInfo);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增移动端信息异常", e);
        }
        return result;
    }

}
