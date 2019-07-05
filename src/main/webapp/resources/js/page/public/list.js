$(function() {
	// 菜单切换效果
	$("nav .nav-content .nav-menu a.has-child").hover(function(){
		$("nav .nav-secound").css("animation", "show-nav-secound .5s forwards");
		$("nav .nav-content .nav-menu a .menu-child")
			.css("animation", "show-menu-child .5s .3s forwards");
	}, function(){
		$("nav .nav-secound").css("animation", "");
	});
	
	// 返回顶部
	$(".return-top").on("click", function(){
		document.body.scrollTop = 0;
		document.documentElement.scrollTop = 0;
	});
	
	// 二级菜单点击
	$("nav .nav-menu .nav-child .menu-child").on("click", "span", function(){
		window.location.href = Util.getRootPath() + $(this).attr("data-uri");
	});
	
	// 第一次加载请求分页数据
	getPageData();
	
	//以下将以jquery.ajax为例，演示一个异步分页
	function getPageData(nowPage){
		var param = {
			pageSize: 5,
			nowPage: nowPage||1,
			parameters: {
				status: 1,
				type: $("#type").val()
			}
		};
		$.ajax({
			type: "get",
			url: Util.getRootPath() + "/public/active/list",
			data : {dtGridPager: JSON.stringify(param)},
			dataType : "json",
			contentType : "application/json",
			success: function(data){
				var result = $.parseJSON(data);
				if (result.exhibitDatas.length > 0) {
					initdata(result.exhibitDatas);
					laypage({
						cont: 'page-bar', 
						pages: result.pageCount,
						curr: result.nowPage,
						jump: function (obj, first) {
							if(!first) {
								getPageData(obj.curr);
							}
						}
					});
				} else {
					$(".al-content-main").html("暂无数据");
				}
			},
			error : function(data) {
				layer.msg('请求失败,请联系管理员!', {icon: 5, time: 2000});
			}
		});
	};
	
	// 初始化分页数据
	function initdata(data) {
		var html = "";
		for (var i=0; i<data.length; i++) {
			var obj = data[i];
			html += '<a href="'+Util.getRootPath()+'/public/active/detail?id='+obj.id+'" class="alc-box">'
					+ '<img src="'+Util.getRootPath()+'/public/showPhoto?id='+obj.firstImg+'&type=61" width="290" height="190" />'
					+ '<div class="alc-box-text">'
					+ '<h1>'+formart(obj.title, 24)+'</h1><p>'+formart(obj.txt, 130)+'</p><span>'+formatDate(obj.activeDt.time)+'</span>'
					+ '</div></a>';
		}
		$(".al-content-main").html(html);
	}
	
	function formatDate(time) {
		var now = new Date(time);
    	var year=now.getFullYear();    
        var month=now.getMonth()+1;    
        var date=now.getDate();    
        return year+"-"+month+"-"+date;
    }
	
	function formart(value, length) {
		if (value != "") {
			if (value.length <= length) {
				return value;
			} else {
				return value.substring(0, length-1) + "...";
			}
		}
	}
});
