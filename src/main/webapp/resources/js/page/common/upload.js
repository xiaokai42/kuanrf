/**
 * 报名照片上传
 * @param type 类型
 * @param fileId 文件上传ID
 * @param imgId 图片ID
 * @param inputId 保存信息
 */
function uploadSignImg(type, fileId) {
	$("body").block({message:"文件上传中..."});
	$.ajaxFileUpload({
		type : "post",
		url : Util.getRootPath()+"/public/signup/image",
		secureuri : false,
		dataType : "JSON",
		fileElementId : [fileId], // 文件上传的id属性
		data : {
			type : type
		},
		success : function(text, status) {
			$("body").unblock({});
			var data = $.parseJSON(text.replace(/<[^>]+>/g,""));
			if (data.flag) {
				var src = Util.getRootPath()+"/public/showPhoto?id="+data.id;
				$("#"+fileId + "-img").attr("src", src);
				$("#"+fileId + "-input").val(data.id);
				$("#"+fileId).replaceWith('<input type="file" id="'+fileId+'" data-type="'+type+'" class="uploadImg" name="file" accept="image/*" />');
			} else {
				layer.msg(data.msg, {time: 5000, icon:5});
			}
		},
		error : function(data, status, e) {
			$("body").unblock({});
		}
	});
}