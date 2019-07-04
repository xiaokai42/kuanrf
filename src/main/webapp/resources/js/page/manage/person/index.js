
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
		$("body").block({message : "信息保存中，请稍候..."});
		
		var oldPwd = $.trim($("input[name='oldPwd']").val());
		var newPwd = $.trim($("input[name='newPwd']").val());
		if(oldPwd != "") {
			oldPwd = MD5(oldPwd);
		}
		if(newPwd != "") {
			newPwd = MD5(newPwd);
		}
		
		Util.ajaxJson(Util.getRootPath() + "/manage/user/person/save", {
			name : $.trim($("input[name='name']").val()),
			phone : $.trim($("input[name='phone']").val()),
			gender : $.trim($("input[name='gender']:checked").val()),
			password : oldPwd,
			nowPwd : newPwd
		},function(data) {
			$("body").unblock({});
			if(data == "yes") {
				$(".cancelBtn").trigger("click");
				top.layer.msg('信息保存成功', {time: 5000, icon: 6});
			} else if(data == "noPwd") {
				top.layer.msg('旧密码错误', {time: 5000, icon: 5});
			} else {
				top.layer.msg('信息保存失败', {time: 5000, icon: 5});
			}
		},function(e) {
			$("body").unblock({});
			top.layer.msg('信息保存失败', {time: 5000, icon: 5});
		});
	}
}

/**
 * 验证
 * @returns {Boolean}
 */
function validateUser() {
	
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

	var oldPwd = $.trim($("input[name='oldPwd']").val());
	var newPwd = $.trim($("input[name='newPwd']").val());
	var surePwd = $.trim($("input[name='surePwd']").val());
	if(!Util.checkNull(oldPwd+newPwd+surePwd)) {
		if(Util.checkNull(oldPwd)) {
			top.layer.msg('旧密码不能为空', {time: 5000, icon:5});
			return false;
		}
	    
		if(Util.checkNull(newPwd)) {
			top.layer.msg('新密码不能为空', {time: 5000, icon:5});
			return false;
		}
		if (newPwd.length < 6) {
			top.layer.msg('新密码长度至少6位', {time: 5000, icon:5});
	        return false;
	    }
		
	    if (!Util.checkNumAbc(newPwd)) {
	    	top.layer.msg('新密码由字母和数字组成', {time: 5000, icon:5});
	        return false;
	    }
	    
		if(Util.checkNull(surePwd)) {
			top.layer.msg('确认密码不能为空', {time: 5000, icon:5});
			return false;
		}
		if (surePwd.length < 6) {
			top.layer.msg('确认密码长度至少6位', {time: 5000, icon:5});
	        return false;
	    }
		
	    if (!Util.checkNumAbc(surePwd)) {
	    	top.layer.msg('确认密码由字母和数字组成', {time: 5000, icon:5});
	        return false;
	    }
	    
	    if (newPwd != surePwd) {
	    	top.layer.msg('两次密码输入不一致', {time: 5000, icon:5});
	        return false;
	    }
	}
	return true;
}