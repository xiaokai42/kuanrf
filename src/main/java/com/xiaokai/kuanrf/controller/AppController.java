package com.xiaokai.kuanrf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaokai.kuanrf.entity.manage.Attachment;
import com.xiaokai.kuanrf.service.web.ActiveService;
import com.xiaokai.kuanrf.service.web.AppInfoService;
import com.xiaokai.kuanrf.service.web.HomeService;
import com.xiaokai.kuanrf.service.web.RecruitService;
import com.xiaokai.kuanrf.util.FileUtil;

import cn.proem.core.controller.BaseController;
import sun.misc.BASE64Encoder;      

/**
 * 移动端web接口
 * @author xiaokai
 * 2019年11月24日
 */
@Controller
@RequestMapping(value = "app")
@SuppressWarnings("restriction")
public class AppController extends BaseController {
    public static final Logger LOG = LoggerFactory.getLogger(AppController.class);
    
    @Resource
    private HomeService homeService;
    
    @Resource
    private AppInfoService appInfoService;

    @Resource
    private RecruitService recruitService;
    
    @Resource
    private ActiveService activeService;
    
    /**
     * 主页信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Map<String,Object> index() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("app", appInfoService.findAppInfo());
        return map;
    }
    
    /**
     * 底部信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "footer", method = RequestMethod.GET)
    public Map<String,Object> footer() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("home", homeService.findHomeInfo());
        return map;
    }
    
    /**
     * 人才招聘信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "recruit", method = RequestMethod.GET)
    public Map<String,Object> recruit() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list", recruitService.findRecruitInfo());
        return map;
    }
    
    /**
     * 活动信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "active", method = RequestMethod.GET)
    public Map<String,Object> active() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list", activeService.findActive());
        return map;
    }

    /**
     * 显示移动端图片
     * @param batch_id
     * @param idCardNo
     * @return
     */
    @ResponseBody
    @RequestMapping("showPhoto")
    public Map<String,Object> signPhoto(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String, Object>();
        Attachment atta = queryService.getEntityById(Attachment.class, request.getParameter("id"));
        byte[] photo = FileUtil.findByte(atta);
        map.put("img64", new BASE64Encoder().encode(photo).toString());
        return map;
    }
}
