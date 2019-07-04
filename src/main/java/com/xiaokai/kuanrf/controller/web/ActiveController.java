package com.xiaokai.kuanrf.controller.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.entity.web.Active;
import com.xiaokai.kuanrf.service.web.ActiveService;

import cn.proem.core.controller.BaseController;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.util.JsonUtil;

/**
 * 精彩活动
 */
@Controller
@RequestMapping(value = "active")
public class ActiveController extends BaseController
{
    @Resource
    private ActiveService activeService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("active/index.vm", "common/main");
        view.addObject("head_path", "active/head.vm");
        return view;
    }

    /**
     * 精彩活动列表信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list/page")
    public String list(String dtGridPager, HttpServletRequest request)
    {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Active> dg = activeService.list(query);
        return JsonUtil.fromObjectToString(dg, null);
    }
    
    /**
     * 新增或修改页面
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "toAdd/{id}", method = RequestMethod.GET)
    public ModelAndView toAdd(HttpServletRequest request, @PathVariable("id") String id)
    {
        ModelAndView view = createLayoutView("active/addIndex.vm", null);
        view.addObject("head_path", "active/addHead.vm");
        if (null != id) {
            view.addObject("active", activeService.findbyId(id));
        }
        return view;
    }

    /**
     * 新增或修改精彩活动信息 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelMap edit(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = activeService.edit(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 新增或修改活动页大图
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "editImg", method = RequestMethod.GET)
    public ModelAndView editImg(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("active/editImg.vm", null);
        view.addObject("head_path", "active/editImgHead.vm");
        view.addObject("activeImg", activeService.findActiveImgInfo());
        return view;
    }
    

    /**
     * 新增或修改精彩活动大图
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveImg", method = RequestMethod.POST)
    public ModelMap saveImg(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = activeService.saveImg(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
}