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
import com.xiaokai.kuanrf.entity.web.Bbhl;
import com.xiaokai.kuanrf.entity.web.Crqxtzd;
import com.xiaokai.kuanrf.entity.web.Yyss;
import com.xiaokai.kuanrf.entity.web.Yzqhl;
import com.xiaokai.kuanrf.service.web.MyzhService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.Order;
import cn.proem.core.util.BeanUtils;

/**
 * 母婴照护
 * @author 13996
 * 2019年7月5日
 */
@Service
public class MyzhServiceImpl implements MyzhService
{
public static final Logger LOG = LoggerFactory.getLogger(MyzhServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;
    
    @Override
    public Yzqhl findYzqhlInfo()
    {
        List<Yzqhl> list = generalDao.queryByCriteria(Yzqhl.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveYzqhl(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Yzqhl yzqhl = BeanUtils.cloneObject(Yzqhl.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(yzqhl.getId())) {
                    generalDao.save(yzqhl);
                    result = 1;
                } else {    
                    generalDao.update(yzqhl);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增月子期护理信息异常", e);
        }
        return result;
    }

    @Override
    public Crqxtzd findCrqxtzdInfo()
    {
        List<Crqxtzd> list = generalDao.queryByCriteria(Crqxtzd.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveCrqxtzd(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Crqxtzd crqxtzd = BeanUtils.cloneObject(Crqxtzd.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(crqxtzd.getId())) {
                    generalDao.save(crqxtzd);
                    result = 1;
                } else {    
                    generalDao.update(crqxtzd);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增产褥期形体指导信息异常", e);
        }
        return result;
    }

    @Override
    public Yyss findYyssInfo()
    {
        List<Yyss> list = generalDao.queryByCriteria(Yyss.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveYyss(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Yyss yyss = BeanUtils.cloneObject(Yyss.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(yyss.getId())) {
                    generalDao.save(yyss);
                    result = 1;
                } else {    
                    generalDao.update(yyss);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增营养膳食信息异常", e);
        }
        return result;
    }

    @Override
    public Bbhl findBbhlInfo()
    {
        List<Bbhl> list = generalDao.queryByCriteria(Bbhl.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveBbhl(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Bbhl bbhl = BeanUtils.cloneObject(Bbhl.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(bbhl.getId())) {
                    generalDao.save(bbhl);
                    result = 1;
                } else {    
                    generalDao.update(bbhl);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增宝宝护理信息异常", e);
        }
        return result;
    }

}
