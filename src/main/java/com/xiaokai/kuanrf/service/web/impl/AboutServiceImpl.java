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
import com.xiaokai.kuanrf.entity.web.About;
import com.xiaokai.kuanrf.service.web.AboutService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.Order;
import cn.proem.core.util.BeanUtils;

/**
 * 关于我们信息service
 * @author xiaokai
 * 2019年6月29日
 */
@Service
public class AboutServiceImpl implements AboutService
{
    public static final Logger LOG = LoggerFactory.getLogger(AboutServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;


    @Override
    public About findAboutInfo()
    {
        List<About> list = generalDao.queryByCriteria(About.class, null, new Order[] {}, 0, 1);
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
                About about = BeanUtils.cloneObject(About.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(about.getId())) {
                    generalDao.save(about);
                    result = 1;
                } else {    
                    generalDao.update(about);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增关于我们信息异常", e);
        }
        return result;
    }

}
