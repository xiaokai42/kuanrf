
$(function(){
	
	$(".btnBack").on("click",function() {
		window.location.href = Util.getRootPath()+"/public";
	});

	$(".captchaImg").on("click",function() {
		$(this).attr("src", Util.getRootPath() + "/captcha?t="+new Date());
	});

	/*$('register').click(function () {
        layer.open({
            type: 2,
            area: ['500px', '600px'],
            title: name,
            shadeClose: true,
            shade: 0.5,
            content: Util.getRootPath()+"/market/register"
        });
    })*/

	$("#loginForm").on("submit", function(){
		
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		var safecode = $("input[name='verifycode']").val();
		if($.trim(username).length == 0) {
			$("#msgTip").html("请输入用户名");
			return false;
		}
		if($.trim(password).length == 0) {
			$("#msgTip").html("请输入密码");
			return false;
		}
		if($.trim(safecode).length == 0) {
			$("#msgTip").html("请输入验证码");
			return false;
		}
		
		$("input[name='password']").val(MD5(password));
		return true;
	});
	
});

