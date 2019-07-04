package com.xiaokai.kuanrf.controller.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.entity.manage.Attachment;
import com.xiaokai.kuanrf.service.web.HomeService;
import com.xiaokai.kuanrf.util.FileUtil;

import cn.proem.core.controller.BaseController;
import cn.proem.core.service.QueryService;

/**
 * 首页编辑
 */
@Controller
@RequestMapping(value = "home")
public class HomeController extends BaseController
{
    @Resource
    private HomeService homeService;
    
    @Resource
    private QueryService queryService;

    /**
     * 主页跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = createLayoutView("home/index.vm", null);
        view.addObject("head_path", "home/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        return view;
    }

    /**
     * 保存首页信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "save")
    public ModelMap save(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = homeService.save(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 显示图片
     * @author xiaokai
     * 2019年6月29日
     */
    @RequestMapping("showPhoto")
    public ResponseEntity<byte[]> signPhoto(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Attachment atta = queryService.getEntityById(Attachment.class, request.getParameter("id"));
        byte[] photo = FileUtil.findByte(atta);
        if (photo != null) {
            return new ResponseEntity<byte[]>(photo, headers, HttpStatus.OK);
        }
        return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
    }
}