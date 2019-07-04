
$(function() {
	
	initButton();
});

/**
 * 初始化按钮
 */
function initButton() {

	
	$(".cancelBtn").on("click", function() {
		var index = top.layer.getFrameIndex(window.name);
		top.layer.close(index);
	});
	
	$(".saveBtn").on("click", function() {
		saveUser();
	});
}

/**
 * 保存
 */
function saveUser() {
	if(validateUser()) {
		$("body").block({message : "账号信息保存中，请稍候..."});
		Util.ajaxJson(Util.getRootPath() + "/manage/user/save", {
			id : $.trim($("input[name='id']").val()),
			resource : $.trim($("input[name='resource']").val()),
			name : $.trim($("input[name='name']").val()),
			username : $.trim($("input[name='username']").val()),
			phone : $.trim($("input[name='phone']").val()),
			gender : $.trim($("input[name='gender']:checked").val()),
			status : $.trim($("input[name='status']:checked").val()),
			roleId : $.trim($("input[name='role']:checked").val())
		},function(data) {
			$("body").unblock({});
			if(data == "yes") {
				$(".cancelBtn").trigger("click");
				top.layer.msg('账号信息保存成功', {time: 5000, icon: 6});
			} else if(data == "exist") {
				top.layer.msg('账号已存在，请修改', {time: 5000, icon: 5});
			} else {
				top.layer.msg('数据保存失败', {time: 5000, icon: 5});
			}
		},function(e) {
			$("body").unblock({});
			top.layer.msg('数据保存失败', {time: 5000, icon: 5});
		});
	}
}

/**
 * 验证
 * @returns {Boolean}
 */
function validateUser() {
	var username = $.trim($("input[name='username']").val());
	if(Util.checkNull(username)) {
		top.layer.msg('账号不能为空', {time: 5000, icon:5});
		return false;
	}
	
	if (username.length < 6) {
		top.layer.msg('账号长度至少6位', {time: 5000, icon:5});
        return false;
    }
	
    if (!Util.checkNumAbc(username)) {
    	top.layer.msg('账号由字母和数字组成', {time: 5000, icon:5});
        return false;
    }
	
    if(Util.checkNull($.trim($("input[name='resource']").val()))) {
		top.layer.msg('区域不能为空', {time: 5000, icon:5});
		return false;
	}
    
	if(Util.checkNull($.trim($("input[name='name']").val()))) {
		top.layer.msg('姓名不能为空', {time: 5000, icon:5});
		return false;
	}
	
	var phone = $.trim($("input[name='phone']").val());
	if(Util.checkNull(phone)) {
		top.layer.msg('手机号不能空', {time: 5000, icon:5});
		return false;
	}
	
	if(!Util.checkTel(phone)) {
		top.layer.msg('请填写正确的手机号', {time: 5000, icon:5});
		return false;
	}
	
	if(Util.checkNull($("input[name='gender']:checked").val())) {
		top.layer.msg('请选择性别', {time: 5000, icon:5});
		return false;
	}
	
	if(Util.checkNull($("input[name='status']:checked").val())) {
		top.layer.msg('请选择状态', {time: 5000, icon:5});
		return false;
	}
	
	if(Util.checkNull($("input[name='role']:checked").val())) {
		top.layer.msg('请选择角色', {time: 5000, icon:5});
		return false;
	}
	
	return true;
}