package com.xiaokai.kuanrf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.util.StringUtil;

import cn.proem.core.controller.BaseController;
import cn.proem.core.entity.User;

/**
 * 登陆后主页
 */
@Controller
@RequestMapping(value = "main")
public class MainController extends BaseController
{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("main/index.vm", null);
        view.addObject("head_path", "main/head.vm");
        User user = (User) request.getSession().getAttribute("accountUser");
        if((null != user) && StringUtil.PWD.equals(user.getPassword())) 
        {
            view.addObject("tipMsg", true);
        } else 
        {
            view.addObject("tipMsg", false);
        }
        return view;
    }

}