package com.xiaokai.kuanrf.service.manage;

import java.util.List;

import com.xiaokai.kuanrf.entity.manage.Attachment;

/**
 * 文件信息
 * 
 * @author wuy
 */
public interface AttaService
{
    /**
     * 保存文件
     * 
     * @param atta
     * @return
     */
    public void saveAtta(Attachment atta);

    /**
     * 根据文件id获取文件信息
     * 
     * @author xiaokai 2019年3月26日
     */
    public Attachment getAttachmentById(String id);

    /**
     * 根据业务id与文件类型查询单个文件
     * 
     * @author xiaokai 2019年3月26日
     */
    public Attachment findAttachment(String businessId, Integer type);
    
    /**
     * 根据userId与文件类型查询文件
     * @author xiaokai
     * 2019年4月4日
     */
    public List<Attachment> findAttachmentByUserId(String userId, Integer type);
    
    /**
     * 根据businessId与文件类型查询文件
     * @author xiaokai
     * 2019年4月4日
     */
    public List<Attachment> findAttachmentByBusinessId(String businessId, Integer type);

    /**
     * 清理附件表数据
     */
    public void deleteAttachment();
}
