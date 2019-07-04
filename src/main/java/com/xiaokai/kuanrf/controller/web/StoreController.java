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

import com.xiaokai.kuanrf.service.web.StoreService;

import cn.proem.core.controller.BaseController;

/**
 * 门店信息编辑
 */
@Controller
@RequestMapping(value = "store")
public class StoreController extends BaseController
{
    @Resource
    private StoreService storeService;

    /**
     * 主页跳转
     *
     * @author xiaokai
     * 2019年6月26日
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = createLayoutView("store/index.vm", null);
        view.addObject("head_path", "store/head.vm");
        view.addObject("store", storeService.findStoreInfo());
        return view;
    }

    /**
     * 保存关于我们信息
     * @author xiaokai
     * 2019年6月26日
     */
    @ResponseBody
    @RequestMapping(value = "save")
    public ModelMap save(HttpServletRequest request, @RequestBody Map<String, Object> obj)
    {
        ModelMap resultMap = new ModelMap();
        
        int code = 0;
        code = storeService.save(obj);
        resultMap.put("code", code);
        
        return resultMap;
    }
}