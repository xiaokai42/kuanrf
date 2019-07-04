$(function(){
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