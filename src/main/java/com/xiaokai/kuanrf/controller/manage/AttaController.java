package com.xiaokai.kuanrf.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.entity.manage.Attachment;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.util.FileUtil;
import com.xiaokai.kuanrf.util.Ueditor;

import cn.proem.core.controller.BaseController;
import cn.proem.core.entity.User;
import cn.proem.core.service.QueryService;

/**
 * 文件上传
 */
@Controller
@RequestMapping(value = "manage/atta")
public class AttaController extends BaseController
{
    public static final Logger LOG = LoggerFactory.getLogger(AttaController.class);

    @Resource
    private QueryService queryService;

    @Resource
    private AttaService attaService;

    @RequestMapping(value = "ueditor", method = RequestMethod.GET)
    public ModelAndView ueditor(HttpServletRequest request)
    {
        return new ModelAndView("common/ueditor");
    }

    @ResponseBody
    @RequestMapping(value = "upload")
    public Map<String, Object> upload(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, Object> obj = new HashMap<String, Object>();
        try
        {
            User user = (User) request.getSession().getAttribute("accountUser");
            String action = request.getParameter("action");
            String fileType = request.getParameter("fileType");
            // System.out.println(action);
            // System.out.println(fileType);
            if ("config".equals(action))
            {
                String realPath = request.getSession().getServletContext().getRealPath("/");
                obj = Ueditor.getConfig(realPath);
            } else if (user == null)
            {
                obj.put("state", "上传文件失败");
                LOG.error("ueditor配置加载失败");
            } else
            {
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                MultipartFile upfile = multipartRequest.getFile("upfile");
                Attachment atta = Ueditor.changeFile(upfile, action, fileType);
                if (null != atta)
                {
                    FileUtil.uploadFile(upfile, atta);
                    atta.setUserId(user.getId());
                    attaService.saveAtta(atta);
                    obj.put("state", "SUCCESS");
                    if ("uploadimage".equals(action))
                    {
                        obj.put("url", FileUtil.ROOT + "/public/showPhoto?id=" + atta.getId());
                        Map<String, Integer> wh = Ueditor.getImgWH(atta);
                        obj.put("width", wh.get("width"));
                        obj.put("height", wh.get("height"));
                    } else if ("uploadfile".equals(action))
                    {
                        obj.put("url", FileUtil.ROOT + "/public/down/file?id=" + atta.getId());
                    } else if ("uploadvideo".equals(action))
                    {
                        obj.put("url", "/uevideo" + atta.getFilePath());
                    }
                    obj.put("title", atta.getFileName() + atta.getFileSuffix());
                    obj.put("original", atta.getFileName() + atta.getFileSuffix());
                } else
                {
                    obj.put("state", "上传文件失败");
                }
            }

        } catch (Exception e)
        {
            LOG.error("信息异常", e);
            obj.put("state", "上传文件失败");
        }

        return obj;
    }

}