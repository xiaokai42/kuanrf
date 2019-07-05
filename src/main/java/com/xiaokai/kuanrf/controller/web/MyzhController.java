package com.xiaokai.kuanrf.controller.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.service.web.MyzhService;

import cn.proem.core.controller.BaseController;

/**
 * 母婴照护
 */
@Controller
@RequestMapping(value = "myzh")
public class MyzhController extends BaseController
{
    @Resource
    private MyzhService myzhService;

    /**
     * 月子期护理跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "yzqhl", method = RequestMethod.GET)
    public ModelAndView yzqhl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("myzh/yzqhl/index.vm", null);
        view.addObject("head_path", "myzh/yzqhl/head.vm");
        view.addObject("yzqhl", myzhService.findYzqhlInfo());
        return view;
    }

    /**
     * 保存月子期护理信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "yzqhl/save")
    public ModelMap saveYzqhl(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = myzhService.saveYzqhl(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }

    /**
     * 产褥期形体指导跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "crqxtzd", method = RequestMethod.GET)
    public ModelAndView crqxtzd(HttpServletRequest request) {
        ModelAndView view = createLayoutView("myzh/crqxtzd/index.vm", null);
        view.addObject("head_path", "myzh/crqxtzd/head.vm");
        view.addObject("crqxtzd", myzhService.findCrqxtzdInfo());
        return view;
    }

    /**
     * 保存产褥期形体指导信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "crqxtzd/save")
    public ModelMap saveCrqxtzd(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = myzhService.saveCrqxtzd(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }

    /**
     * 营养膳食跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "yyss", method = RequestMethod.GET)
    public ModelAndView yyss(HttpServletRequest request) {
        ModelAndView view = createLayoutView("myzh/yyss/index.vm", null);
        view.addObject("head_path", "myzh/yyss/head.vm");
        view.addObject("yyss", myzhService.findYyssInfo());
        return view;
    }

    /**
     * 保存营养膳食信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "yyss/save")
    public ModelMap saveYyss(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = myzhService.saveYyss(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }

    /**
     * 宝宝护理跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "bbhl", method = RequestMethod.GET)
    public ModelAndView bbhl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("myzh/bbhl/index.vm", null);
        view.addObject("head_path", "myzh/bbhl/head.vm");
        view.addObject("bbhl", myzhService.findBbhlInfo());
        return view;
    }

    /**
     * 保存宝宝护理信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "bbhl/save")
    public ModelMap saveBbhl(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = myzhService.saveBbhl(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
}