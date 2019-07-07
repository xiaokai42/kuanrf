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
import com.xiaokai.kuanrf.entity.web.Home;
import com.xiaokai.kuanrf.entity.web.Preference;
import com.xiaokai.kuanrf.service.web.HomeService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.Order;
import cn.proem.core.util.BeanUtils;

/**
 * 首页信息service
 * @author xiaokai
 * 2019年6月29日
 */
@Service
public class HomeServiceImpl implements HomeService
{
    public static final Logger LOG = LoggerFactory.getLogger(HomeServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;


    @Override
    public Home findHomeInfo()
    {
        List<Home> list = generalDao.queryByCriteria(Home.class, null, new Order[] {}, 0, 1);
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
                Home home = BeanUtils.cloneObject(Home.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(home.getId())) {
                    generalDao.save(home);
                    result = 1;
                } else {    
                    generalDao.update(home);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增首页信息异常", e);
        }
        return result;
    }

    @Override
    public Preference findPreferenceInfo()
    {
        List<Preference> list = generalDao.queryByCriteria(Preference.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int savePreference(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Preference preference = BeanUtils.cloneObject(Preference.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(preference.getId())) {
                    generalDao.save(preference);
                    result = 1;
                } else {    
                    generalDao.update(preference);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增优惠信息异常", e);
        }
        return result;
    }

}
