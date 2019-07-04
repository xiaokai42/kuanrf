package com.xiaokai.kuanrf.service.manage.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.xiaokai.kuanrf.dao.manage.AttaDao;
import com.xiaokai.kuanrf.entity.manage.Attachment;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.util.FileUtil;

import cn.proem.core.dao.GeneralDao;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.QueryBuilder;
import cn.proem.core.model.QueryCondition;

/**
 * 文件信息
 * 
 * @author wuy
 */
@Service
public class AttaSerivceImpl implements AttaService
{
    @Resource
    private GeneralDao generalDao;

    @Resource
    private AttaDao attaDao;

    @Override
    @Transactional
    public void saveAtta(Attachment atta)
    {
        attaDao.save(atta);
    }

    @Override
    @Transactional
    public void deleteAttachment()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -12);
        QueryBuilder query = new QueryBuilder();
        query.addCondition(new QueryCondition("businessId", null, ConditionType.NULL, FieldType.STRING));
        query.addCondition(new QueryCondition("createDate", cal.getTime(), ConditionType.LT, FieldType.DATE));
        List<Attachment> attas = attaDao.queryByCriteria(query, null, 0, 0);
        if (!CollectionUtils.isEmpty(attas))
        {
            for (Attachment a : attas)
            {
                attaDao.delete(a);
                FileUtil.deleteFile(a);
            }
        }
    }

    @Override
    public Attachment getAttachmentById(String id)
    {
        return generalDao.findById(id, Attachment.class);
    }

    @Override
    public Attachment findAttachment(String businessId, Integer type)
    {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.addCondition(new QueryCondition("businessId", businessId, ConditionType.EQ, FieldType.STRING));
        queryBuilder.addCondition(new QueryCondition("type", type, ConditionType.EQ, FieldType.INTEGER));
        List<Attachment> list = generalDao.queryByCriteria(Attachment.class, queryBuilder, null, 0, 0);
        if (list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Attachment> findAttachmentByUserId(String userId, Integer type)
    {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.addCondition(new QueryCondition("userId", userId, ConditionType.EQ, FieldType.STRING));
        queryBuilder.addCondition(new QueryCondition("type", type, ConditionType.EQ, FieldType.INTEGER));
        return generalDao.queryByCriteria(Attachment.class, queryBuilder, null, 0, 0);
    }

    @Override
    public List<Attachment> findAttachmentByBusinessId(String businessId, Integer type)
    {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.addCondition(new QueryCondition("businessId", businessId, ConditionType.EQ, FieldType.STRING));
        queryBuilder.addCondition(new QueryCondition("type", type, ConditionType.EQ, FieldType.INTEGER));
        return generalDao.queryByCriteria(Attachment.class, queryBuilder, null, 0, 0);
    }

}
