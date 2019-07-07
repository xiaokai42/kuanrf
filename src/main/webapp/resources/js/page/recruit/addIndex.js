$(function(){
	// 重置iframe高度 
	$(window.parent.document).find("iframe").height("");
	$(window.parent.document).find("iframe").height(document.body.offsetHeight);

	$(top.document).scroll(function() {
		if ($(top.window).scrollTop() > 113) {
			$("button.add").css("top", $(top.window).scrollTop()-113);
		} else {
			$("button.add").css("top", 0);
		}
	});
	
	// 表单验证
	$("#bean-form").Validform({
		btnSubmit: "#formSubmit",
		tiptype: function(msg, o){
			if (o.type == 3)
				layer.msg(msg, {time: 2000});
		},
		beforeSubmit: function(curform){
			let dutyText = "";
			$("table.duty tbody tr td").each(function(){
				let val = $(this).find("input").val();
				if (val != "") {
					if (dutyText == "") {
						dutyText += $(this).find("input").val();
					} else {
						dutyText += "-" + $(this).find("input").val();
					}
				}
			});
			$("#hiddenDuty").val(dutyText);
			let welfareText = "";
			$("table.welfare tbody tr td").each(function(){
				let val = $(this).find("input").val();
				if (val != "") {
					if (welfareText == "") {
						welfareText += $(this).find("input").val();
					} else {
						welfareText += "-" + $(this).find("input").val();
					}
				}
			});
			$("#hiddenWelfare").val(welfareText);
			// 序列化表单提交参数
			var active = $('#bean-form').serializeObject();
			$.ajax({
				type: "post",
				url: Util.getRootPath() + "/recruit/edit",
				data : JSON.stringify(active),
				dataType : "json",
				contentType : "application/json",
				success: function(data){
					if(data.code == 1){
						layer.msg('保存成功!', {icon: 1, time: 2000}, function(){
							window.location.href = Util.getRootPath() + "/recruit/list";
						});
					}
				},
				error : function(data) {
					layer.msg('请求失败,请联系管理员!', {icon: 2, time: 2000});
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
	
	$("#addDuty").on("click", function(){
		var dutyHtml = '<tr><td><input type="text" class="input-form" style="width: 100%;" /></td>'
			+ '<td><input type="text" class="input-form" style="width: 100%;" /></td></tr>';
		$("table.duty tbody").append(dutyHtml);
		// 重置iframe高度 
		$(window.parent.document).find("iframe").height("");
		$(window.parent.document).find("iframe").height(document.body.offsetHeight);
	});
	
	$("#welfare").on("click", function(){
		var welfareHtml = '<tr><td><input type="text" class="input-form" style="width: 100%;" /></td>'
			+ '<td><input type="text" class="input-form" style="width: 100%;" /></td></tr>';
		$("table.welfare tbody").append(welfareHtml);
		// 重置iframe高度 
		$(window.parent.document).find("iframe").height("");
		$(window.parent.document).find("iframe").height(document.body.offsetHeight);
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