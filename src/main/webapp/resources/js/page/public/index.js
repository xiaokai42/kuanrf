$(function(){
	var browser = {
	    versions: function () {
	        var u = navigator.userAgent, app = navigator.appVersion;
	        return {
	            trident: u.indexOf('Trident') > -1,                            //IE内核
	            presto: u.indexOf('Presto') > -1,                              //opera内核
	            webKit: u.indexOf('AppleWebKit') > -1,                         //苹果、谷歌内核
	            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,    //火狐内核
	            mobile: !!u.match(/AppleWebKit.*Mobile.*/),                    //是否为移动终端
	            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),               //ios终端
	            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
	            iPhone: u.indexOf('iPhone') > -1,                              //是否为iPhone或者QQHD浏览器
	            iPad: u.indexOf('iPad') > -1,                                  //是否iPad
	            webApp: u.indexOf('Safari') == -1,                             //是否web应该程序，没有头部与底部
	            weixin: u.indexOf('MicroMessenger') > -1,                      //是否微信 （2015-01-22新增）
	            qq: u.match(/\sQQ/i) == " qq"                                  //是否QQ
	        };
	    }(),
	    language: (navigator.browserLanguage || navigator.language).toLowerCase()
	};
	// 判断是否为移动端
	if (browser.versions.mobile || browser.versions.android || browser.versions.ios) {
	    console.info("移动端");
	    window.location.href = "http://wap.kuanrf.com";
	}
	// 菜单切换效果
	$("nav .nav-content .nav-menu a.has-child").hover(function(){
		$("nav .nav-secound").css("animation", "show-nav-secound .5s forwards");
		$("nav .nav-content .nav-menu a .menu-child")
			.css("animation", "show-menu-child .5s .3s forwards");
	}, function(){
		$("nav .nav-secound").css("animation", "");
	});
	
	// 返回顶部
	$(".returnTop").on("click", function(){
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	});
	
	// 二级菜单点击
	$("nav .nav-menu .nav-child .menu-child").on("click", "span", function(){
		window.location.href = Util.getRootPath() + $(this).attr("data-uri");
	});
	
	var width = document.body.offsetWidth;
	$('.shutter').shutter({
		shutterW: width, // 容器宽度
		shutterH: 948, // 容器高度
		isAutoPlay: true, // 是否自动播放
		playInterval: 3000, // 自动播放时间
		curDisplay: 1, // 当前显示页
		fullPage: false // 是否全屏展示
	});
});