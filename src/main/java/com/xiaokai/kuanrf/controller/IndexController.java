package com.xiaokai.kuanrf.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.util.StringUtil;

import cn.proem.core.controller.BaseController;

/**
 * 基本控制器
 */
@Controller
public class IndexController extends BaseController
{

    /**
     * 对外首页
     * 
     * @return
     */
    @RequestMapping("")
    public ModelAndView entry(HttpServletRequest request)
    {
        return new ModelAndView("redirect:/public");
    }

    /**
     * 退出系统
     * 
     * @return
     */
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return new ModelAndView("redirect:/login");
    }

    /**
     * 404异常
     * 
     * @param request
     * @return
     */
    @RequestMapping("404")
    public ModelAndView error404(HttpServletRequest request)
    {
        return createLayoutView("error/error.vm", null);
    }

    /**
     * 500异常
     * 
     * @param request
     * @return
     */
    @RequestMapping("500")
    public ModelAndView error500(HttpServletRequest request)
    {
        return createLayoutView("error/error.vm", null);
    }

    /**
     * 405异常
     * 
     * @param request
     * @return
     */
    @RequestMapping("405")
    public ModelAndView error405(HttpServletRequest request)
    {
        return createLayoutView("error/error.vm", null);
    }

    /**
     * 下载文件
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "download/file")
    public ResponseEntity<byte[]> download(HttpServletRequest request)
    {
        // 文件下载名称
        String fileName = request.getParameter("name");
        // 文件名称
        String uuid = request.getParameter("uuid");
        String filePath = StringUtil.download() + "/" + uuid;
        File f = new File(filePath);
        if (!f.isFile())
        {
            fileName = "temp.xls";
            String realPath = StringUtil.class.getResource("/").getPath();
            filePath = realPath + "other/" + fileName;
        }
        return downloadFile(filePath, fileName);
    }
}