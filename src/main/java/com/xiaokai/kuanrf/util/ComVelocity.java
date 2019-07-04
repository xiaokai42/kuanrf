package com.xiaokai.kuanrf.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component("comVelocity")
public class ComVelocity
{

    public static final Logger LOG = LoggerFactory.getLogger(ComVelocity.class);

    @Resource
    private VelocityEngine velocityEngine;

    /**
     * 根据vm模板创建文件
     * 
     * @param dataMap
     *            数据
     * @param saveFile
     *            保存路径
     * @param docName
     *            保存文件名称
     * @param vmpath
     *            模板路径
     */
    public void creatDoc(Map<String, Object> dataMap, String saveFile, String docName, String vmpath)
    {
        FileOutputStream fileOut = null;
        BufferedWriter writer = null;
        try
        {
            File file = new File(saveFile, docName);
            fileOut = new FileOutputStream(file);
            writer = new BufferedWriter(new OutputStreamWriter(fileOut, "UTF-8"));
            VelocityEngineUtils.mergeTemplate(velocityEngine, vmpath, "UTF-8", dataMap, writer);
            writer.flush();
            writer.close();
            fileOut.close();
        } catch (Exception e)
        {
            LOG.error("生成word文档异常", e);
        } finally
        {
            try
            {
                if (null != writer)
                {
                    writer.close();
                }
                if (null != fileOut)
                {
                    fileOut.close();
                }
            } catch (Exception e)
            {
                LOG.error("生成word文档异常", e);
            }
        }
    }

}
