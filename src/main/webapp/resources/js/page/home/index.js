$(function(){
	// 重置iframe高度 
	$(window.parent.document).find("iframe").height("");
	$(window.parent.document).find("iframe").height(document.body.offsetHeight);
	
	$(top.document).scroll(function() {
		if ($(top.window).scrollTop() > 113) {
			$("button.btn-primary").css("top", $(top.window).scrollTop()-113);
		} else {
			$("button.btn-primary").css("top", 0);
		}
	});
	
	// 表单验证
	$("#bean-form").Validform({
		btnSubmit: "#formSubmit",
		tiptype: function(msg, o){
			if (o.type == 3)
				top.layer.msg(msg, {time: 1200});
		},
		beforeSubmit: function(curform){
			var home = $('#bean-form').serializeObject();
			$("body").block({message:"数据提交中..."});
			// 根据身份证号获取生日
			$.ajax({
				type: "post",
				url: Util.getRootPath() + "/home/save",
				data : JSON.stringify(home),
				dataType : "json",
				contentType : "application/json",
				success: function(data){
					$("body").unblock({});
					if(data.code == 1){
						top.layer.msg('保存信息成功!', {icon: 1, time: 2000}, function(){
							window.location.href = Util.getRootPath() + "/home/edit";
						});
					}
				},
				error : function(data) {
					$("body").unblock({});
					top.layer.msg('请求失败,请联系管理员!', {icon: 2, time: 1200});
				}
			});
			// 必要,阻止Validform控件自动提交表单
			return false;
		}
	});
	
	//上传图片
	$("#main").on("change", ".uploadImg", function() {
		if($(this).val() != "") {
			uploadSignImg($(this).attr("data-type"), $(this).attr("id"));
		}
	});
	
	// 序列化表单对象
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
});