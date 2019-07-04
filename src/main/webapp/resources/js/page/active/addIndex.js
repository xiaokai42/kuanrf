$(function(){
	// 重置iframe高度 
	$(window.parent.document).find("iframe").height("");
	$(window.parent.document).find("iframe").height(document.body.offsetHeight);
	
	// 初始化ueditor编辑器
	var ue = UE.getEditor('editor', {
		scaleEnabled: true,
		imageFieldName: "upfile",
		imageUrl: "/kuanrf/manage/atta/upload?fileType=60"
	});
	
	// 表单验证
	$("#bean-form").Validform({
		btnSubmit: "#formSubmit",
		tiptype: function(msg, o){
			if (o.type == 3)
				layer.msg(msg, {time: 2000});
		},
		beforeSubmit: function(curform){
			// 编辑器非空判断
			if (!UE.getEditor('editor').hasContents()) {
				layer.msg("请输入填报内容", {time: 2000});
				UE.getEditor('editor').focus();
				return false;
			}
			// 序列化表单提交参数
			var active = $('#bean-form').serializeObject();
			// 获取编辑框纯文本
			active.txt = UE.getEditor('editor').getContentTxt();
			$.ajax({
				type: "post",
				url: Util.getRootPath() + "/active/edit",
				data : JSON.stringify(active),
				dataType : "json",
				contentType : "application/json",
				success: function(data){
					if(data.code == 1){
						layer.msg('保存成功!', {icon: 1, time: 2000}, function(){
							window.location.href = Util.getRootPath() + "/active/list";
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
	
	// 获取html代码中图片地址
	function getimgsrc(htmlstr) {
		var reg = /<img.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/gim;
		var arr = [];
		while (tem = reg.exec(htmlstr)) {
			arr.push(tem[2]);
		}
		return arr;
	}
	
	// 获取html代码中附件地址
	function getasrc(htmlstr) {
		var reg = /<a.+?href=('|")?([^'"]+)('|")?(?:\s+|>)/gim;
		var arr = [];
		while (tem = reg.exec(htmlstr)) {
			arr.push(tem[2]);
		}
		return arr;
	}
	
	// 获取html代码中视频地址
	function getembedsrc(htmlstr) {
		var reg = /<video.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/gim;
		var arr = [];
		while (tem = reg.exec(htmlstr)) {
			arr.push(tem[2]);
		}
		return arr;
	}
	
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