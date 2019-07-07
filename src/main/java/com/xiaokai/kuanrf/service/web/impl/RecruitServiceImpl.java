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
import com.xiaokai.kuanrf.entity.web.Recruit;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.service.web.RecruitService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.Order;
import cn.proem.core.model.OrderType;
import cn.proem.core.model.QueryBuilder;
import cn.proem.core.model.QueryCondition;
import cn.proem.core.util.BeanUtils;

@Service
public class RecruitServiceImpl implements RecruitService
{

    public static final Logger LOG = LoggerFactory.getLogger(RecruitServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;
    
    @Resource
    private AttaDao attaDao;
    
    @Resource
    private AttaService attaService;
    
    @Override
    public DataGrid<Recruit> list(DataGridQuery query)
    {
        DataGrid<Recruit> dataGrid = new DataGrid<Recruit>();
        if (null != query)
        {
            dataGrid.setNowPage(query.getNowPage());
            dataGrid.setPageSize(query.getPageSize());
            query.matchQueryCondition("work", null, ConditionType.LIKE, FieldType.STRING, null);
            query.matchQueryCondition("status", null, ConditionType.EQ, FieldType.INTEGER, null);
            int recordCount = generalDao.countByCriteria(Recruit.class, query.generateQueryBuilder());
            dataGrid.setRecordCount(recordCount);
            if (recordCount > 0)
            {
                List<Recruit> data = generalDao.queryByCriteria(
                        Recruit.class,
                        query.generateQueryBuilder(),
                        new Order[] { new Order("createDate", OrderType.DESC) },
                        dataGrid.getStartRecord(),
                        dataGrid.getPageSize());
                dataGrid.setExhibitDatas(data);

            }
        }
        return dataGrid;
    }

    @Override
    public Recruit findbyId(String id)
    {
        return generalDao.findById(id, Recruit.class);
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
                Recruit recruit = BeanUtils.cloneObject(Recruit.class, obj);
                // 判断是新增或修改
                if (StringUtils.isBlank(recruit.getId())) {
                    generalDao.save(recruit);
                    result = 1;
                } else {    
                    generalDao.update(recruit);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增人才招聘异常", e);
        }
        return result;
    }

    @Override
    public List<Recruit> findRecruitInfo()
    {
        QueryBuilder query = new QueryBuilder();
        query.addCondition(new QueryCondition("status", 1, ConditionType.GE, FieldType.INTEGER));
        return generalDao.queryByCriteria(Recruit.class, query, new Order[] {}, 0, 0);
    }

}
