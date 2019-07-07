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
import com.xiaokai.kuanrf.entity.web.MyzhImg;
import com.xiaokai.kuanrf.entity.web.Yqkt;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.service.web.YqktService;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.Order;
import cn.proem.core.model.OrderType;
import cn.proem.core.util.BeanUtils;

@Service
public class YqktServiceImpl implements YqktService
{

    public static final Logger LOG = LoggerFactory.getLogger(YqktServiceImpl.class);
    
    @Resource
    private GeneralDao generalDao;
    
    @Resource
    private AttaDao attaDao;
    
    @Resource
    private AttaService attaService;
    
    @Override
    public DataGrid<Yqkt> list(DataGridQuery query)
    {
        DataGrid<Yqkt> dataGrid = new DataGrid<Yqkt>();
        if (null != query)
        {
            dataGrid.setNowPage(query.getNowPage());
            dataGrid.setPageSize(query.getPageSize());
            query.matchQueryCondition("title", null, ConditionType.LIKE, FieldType.STRING, null);
            query.matchQueryCondition("status", null, ConditionType.EQ, FieldType.INTEGER, null);
            int recordCount = generalDao.countByCriteria(Yqkt.class, query.generateQueryBuilder());
            dataGrid.setRecordCount(recordCount);
            if (recordCount > 0)
            {
                List<Yqkt> data = generalDao.queryByCriteria(
                        Yqkt.class,
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
    public Yqkt findbyId(String id)
    {
        return generalDao.findById(id, Yqkt.class);
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
                Yqkt yqkt = BeanUtils.cloneObject(Yqkt.class, obj);
                // 判断是新增或修改
                if (StringUtils.isBlank(yqkt.getId())) {
                    generalDao.save(yqkt);
                    result = 1;
                } else {    
                    generalDao.update(yqkt);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增孕期课堂异常", e);
        }
        return result;
    }

    @Override
    public MyzhImg findMyzhImgInfo()
    {
        List<MyzhImg> list = generalDao.queryByCriteria(MyzhImg.class, null, new Order[] {}, 0, 1);
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
                MyzhImg activeImg = BeanUtils.cloneObject(MyzhImg.class, obj);
                // 判断是新增或修改
                if (StringUtils.isEmpty(activeImg.getId())) {
                    generalDao.save(activeImg);
                    result = 1;
                } else {    
                    MyzhImg myzhImg = generalDao.findById(activeImg.getId(), MyzhImg.class);
                    if (StringUtils.isNotEmpty(activeImg.getBannerImg())) {
                        myzhImg.setBannerImg(activeImg.getBannerImg());
                    }
                    if (StringUtils.isNotEmpty(activeImg.getBannerImg1())) {
                        myzhImg.setBannerImg1(activeImg.getBannerImg1());
                    }
                    if (StringUtils.isNotEmpty(activeImg.getBannerImg2())) {
                        myzhImg.setBannerImg2(activeImg.getBannerImg2());
                    }
                    if (StringUtils.isNotEmpty(activeImg.getMyzhText())) {
                        myzhImg.setBannerImg2(activeImg.getMyzhText());
                    }
                    generalDao.update(myzhImg);
                    result = 1;
                }
            }
        } catch (Exception e)
        {
            LOG.error("新增精彩活动大图信息异常", e);
        }
        return result;
    }

}
