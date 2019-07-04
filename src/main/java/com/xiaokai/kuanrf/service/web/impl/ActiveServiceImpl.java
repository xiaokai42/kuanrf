package com.xiaokai.kuanrf.service.web.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.xiaokai.kuanrf.dao.manage.AttaDao;
import com.xiaokai.kuanrf.entity.web.Active;
import com.xiaokai.kuanrf.entity.web.ActiveImg;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.service.web.ActiveService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.Order;
import cn.proem.core.model.OrderType;
import cn.proem.core.util.BeanUtils;
import jersey.repackaged.com.google.common.collect.Lists;
import jersey.repackaged.com.google.common.collect.Maps;

@Service
public class ActiveServiceImpl implements ActiveService
{
    public static final Logger LOG = LoggerFactory.getLogger(ActiveServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;
    
    @Resource
    private AttaDao attaDao;
    
    @Resource
    private AttaService attaService;
    
    @Override
    public DataGrid<Active> list(DataGridQuery query)
    {
        DataGrid<Active> dataGrid = new DataGrid<Active>();
        if (null != query)
        {
            dataGrid.setNowPage(query.getNowPage());
            dataGrid.setPageSize(query.getPageSize());
            query.matchQueryCondition("type", null, ConditionType.EQ, FieldType.INTEGER, null);
            int recordCount = generalDao.countByCriteria(Active.class, query.generateQueryBuilder());
            dataGrid.setRecordCount(recordCount);
            if (recordCount > 0)
            {
                List<Active> data = generalDao.queryByCriteria(
                        Active.class,
                        query.generateQueryBuilder(),
                        new Order[] { new Order("activeDt", OrderType.DESC) },
                        dataGrid.getStartRecord(),
                        dataGrid.getPageSize());
                dataGrid.setExhibitDatas(data);

            }
        }
        return dataGrid;
    }

    @Override
    public Active findbyId(String id)
    {
        return generalDao.findById(id, Active.class);
    }

    @Override
    @Transactional
    public int edit(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Active active = BeanUtils.cloneObject(Active.class, obj);
                active.setMonth(String.format("%tm", active.getActiveDt()));
                active.setDay(String.format("%td", active.getActiveDt()));
                // 判断是新增或修改
                if (StringUtils.isBlank(active.getId())) {
                    generalDao.save(active);
                    result = 1;
                } else {    
                    generalDao.update(active);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增活动异常", e);
        }
        return result;
    }

    @Override
    public ActiveImg findActiveImgInfo()
    {
        List<ActiveImg> list = generalDao.queryByCriteria(ActiveImg.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveImg(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                ActiveImg activeImg = BeanUtils.cloneObject(ActiveImg.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(activeImg.getId())) {
                    generalDao.save(activeImg);
                    result = 1;
                } else {    
                    generalDao.update(activeImg);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增精彩活动大图信息异常", e);
        }
        return result;
    }

    @Override
    public Map<String, Object> findActiveInfo()
    {
        Map<String, Object> map = Maps.newHashMap();
        List<Active> list = generalDao.queryByCriteria(Active.class, null, new Order[] {}, 0, 0);
        if (list.size() > 0) {
            List<Active> list1 = Lists.newArrayList();
            List<Active> list2 = Lists.newArrayList();
            for (Active active : list)
            {
                if (active.getType() == 10) {
                    list1.add(active);
                } else {
                    list2.add(active);
                }
            }
            map.put("list1", list1);
            map.put("list2", list2);
            return map;
        } else {
            return null;
        }
    }
}
