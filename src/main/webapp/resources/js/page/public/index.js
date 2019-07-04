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
	
	var list = [];
	
	var img1 = $("#bannerImg1").val(),
		img2 = $("#bannerImg2").val(),
		img3 = $("#bannerImg3").val(),
		img4 = $("#bannerImg4").val();
	if (img1 != "") {
		var url1 = Util.getRootPath() + "/public/showPhoto?id=" + img1; 
		list.push({src: url1, href: "#"});
	}
	if (img2 != "") {
		var url2 = Util.getRootPath() + "/public/showPhoto?id=" + img2; 
		list.push({src: url2, href: "#"});
	}
	if (img3 != "") {
		var url3 = Util.getRootPath() + "/public/showPhoto?id=" + img3; 
		list.push({src: url3, href: "#"});
	}
	if (img4 != "") {
		var url4 = Util.getRootPath() + "/public/showPhoto?id=" + img4; 
		list.push({src: url4, href: "#"});
	}
	
	new Vue({
		el: "#app",
		data: {
			images: list,
			config: {
				effect: "slide"
			}
		}
	});
});