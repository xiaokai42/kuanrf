package com.xiaokai.kuanrf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xiaokai.kuanrf.entity.manage.Attachment;

/**
 * 文件操作
 * 
 * @author wuy
 */
public class FileUtil
{
    public static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 用户主目录
     */
    public static final String DISK = System.getProperties().getProperty("user.home");

    /**
     * 固定为项目名称
     */
    public static final String ROOT = File.separator + "kuanrf";

    /**
     * 图片根目录
     */
    public static final String ROOT_SIGN = ROOT + File.separator + "web";

    /**
     * 文件根目录
     */
    public static final String ROOT_POLICY = ROOT + File.separator + "policy";

    public static Map<String, String> fileType = null;

    /**
     * 创建文件夹，文件夹名称不能包括“.”号
     * 
     * @param path
     */
    public static File createFolder(String path)
    {
        File dir = new File(path);
        if (!dir.isDirectory())
        {
            if (path.contains("."))
            {
                dir.getParentFile().mkdirs();
            } else
            {
                dir.mkdirs();
            }
        }
        return dir;
    }

    /**
     * 删除文件
     * 
     * @param path
     */
    public static void deleteFile(String path)
    {
        File file = new File(path);
        if (file.isFile())
        {
            file.delete();
        }
    }

    /**
     * 删除文件
     * 
     * @param path
     */
    public static void deleteFile(Attachment atta)
    {
        if (null != atta)
        {
            deleteFile(findPath(atta));
        }
    }

    /**
     * 转换文件
     * 
     * @param file
     * @param rootPath
     *            文件根目录
     * @param type
     *            文件类型
     * @return
     */
    public static Attachment changeFile(MultipartFile uploadFile, String rootPath, int type)
    {
        Attachment file = null;
        if (null != uploadFile && null != rootPath)
        {
            String fileName = uploadFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            String uuid = UUID.randomUUID().toString();
            String fileDate = File.separator + formatDate(Calendar.getInstance().getTime(), "yyyy") + File.separator;
            file = new Attachment();
            file.setFileDisk(DISK);
            file.setRootPath(rootPath);
            file.setFileName(fileName.toLowerCase().replace(suffix, ""));
            file.setRealName(uuid);
            file.setFilePath(File.separator +  type + fileDate + uuid + suffix);
            file.setFileSuffix(suffix);
            file.setType(type);
            file.setFileSize(uploadFile.getSize());
        }

        return file;
    }

    /**
     * 上传文件
     * 
     * @param uploadFile
     * @param file
     * @return
     */
    public static void uploadFile(MultipartFile uploadFile, Attachment file)
    {
        try
        {
            if (null != uploadFile && null != file)
            {
                File targetFile = createFolder(findPath(file));
                uploadFile.transferTo(targetFile);
            }
        } catch (Exception e)
        {
            LOG.error("文件上传异常", e);
        }
    }

    /**
     * 删除上传附件
     * 
     * @param files
     */
    public static void deleteFile(List<Attachment> files)
    {
        if (!CollectionUtils.isEmpty(files))
        {
            for (Attachment file : files)
            {
                deleteFile(findPath(file));
            }
        }
    }

    /**
     * 判断上传文件是否是指定类型的文件，true：是，false：不是
     * 
     * @param file
     * @param suffixs
     *            指定文件类型，小写，如：.jpg
     * @return
     */
    public static boolean checkSuffix(MultipartFile file, List<String> suffixs)
    {
        boolean ret = false;
        if (null != file)
        {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            ret = suffixs.contains(suffix.toLowerCase());
        }

        return ret;
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @param format
     *            如 yyyy年MM月dd日
     * @return
     */
    public static String formatDate(Date date, String format)
    {
        String result = "0000";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null)
        {
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 判断上传文件是否是指定类型的文件，true：是，false：不是
     * 
     * @param file
     * @param suffixs
     *            指定文件类型，小写，如：.jpg
     * @return
     */
    public static boolean checkSuffix(Attachment file, List<String> suffixs)
    {
        boolean ret = false;
        if (null != file)
        {
            String suffix = file.getFileSuffix();
            ret = suffixs.contains(suffix.toLowerCase());
        }
        return ret;
    }

    /**
     * 检查文件大小，true：超过，false：未超过
     * 
     * @param file
     * @param size
     *            单位：B
     * @return
     */
    public static boolean checkSize(Attachment file, long size)
    {
        boolean ret = false;
        if (null != file)
        {
            ret = (file.getFileSize() > size);
        }
        return ret;
    }

    /**
     * 获得文件路径
     * 
     * @param file
     * @return
     */
    public static String findPath(Attachment file)
    {
        if (null != file)
        {
            return file.getFileDisk() + file.getRootPath() + file.getFilePath();
        } else
        {
            return "";
        }
    }

    /**
     * 获得文件名称
     * 
     * @param file
     * @return
     */
    public static String findName(Attachment file)
    {
        if (null != file)
        {
            return file.getFileName() + file.getFileSuffix();
        } else
        {
            return "";
        }
    }

    /**
     * 常用文件的文件头如下：(以前六位为准) JPEG (jpg)，文件头：FFD8FF; PNG (png)，文件头：89504E47; GIF (gif)，文件头：47494638; TIFF (tif)，文件头：49492A00; Windows Bitmap
     * (bmp)，文件头：424D; CAD (dwg)，文件头：41433130; Adobe Photoshop (psd)，文件头：38425053; Rich Text Format (rtf)，文件头：7B5C727466; XML (xml)，文件头：3C3F786D6C;
     * HTML (html)，文件头：68746D6C3E; Email [thorough only] (eml)，文件头：44656C69766572792D646174653A; Outlook Express (dbx)，文件头：CFAD12FEC5FD746F; Outlook
     * (pst)，文件头：2142444E; MS Word/Excel (xls.or.doc)，文件头：D0CF11E0; MS Access (mdb)，文件头：5374616E64617264204A; WordPerfect (wpd)，文件头：FF575043;
     * Postscript (eps.or.ps)，文件头：252150532D41646F6265; Adobe Acrobat (pdf)，文件头：255044462D312E; Quicken (qdf)，文件头：AC9EBD8F; Windows Password
     * (pwl)，文件头：E3828596; ZIP Archive (zip)，文件头：504B0304; RAR Archive (rar)，文件头：52617221; Wave (wav)，文件头：57415645; AVI (avi)，文件头：41564920; Real Audio
     * (ram)，文件头：2E7261FD; Real Media (rm)，文件头：2E524D46; MPEG (mpg)，文件头：000001BA; MPEG (mpg)，文件头：000001B3; Quicktime (mov)，文件头：6D6F6F76; Windows Media
     * (asf)，文件头：3026B2758E66CF11; MIDI (mid)，文件头：4D546864;
     */
    public static String checkType(String type)
    {
        if (CollectionUtils.isEmpty(fileType))
        {
            fileType = new HashMap<String, String>();
            fileType.put("FFD8FF", "jpg");
            fileType.put("89504E", "png");
            fileType.put("474946", "gif");
        }
        return fileType.get(type);
    }

    /**
     * 头文件
     * 
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src)
    {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0)
        {
            return null;
        }
        for (int i = 0; i < 3; i++)
        {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2)
            {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString().toUpperCase();
    }

    /**
     * 判断上传的图片是否是jpg/png
     * 
     * @param file
     * @return
     */
    public static boolean isImg(MultipartFile file)
    {
        boolean b = false;
        try
        {
            if (null != file)
            {
                String name = file.getOriginalFilename();
                String suffix = name.substring(name.lastIndexOf("."));
                String fileType = bytesToHexString(file.getBytes());
                String type = checkType(fileType);
                b = ("jpg".equals(type) && suffix.toUpperCase().equals(".JPG"))
                        || ("png".equals(type) && suffix.toUpperCase().equals(".PNG"))
                        || ("gif".equals(type) && suffix.toUpperCase().equals(".GIF"));
            }
        } catch (Exception e)
        {
            LOG.error("照片判断异常", e);
        }
        return b;
    }

    /**
     * 检查上传的照片是否合格并上传文件，jpg/png/gif，小于2mb
     * 
     * @param file
     * @return
     */
    @SuppressWarnings("unused")
    public static Attachment checkImg(MultipartFile file, String rootPath, int type)
    {
        try
        {
            if ((null != file) && isImg(file))
            {
                Attachment atta = changeFile(file, rootPath, type);
                if (atta.getFileSize() <= (2 * 1024 * 1024))
                {
                    uploadFile(file, atta);
                    String path = findPath(atta);
                    File f = new File(path);
                    if (null != f)
                    {
                        return atta;
                    }
                    deleteFile(path);
                }

            }
        } catch (Exception e)
        {
            LOG.error("照片判断异常", e);
        }
        return null;
    }

    /**
     * 文件转换
     * 
     * @param atta
     * @return
     */
    public static byte[] findByte(Attachment atta)
    {
        byte[] bytes = null;
        if (null != atta)
        {
            try
            {
                File f = new File(findPath(atta));
                InputStream fis = new FileInputStream(f);
                bytes = FileCopyUtils.copyToByteArray(fis);
                fis.close();
            } catch (Exception e)
            {
                // LOG.error("文件转换异常", e);
            }
        }
        return bytes;
    }

    /**
     * 检查上传的政策信息文件是否合格并上传文件，pdf，小于10mb
     * 
     * @param file
     * @return
     */
    public static Attachment checkPolicy(MultipartFile file, String rootPath, int type)
    {
        try
        {
            List<String> suffixs = new ArrayList<String>();
            suffixs.add(".pdf");
            if ((null != file) && checkSuffix(file, suffixs))
            {
                Attachment atta = changeFile(file, rootPath, type);
                if (atta.getFileSize() <= (10 * 1024 * 1024))
                {
                    uploadFile(file, atta);
                    return atta;
                }
            }
        } catch (Exception e)
        {
            LOG.error("文件判断异常", e);
        }
        return null;
    }
}
