$(function(){
	$("#formSubmit").click(function(){
		// 序列化表单提交参数
		var active = $('#bean-form').serializeObject();
		$.ajax({
			type: "post",
			url: Util.getRootPath() + "/chxf/saveText",
			data : JSON.stringify(active),
			dataType : "json",
			contentType : "application/json",
			success: function(data){
				if(data.code == 1){
					var index = top.layer.getFrameIndex(window.name);
					top.layer.close(index);
					top.layer.msg('保存成功!', {icon: 1, time: 2000});
				}
			},
			error : function(data) {
				layer.msg('请求失败,请联系管理员!', {icon: 2, time: 2000});
			}
		});
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