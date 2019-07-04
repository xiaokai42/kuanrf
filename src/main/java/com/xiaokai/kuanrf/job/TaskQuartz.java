package com.xiaokai.kuanrf.job;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xiaokai.kuanrf.service.manage.AttaService;

@Component
public class TaskQuartz
{
    private static final Logger LOG = LoggerFactory.getLogger(TaskQuartz.class);
    
    @Resource
    private AttaService attaService;
    
    /**
     * TODO 定时处理数据
     */
    @Scheduled(cron = "0 0 21 * * ?")
    public void executeSearchPay()
    {
        
        // 定时清理附件表
        executeAtta();
    }
    
    /**
     * 定时清理附件表
     */
    public void executeAtta()
    {
        try
        {
            //attaService.deleteAttachment();
        } catch (Exception e)
        {
            LOG.error("清理附件表异常",e);
        }
    }
}


