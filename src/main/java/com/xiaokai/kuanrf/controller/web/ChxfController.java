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

import com.xiaokai.kuanrf.entity.web.Nxsmhy;
import com.xiaokai.kuanrf.service.web.ChxfService;
import com.xiaokai.kuanrf.service.web.YqktService;

import cn.proem.core.controller.BaseController;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.util.JsonUtil;

/**
 * 产后修复
 */
@Controller
@RequestMapping(value = "chxf")
public class ChxfController extends BaseController
{
    @Resource
    private YqktService yqktService;
    
    @Resource
    private ChxfService chxfService;

    /**
     * 产后体质调理跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "chtztl", method = RequestMethod.GET)
    public ModelAndView chtztl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("chxf/chtztl/index.vm", null);
        view.addObject("head_path", "chxf/chtztl/head.vm");
        view.addObject("chtztl", chxfService.findChtztlInfo());
        return view;
    }

    /**
     * 保存产后体质调理信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "chtztl/save")
    public ModelMap saveChtztl(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = chxfService.saveChtztl(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }

    /**
     * 产后体形重塑跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "chtxcs", method = RequestMethod.GET)
    public ModelAndView chtxcs(HttpServletRequest request) {
        ModelAndView view = createLayoutView("chxf/chtxcs/index.vm", null);
        view.addObject("head_path", "chxf/chtxcs/head.vm");
        view.addObject("chtxcs", chxfService.findChtxcsInfo());
        return view;
    }

    /**
     * 保存产后体形重塑信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "chtxcs/save")
    public ModelMap saveChtxcs(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = chxfService.saveChtxcs(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 舒缓调理跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "shtl", method = RequestMethod.GET)
    public ModelAndView shtl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("chxf/shtl/index.vm", null);
        view.addObject("head_path", "chxf/shtl/head.vm");
        view.addObject("shtl", chxfService.findShtlInfo());
        return view;
    }

    /**
     * 保存舒缓调理信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "shtl/save")
    public ModelMap saveShtl(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = chxfService.saveShtl(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }

    /**
     * 女性私密护养列表页
     * @author xiaokai
     * 2019年7月7日
     */
    @RequestMapping(value = "nxsmhy", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("chxf/nxsmhy/index.vm", "common/main");
        view.addObject("head_path", "chxf/nxsmhy/head.vm");
        return view;
    }

    /**
     * 女性私密护养分页信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "nxsmhy/list")
    public String list(String dtGridPager, HttpServletRequest request)
    {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Nxsmhy> dg = chxfService.list(query);
        return JsonUtil.fromObjectToString(dg, null);
    }
    
    /**
     * 新增或修改页面
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "nxsmhy/toAdd/{id}", method = RequestMethod.GET)
    public ModelAndView toAdd(HttpServletRequest request, @PathVariable("id") String id)
    {
        ModelAndView view = createLayoutView("chxf/nxsmhy/addIndex.vm", null);
        view.addObject("head_path", "chxf/nxsmhy/addHead.vm");
        if (null != id) {
            view.addObject("nxsmhy", chxfService.findbyId(id));
        }
        return view;
    }

    /**
     * 保存女性私密护养信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "nxsmhy/save")
    public ModelMap saveNxsmhy(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = chxfService.saveNxsmhy(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
    /**
     * 新增或修改产后修复大图
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "editImg", method = RequestMethod.GET)
    public ModelAndView editImg(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("chxf/chtztl/editImg.vm", null);
        view.addObject("head_path", "chxf/chtztl/editImgHead.vm");
        view.addObject("activeImg", yqktService.findMyzhImgInfo());
        return view;
    }
    

    /**
     * 新增或修改产后修复大图
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
    
    /**
     * 新增或修改女性私密护养描述
     * @author xiaokai
     * 2019年4月8日
     */
    @RequestMapping(value = "editText", method = RequestMethod.GET)
    public ModelAndView editText(HttpServletRequest request)
    {
        ModelAndView view = createLayoutView("chxf/nxsmhy/editImg.vm", null);
        view.addObject("head_path", "chxf/nxsmhy/editImgHead.vm");
        view.addObject("activeImg", yqktService.findMyzhImgInfo());
        return view;
    }
    

    /**
     * 新增或修改女性私密护养描述
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveText", method = RequestMethod.POST)
    public ModelMap saveText(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = yqktService.saveImg(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
    
}