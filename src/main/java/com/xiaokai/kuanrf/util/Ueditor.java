package com.xiaokai.kuanrf.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.xiaokai.kuanrf.entity.manage.Attachment;

/**
 * 编辑器工具类
 * 
 * @author wuy
 */
public class Ueditor
{
    public static final Logger LOG = LoggerFactory.getLogger(Ueditor.class);

    /**
     * 获取配置文件
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getConfig(String realPath)
    {
        Map<String, Object> obj = null;
        try
        {
            StringBuilder builder = new StringBuilder();
            String path = realPath + "/resources/plugins/ueditor1.4.3/jsp/config.json";
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader bfReader = new BufferedReader(reader);
            String tmpContent = null;
            while ((tmpContent = bfReader.readLine()) != null)
            {
                builder.append(tmpContent);
            }
            bfReader.close();
            String ret = builder.toString().replaceAll("/\\*[\\s\\S]*?\\*/", "");
            obj = JSON.parseObject(ret, Map.class);
        } catch (Exception e)
        {
            LOG.error("获取配置文件异常", e);
        }
        return obj;
    }

    /**
     * 转换文件
     * 
     * @param uploadFile
     * @param action uploadimage：图片，uploadfile：附件，uploadvideo：视频
     * @param fileType 60-精彩活动
     * @return
     */
    public static Attachment changeFile(MultipartFile uploadFile, String action, String fileType)
    {
        Attachment file = null;
        if (null != uploadFile && !StringUtils.isBlank(action) && !StringUtils.isBlank(fileType))
        {
            String rootPath = "";
            int type = 0;
            String fileName = uploadFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            String uuid = UUID.randomUUID().toString();
            String fileDate = File.separator + FileUtil.formatDate(Calendar.getInstance().getTime(), "yyyyMM") + File.separator;
            if ("60".equals(fileType))
            {
                type = 60;
            } else if ("30".equals(fileType))
            {
                type = 30;
            } else if ("40".equals(fileType))
            {
                type = 40;
            } else
            {
                return null;
            }

            if ("uploadimage".equals(action))
            {
                rootPath = FileUtil.ROOT + File.separator + "ueimage";
            } else if ("uploadfile".equals(action))
            {
                rootPath = FileUtil.ROOT + File.separator + "uefile";
            } else if ("uploadvideo".equals(action))
            {
                rootPath = FileUtil.ROOT + File.separator + "uevideo";
            } else
            {
                return null;
            }
            file = new Attachment();
            file.setFileDisk(FileUtil.DISK);
            file.setRootPath(rootPath);
            file.setFileName(fileName.toLowerCase().replace(suffix, ""));
            file.setRealName(uuid);
            file.setFilePath(File.separator + type + fileDate + uuid + suffix);
            file.setFileSuffix(suffix);
            file.setType(type);
            file.setFileSize(uploadFile.getSize());
        }

        return file;
    }

    /**
     * 获得图片高宽
     * 
     * @return
     */
    public static Map<String, Integer> getImgWH(Attachment atta)
    {
        Map<String, Integer> wh = new HashMap<String, Integer>();
        wh.put("width", 600);
        wh.put("height", 600);
        try
        {
            String path = FileUtil.findPath(atta);
            File f = new File(path);
            if (f.isFile())
            {
                BufferedImage img = ImageIO.read(f);
                int width = img.getWidth();
                int height = img.getHeight();
                img.flush();
                if (width < 600)
                {
                    wh.put("width", width);
                }
                if (height < 600)
                {
                    wh.put("height", height);
                }
            }
        } catch (Exception e)
        {
            // LOG.error("获得照片高宽异常", e);
        }
        return wh;
    }
}
