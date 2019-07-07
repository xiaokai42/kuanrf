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

import com.xiaokai.kuanrf.entity.web.Recruit;
import com.xiaokai.kuanrf.service.web.RecruitService;
import com.xiaokai.kuanrf.service.web.YqktService;

import cn.proem.core.controller.BaseController;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.util.JsonUtil;

/**
 * 人才招聘
 */
@Controller
@RequestMapping(value = "recruit")
public class RecruitController extends BaseController
{
    @Resource
    private YqktService yqktService;
    
    @Resource
    private RecruitService recruitService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("recruit/index.vm", "common/main");
        view.addObject("head_path", "recruit/head.vm");
        return view;
    }

    /**
     * 人才招聘列表信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list/page")
    public String list(String dtGridPager, HttpServletRequest request)
    {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Recruit> dg = recruitService.list(query);
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
        ModelAndView view = createLayoutView("recruit/addIndex.vm", null);
        view.addObject("head_path", "recruit/addHead.vm");
        if (null != id) {
            view.addObject("recruit", recruitService.findbyId(id));
        }
        return view;
    }

    /**
     * 新增或修改人才招聘信息 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelMap edit(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = recruitService.edit(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 新增或修改人才招聘大图
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "editImg", method = RequestMethod.GET)
    public ModelAndView editImg(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("recruit/editImg.vm", null);
        view.addObject("head_path", "recruit/editImgHead.vm");
        view.addObject("activeImg", yqktService.findMyzhImgInfo());
        return view;
    }
    

    /**
     * 新增或修改人才招聘大图
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