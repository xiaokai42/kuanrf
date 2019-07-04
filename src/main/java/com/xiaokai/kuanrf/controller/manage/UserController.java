package com.xiaokai.kuanrf.controller.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.service.manage.SysManageService;

import cn.proem.core.controller.BaseController;
import cn.proem.core.entity.User;
import cn.proem.core.entity.UserRole;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.model.JsonIgnoreProperty;
import cn.proem.core.service.QueryService;
import cn.proem.core.util.JsonUtil;

/**
 * 系统管理 - 用户账号信息
 */
@Controller
@RequestMapping(value = "manage/user")
public class UserController extends BaseController
{
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private SysManageService manageService;

    @Resource
    private QueryService queryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("manage/user/index.vm", "common/main");
        view.addObject("head_path", "manage/user/head.vm");
        view.addObject("roles", manageService.findRoles());
        return view;
    }

    /**
     * 用户列表信息
     *
     * @return
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public String list(String dtGridPager, HttpServletRequest request)
    {
        DataGridQuery query = parseToQuery(dtGridPager);
        DataGrid<UserRole> dg = manageService.findUsers(query);
        List<JsonIgnoreProperty> ignores = new ArrayList<JsonIgnoreProperty>();
        JsonIgnoreProperty jip = new JsonIgnoreProperty();
        jip.setPropertyName("password");
        ignores.add(jip);
        return JsonUtil.fromObjectToString(dg, ignores);
    }

    /**
     * 新增或修改
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "add/{id}")
    public ModelAndView add(HttpServletRequest request, @PathVariable("id") String id)
    {
        ModelAndView view = createLayoutView("manage/user/addIndex.vm", null);
        view.addObject("head_path", "manage/user/addHead.vm");
        view.addObject("roles", manageService.findRoles());
        view.addObject("id", id);
        if (!"0".equals(id))
        {
            view.addObject("userRole", queryService.getEntityById(UserRole.class, id));
        }
        return view;
    }

    /**
     * 保存账号信息
     *
     * @param request
     * @param obj
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public String save(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        String ret = "no";
        try
        {
            ret = manageService.saveUser(obj);
        } catch (Exception e)
        {
            LOG.error("保存账号信息异常", e);
            ret = "exception";
        }
        return ret;
    }

    /**
     * 密码重置
     *
     * @param objs
     * @return
     */
    @RequestMapping(value = "reset")
    @ResponseBody
    public String reset(@RequestBody List<Map<String, Object>> objs)
    {
        try
        {
            manageService.resetUser(objs);
        } catch (Exception e)
        {
            LOG.error("密码重置异常", e);
            return "no";
        }
        return "yes";
    }

    /**
     * 修改个人信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "person")
    public ModelAndView person(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("manage/person/index.vm", null);
        view.addObject("head_path", "manage/person/head.vm");
        view.addObject("user", getCurrentUser(request));
        return view;
    }

    /**
     * 保存个人信息
     *
     * @param request
     * @param obj
     * @return
     */
    @RequestMapping(value = "person/save")
    @ResponseBody
    public String savePerson(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        String ret = "no";
        try
        {
            User u = getCurrentUser(request);
            ret = manageService.savePerson(obj, u);
            request.getSession().setAttribute("accountUser", getCurrentUser(request));
        } catch (Exception e)
        {
            LOG.error("保存个人信息异常", e);
            ret = "exception";
        }
        return ret;
    }
}