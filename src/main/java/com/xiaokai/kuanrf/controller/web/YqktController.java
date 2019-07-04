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

import com.xiaokai.kuanrf.entity.web.Yqkt;
import com.xiaokai.kuanrf.service.web.YqktService;

import cn.proem.core.controller.BaseController;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.util.JsonUtil;

/**
 * 母婴照护-孕期课堂
 */
@Controller
@RequestMapping(value = "myzh/yqkt")
public class YqktController extends BaseController
{
    @Resource
    private YqktService yqktService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("myzh/yqkt/index.vm", "common/main");
        view.addObject("head_path", "myzh/yqkt/head.vm");
        return view;
    }

    /**
     * 孕期课堂列表信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list")
    public String list(String dtGridPager, HttpServletRequest request)
    {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Yqkt> dg = yqktService.list(query);
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
        ModelAndView view = createLayoutView("myzh/yqkt/addIndex.vm", null);
        view.addObject("head_path", "myzh/yqkt/addHead.vm");
        if (null != id) {
            view.addObject("yqkt", yqktService.findbyId(id));
        }
        return view;
    }

    /**
     * 新增或修改孕期课堂信息 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelMap edit(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = yqktService.edit(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 新增或修改母婴照护大图
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "editImg", method = RequestMethod.GET)
    public ModelAndView editImg(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("myzh/yqkt/editImg.vm", null);
        view.addObject("head_path", "myzh/yqkt/editImgHead.vm");
        view.addObject("activeImg", yqktService.findMyzhImgInfo());
        return view;
    }
    

    /**
     * 新增或修改母婴照护大图
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveImg", method = RequestMethod.POST)
    public ModelMap saveImg(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = yqktService.saveImg(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
}