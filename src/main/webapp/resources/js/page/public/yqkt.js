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
			pageSize: 8,
			nowPage: nowPage||1,
			parameters: {}
		};
		$.ajax({
			type: "get",
			url: Util.getRootPath() + "/public/myzh/yqkt/list",
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
					$(".myzh-content-main").html("暂无数据");
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
			html += '<a data-uri="'+Util.getRootPath()+'/public/myzh/yqkt/detail?id='+obj.id+'" data-title="'+obj.title+'" class="mcm-list">'
					+ '<img src="'+Util.getRootPath()+'/public/showPhoto?id='+obj.firstImg+'&type=31"  width="296" height="222" />'
					+ '<div class="mcm-list-text">'+formart(obj.title, 20)+'</div></a>';
		}
		$(".myzh-content-main").html(html);
	}

	// 弹出一个页面层
    $('.myzh-content-main').on('click', '.mcm-list', function(){
        var uri = $(this).attr("data-uri");
        var title = $(this).attr("data-title");
        console.log(uri);
        layer.open({
            type: 2,
            area: ['800px', '500px'],
            title: title,
            shadeClose: true,
            shade: 0.5,
            content: uri
        });
    });
	
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