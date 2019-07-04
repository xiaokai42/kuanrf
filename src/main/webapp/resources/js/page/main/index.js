var layerObj;
$(function(){
	// 菜单滑动效果
	$("#main nav ul.menu li.menu-item .menu-item-text").on("click", function(){
		if ($(this).parent().attr("class").indexOf("active") != -1) {
			$(this).parent().removeClass("active");
			$(this).parent().find("ul.menu-child").slideUp();
		} else {
			$(this).parent().siblings().removeClass("active");
			$(this).parent().siblings().find("ul.menu-child").slideUp();
			$(this).parent().addClass("active");
			$(this).parent().find("ul.menu-child").slideDown();
		}	
	});
	
	// 菜单选中效果
	$("#main nav ul.menu li.menu-item ul.menu-child li.menu-child-item a").on("click", function(){
		$("#main nav ul.menu li.menu-item ul.menu-child li.menu-child-item a").removeClass("active");
		$(this).addClass("active");
	});

	// 获得第一个a标签路径
	var first = $("#main nav ul.menu li.menu-item ul.menu-child").find("a").eq(0).attr("href");
	$("iframe[name='mainContent']").attr("src", first);
	
	var tipMsg = $("#tipMsg").val();
	if(tipMsg == "true") {
		layer.msg("您的密码是初始化密码，请及时在个人中心修改！", {time: 5000});
	}
});

/**
 * 修改个人信息
 */
function updatePerson() {
	layerObj = top.layer.open({
		title : "修改个人信息",
		type : 2,
		area : ['400px', '530px'],
		success : function() {
			
		},
		end : function() {
			
		},
		content : [Util.getRootPath() + '/manage/user/person', 'no'],
		closeBtn : 1
	});
}
