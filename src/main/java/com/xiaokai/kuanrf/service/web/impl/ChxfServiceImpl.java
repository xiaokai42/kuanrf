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

import com.xiaokai.kuanrf.entity.web.Chtxcs;
import com.xiaokai.kuanrf.entity.web.Chtztl;
import com.xiaokai.kuanrf.entity.web.Nxsmhy;
import com.xiaokai.kuanrf.entity.web.Shtl;
import com.xiaokai.kuanrf.service.web.ChxfService;

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
public class ChxfServiceImpl implements ChxfService
{
    public static final Logger LOG = LoggerFactory.getLogger(ChxfServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;
    
    @Override
    public Chtztl findChtztlInfo()
    {
        List<Chtztl> list = generalDao.queryByCriteria(Chtztl.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveChtztl(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Chtztl chtztl = BeanUtils.cloneObject(Chtztl.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(chtztl.getId())) {
                    generalDao.save(chtztl);
                    result = 1;
                } else {    
                    generalDao.update(chtztl);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增产后体质调理信息异常", e);
        }
        return result;
    }

    @Override
    public Chtxcs findChtxcsInfo()
    {
        List<Chtxcs> list = generalDao.queryByCriteria(Chtxcs.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveChtxcs(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Chtxcs chtxcs = BeanUtils.cloneObject(Chtxcs.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(chtxcs.getId())) {
                    generalDao.save(chtxcs);
                    result = 1;
                } else {    
                    generalDao.update(chtxcs);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增产后体形重塑信息异常", e);
        }
        return result;
    }

    @Override
    public Shtl findShtlInfo()
    {
        List<Shtl> list = generalDao.queryByCriteria(Shtl.class, null, new Order[] {}, 0, 1);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public int saveShtl(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Shtl shtl = BeanUtils.cloneObject(Shtl.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(shtl.getId())) {
                    generalDao.save(shtl);
                    result = 1;
                } else {    
                    generalDao.update(shtl);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增舒缓调理信息异常", e);
        }
        return result;
    }

    @Override
    public DataGrid<Nxsmhy> list(DataGridQuery query)
    {
        DataGrid<Nxsmhy> dataGrid = new DataGrid<Nxsmhy>();
        if (null != query)
        {
            dataGrid.setNowPage(query.getNowPage());
            dataGrid.setPageSize(query.getPageSize());
            query.matchQueryCondition("title", null, ConditionType.LIKE, FieldType.STRING, null);
            query.matchQueryCondition("status", null, ConditionType.EQ, FieldType.INTEGER, null);
            int recordCount = generalDao.countByCriteria(Nxsmhy.class, query.generateQueryBuilder());
            dataGrid.setRecordCount(recordCount);
            if (recordCount > 0)
            {
                List<Nxsmhy> data = generalDao.queryByCriteria(
                        Nxsmhy.class,
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
    public Nxsmhy findbyId(String id)
    {
        return generalDao.findById(id, Nxsmhy.class);
    }

    @Override
    @Transactional
    public int saveNxsmhy(Map<String, Object> obj)
    {
        int result = 0;// 返回结果:0-失败;1-成功
        try
        {
            if (!CollectionUtils.isEmpty(obj))
            {
                Nxsmhy nxsmhy = BeanUtils.cloneObject(Nxsmhy.class, obj);
                // 判断是新增或修改
                if (StringUtils.isBlank(nxsmhy.getId())) {
                    generalDao.save(nxsmhy);
                    result = 1;
                } else {    
                    generalDao.update(nxsmhy);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增女私密护养异常", e);
        }
        return result;
    }

    @Override
    public List<Nxsmhy> findNxsmhyInfo()
    {
        QueryBuilder query = new QueryBuilder();
        query.addCondition(new QueryCondition("status", 1, ConditionType.GE, FieldType.INTEGER));
        return generalDao.queryByCriteria(Nxsmhy.class, query, new Order[] {}, 0, 0);
    }

}
