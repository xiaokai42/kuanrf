package com.xiaokai.kuanrf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.proem.core.controller.BaseController;
import cn.proem.core.entity.User;
import cn.proem.core.model.ConditionType;
import cn.proem.core.model.FieldType;
import cn.proem.core.model.QueryBuilder;
import cn.proem.core.model.QueryCondition;
import cn.proem.core.service.QueryService;

/**
 * 登录控制器
 */
@Controller
@RequestMapping(value = "login")
public class LoginController extends BaseController
{
    public static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private QueryService queryService;

    /**
     * 进入登录页面
     * 
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("login/index.vm", null);
        view.addObject("head_path", "login/head.vm");
        User user = (User) request.getSession().getAttribute("accountUser");
        if(null != user) 
        {
            return new ModelAndView("redirect:/main");
        }
        return view;
    }

    /**
     * 登录验证
     * 
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView validate(HttpServletRequest request)
    {
        String errMsg = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");
        if (verifycode == null || !verifycode.toUpperCase().equals(request.getSession().getAttribute(SAFE_CODE_NAME)))
        {
            errMsg = "验证码输入错误";
        }
        request.getSession().removeAttribute(SAFE_CODE_NAME);

        User user = null;
        if (errMsg == null)
        {
            QueryBuilder query = new QueryBuilder();
            query.addCondition(new QueryCondition("username", username, ConditionType.EQ, FieldType.STRING));
            query.addCondition(new QueryCondition("password", password, ConditionType.EQ, FieldType.STRING));
            query.addCondition(new QueryCondition("status", 1, ConditionType.EQ, FieldType.INTEGER));
            List<User> users = queryService.queryEntityList(User.class, query, null, 0, 0);
            if (!CollectionUtils.isEmpty(users) && (users.size() == 1))
            {
                user = users.get(0);
            } else
            {
                errMsg = "用户名或密码错误";
            }
        }

        if (errMsg != null)
        {
            ModelAndView view = createLayoutView("login/index.vm", null);
            view.addObject("head_path", "login/head.vm");
            view.addObject("username", username);
            view.addObject("msg", errMsg);
            return view;
        }

        request.getSession().setAttribute(PROFILE_NAME, user.getUsername());
        request.getSession().setAttribute("accountUser", user);
        return new ModelAndView("redirect:/main");
    }

}