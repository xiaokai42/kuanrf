package com.xiaokai.kuanrf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xiaokai.kuanrf.entity.manage.Attachment;
import com.xiaokai.kuanrf.entity.web.Active;
import com.xiaokai.kuanrf.entity.web.Yqkt;
import com.xiaokai.kuanrf.service.manage.AttaService;
import com.xiaokai.kuanrf.service.web.AboutService;
import com.xiaokai.kuanrf.service.web.ActiveService;
import com.xiaokai.kuanrf.service.web.AdvantageService;
import com.xiaokai.kuanrf.service.web.ChxfService;
import com.xiaokai.kuanrf.service.web.HomeService;
import com.xiaokai.kuanrf.service.web.MyzhService;
import com.xiaokai.kuanrf.service.web.RecruitService;
import com.xiaokai.kuanrf.service.web.StoreService;
import com.xiaokai.kuanrf.service.web.YqktService;
import com.xiaokai.kuanrf.util.FileUtil;

import cn.proem.core.controller.BaseController;
import cn.proem.core.model.DataGrid;
import cn.proem.core.model.DataGridQuery;
import cn.proem.core.service.QueryService;
import cn.proem.core.util.JsonUtil;

/**
 * 对外显示
 */
@Controller
@RequestMapping(value = "public")
public class PublicController extends BaseController{
    public static final Logger LOG = LoggerFactory.getLogger(PublicController.class);

    @Resource
    private QueryService queryService;
    
    @Resource
    private AttaService attaService;
    
    @Resource
    private HomeService homeService;
    
    @Resource
    private AdvantageService advantageService;
    
    @Resource
    private AboutService aboutService;
    
    @Resource
    private StoreService storeService;
    
    @Resource
    private ActiveService activeService;
    
    @Resource
    private YqktService yqktService;
    
    @Resource
    private MyzhService myzhService;

    @Resource
    private RecruitService recruitService;
    
    @Resource
    private ChxfService chxfService;

    /**
     * 主页跳转
     *
     * @author xiaokai
     * 2019年3月20日
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/index.vm", null);
        view.addObject("head_path", "public/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        return view;
    }

    /**
     * 品牌介绍跳转
     *
     * @return
     */
    @RequestMapping(value = "advantage")
    public ModelAndView toAdvantage(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/advantage/index.vm", null);
        view.addObject("head_path", "public/advantage/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("advantage", advantageService.findAdvantageInfo());
        return view;
    }

    /**
     * 关于我们跳转
     *
     * @return
     */
    @RequestMapping(value = "about")
    public ModelAndView toAbout(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/about/index.vm", null);
        view.addObject("head_path", "public/about/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("about", aboutService.findAboutInfo());
        return view;
    }

    /**
     * 门店信息跳转-解放碑店
     *
     * @return
     */
    @RequestMapping(value = "store/jfb")
    public ModelAndView toStoreJfb(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/store/index.vm", null);
        view.addObject("head_path", "public/store/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("store", storeService.findStoreInfo());
        return view;
    }

    /**
     * 门店信息跳转-沙坪坝店
     *
     * @return
     */
    @RequestMapping(value = "store/spb")
    public ModelAndView toStoreSpb(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/store/index1.vm", null);
        view.addObject("head_path", "public/store/head1.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("store", storeService.findStoreInfo());
        return view;
    }

    /**
     * 精彩活动主页跳转
     *
     * @return
     */
    @RequestMapping(value = "active")
    public ModelAndView active(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/active/index.vm", null);
        view.addObject("head_path", "public/active/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("map", activeService.findActiveInfo());
        view.addObject("activeImg", activeService.findActiveImgInfo());
        return view;
    }

    /**
     * 精彩活动列表页跳转
     *
     * @return
     */
    @RequestMapping(value = "active/tolist")
    public ModelAndView tolist(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/active/list.vm", "common/main");
        view.addObject("head_path", "public/active/listHead.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("activeImg", activeService.findActiveImgInfo());
        view.addObject("type", request.getParameter("type"));
        return view;
    }

    /**
     * 精彩活动列表页信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "active/list", method = RequestMethod.GET)
    public String list(String dtGridPager, HttpServletRequest request) {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Active> dg = activeService.list(query);
        return JsonUtil.fromObjectToString(dg, null);
    }

    /**
     * 精彩活动内容页跳转
     *
     * @return
     */
    @RequestMapping(value = "active/detail")
    public ModelAndView detail(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/active/detail.vm", "common/main");
        view.addObject("head_path", "public/active/detailHead.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("activeImg", activeService.findActiveImgInfo());
        view.addObject("active", activeService.findbyId(request.getParameter("id")));
        return view;
    }

    /**
     * 母婴照护-孕期课堂跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/yqkt")
    public ModelAndView yqkt(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/yqkt/index.vm", null);
        view.addObject("head_path", "public/myzh/yqkt/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        return view;
    }

    /**
     * 母婴照护-孕期课堂列表页信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "myzh/yqkt/list", method = RequestMethod.GET)
    public String yqktlist(String dtGridPager, HttpServletRequest request) {
        // 查询条件
        DataGridQuery query = parseToQuery(dtGridPager);
        // 表格数据
        DataGrid<Yqkt> dg = yqktService.list(query);
        return JsonUtil.fromObjectToString(dg, null);
    }

    /**
     * 母婴照护-孕期课堂内容页跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/yqkt/detail")
    public ModelAndView yqktDetail(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/yqkt/detail.vm", "common/main");
        view.addObject("head_path", "public/myzh/yqkt/detailHead.vm");
        view.addObject("yqkt", yqktService.findbyId(request.getParameter("id")));
        return view;
    }

    /**
     * 母婴照护-月子期护理跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/yzqhl")
    public ModelAndView yzqhl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/yzqhl/index.vm", null);
        view.addObject("head_path", "public/myzh/yzqhl/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        view.addObject("yzqhl", myzhService.findYzqhlInfo());
        return view;
    }

    /**
     * 母婴照护-产褥期形体指导跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/crqxtzd")
    public ModelAndView crqxtzd(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/crqxtzd/index.vm", null);
        view.addObject("head_path", "public/myzh/crqxtzd/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        view.addObject("crqxtzd", myzhService.findCrqxtzdInfo());
        return view;
    }

    /**
     * 母婴照护-营养膳食跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/yyss")
    public ModelAndView yyss(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/yyss/index.vm", null);
        view.addObject("head_path", "public/myzh/yyss/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        view.addObject("yyss", myzhService.findYyssInfo());
        return view;
    }

    /**
     * 母婴照护-宝宝护理跳转
     *
     * @return
     */
    @RequestMapping(value = "myzh/bbhl")
    public ModelAndView bbhl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/myzh/bbhl/index.vm", null);
        view.addObject("head_path", "public/myzh/bbhl/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        view.addObject("bbhl", myzhService.findBbhlInfo());
        return view;
    }

    /**
     * 人才招聘跳转
     *
     * @return
     */
    @RequestMapping(value = "recruit")
    public ModelAndView recruit(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/recruit/index.vm", null);
        view.addObject("head_path", "public/recruit/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("yqktImg", yqktService.findMyzhImgInfo());
        view.addObject("list", recruitService.findRecruitInfo());
        return view;
    }

    /**
     * 产后修复-产后体质调理跳转
     *
     * @return
     */
    @RequestMapping(value = "chxf/chtztl")
    public ModelAndView chtztl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/chxf/chtztl/index.vm", null);
        view.addObject("head_path", "public/chxf/chtztl/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("chxfImg", yqktService.findMyzhImgInfo());
        view.addObject("chtztl", chxfService.findChtztlInfo());
        return view;
    }

    /**
     * 产后修复-产后体形重塑跳转
     *
     * @return
     */
    @RequestMapping(value = "chxf/chtxcs")
    public ModelAndView chtxcs(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/chxf/chtxcs/index.vm", null);
        view.addObject("head_path", "public/chxf/chtxcs/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("chxfImg", yqktService.findMyzhImgInfo());
        view.addObject("chtxcs", chxfService.findChtxcsInfo());
        return view;
    }

    /**
     * 产后修复-舒缓调理跳转
     *
     * @return
     */
    @RequestMapping(value = "chxf/shtl")
    public ModelAndView shtl(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/chxf/shtl/index.vm", null);
        view.addObject("head_path", "public/chxf/shtl/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("chxfImg", yqktService.findMyzhImgInfo());
        view.addObject("shtl", chxfService.findShtlInfo());
        return view;
    }

    /**
     * 产后修复-女性私密护养跳转
     *
     * @return
     */
    @RequestMapping(value = "chxf/nxsmhy")
    public ModelAndView nxsmhy(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/chxf/nxsmhy/index.vm", null);
        view.addObject("head_path", "public/chxf/nxsmhy/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("chxfImg", yqktService.findMyzhImgInfo());
        view.addObject("list", chxfService.findNxsmhyInfo());
        return view;
    }

    /**
     * 最新优惠
     *
     * @return
     */
    @RequestMapping(value = "preference")
    public ModelAndView preference(HttpServletRequest request) {
        ModelAndView view = createLayoutView("public/preference/index.vm", null);
        view.addObject("head_path", "public/preference/head.vm");
        view.addObject("home", homeService.findHomeInfo());
        view.addObject("preference", homeService.findPreferenceInfo());
        return view;
    }
    
    /**
     * 上传图片
     *
     * @param file    文件对象
     * @param request
     */
    @RequestMapping(value = "signup/image", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadImg(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("flag", false);
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = multipartRequest.getFiles("file");
            if ((null != files) && (files.size() == 1)) {
                Attachment atta = FileUtil.checkImg(files.get(0), FileUtil.ROOT_SIGN, Integer.valueOf(request.getParameter("type")));
                if (null != atta) {
                    attaService.saveAtta(atta);
                    result.put("flag", true);
                    result.put("id", atta.getId());
                } else {
                    result.put("msg", "上传图片不合格，图片格式为jpg，小于2mb");
                }
            } else {
                result.put("msg", "上传图片为空或多个");
            }
        } catch (Exception e) {
            LOG.error("图片上传异常", e);
            result.put("msg", "图片上传异常");
        }
        return result;
    }

    /**
     * 显示报名照片
     *
     * @param batch_id
     * @param idCardNo
     * @return
     */
    @RequestMapping("showPhoto")
    public ResponseEntity<byte[]> signPhoto(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Attachment atta = queryService.getEntityById(Attachment.class, request.getParameter("id"));
        byte[] photo = FileUtil.findByte(atta);
        if (photo != null) {
            return new ResponseEntity<byte[]>(photo, headers, HttpStatus.OK);
        }
        return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
    }

    /**
     * 根据类型、业务id显示图片
     *
     * @param batch_id
     * @param idCardNo
     * @return
     */
    /*@RequestMapping("showPhoto")
    public ResponseEntity<byte[]> showPhoto(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Integer type = Integer.parseInt(request.getParameter("type"));
        Attachment atta = attaService.findAttachment(request.getParameter("id"), type);
        byte[] photo = FileUtil.findByte(atta);
        if (photo != null) {
            return new ResponseEntity<byte[]>(photo, headers, HttpStatus.OK);
        }
        return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
    }*/

}