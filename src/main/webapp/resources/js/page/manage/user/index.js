var grid;// 表格
var layerObj;// 弹出窗体

$(function() {
	
	initButton();
	initDataGrid();
});

/**
 * 初始化按钮
 */
function initButton() {

	/** --查询按钮-- */
	$(".searchBtn").on("click", function() {
		grid.parameters = getParameters();
		grid.refresh(true);
	});

	$(".addBtn").on("click", function() {
		layerObj = top.layer.open({
			title : "新增账号信息",
			type : 2,
			area : ['450px', '550px'],
			success : function() {
				
			},
			end : function() {
				$(".searchBtn").trigger("click");
			},
			content : [Util.getRootPath() + '/manage/user/add/0', 'no'],
			closeBtn : 1
		});
	});
	
	$(".editBtn").on("click", function() {
		var datas = getGrid().getCheckedRecords();
		if(datas.length == 0) {
			top.layer.msg('请选中要修改的账号', {time: 5000, icon:5});
			return;
		}
		
		if(datas.length > 1) {
			top.layer.msg('只能选中一个账号', {time: 5000, icon:5});
			return;
		}
		
		layerObj = top.layer.open({
			title : "修改账号信息",
			type : 2,
			area : ['450px', '550px'],
			success : function() {
				
			},
			end : function() {
				$(".searchBtn").trigger("click");
			},
			content : [Util.getRootPath() + '/manage/user/add/'+datas[0].id, 'no'],
			closeBtn : 1
		});
	});
	
	$(".resetBtn").on("click", function() {
		var datas = getGrid().getCheckedRecords();
		if(datas.length == 0) {
			top.layer.msg('请选中要重置密码的账号', {time: 5000, icon:5});
			return;
		}
		
		top.layer.confirm('确定重置账号密码吗？', {icon: 0, title:'提示'}, function(index){
			top.layer.close(index);
			$("body").block({message : "密码重置中，请稍候..."});
			Util.ajaxJson(Util.getRootPath() +'/manage/user/reset', datas, function(data) {
				$("body").unblock({});
				getGrid().refresh(true);
				if(data == "yes") {
					top.layer.msg('账号密码已重置', {time: 5000, icon:6});
				} else {
					top.layer.msg('账号密码重置失败', {time: 5000, icon:5});
				}
			});
		});
	});
}

/**
 * 初始化表格
 */
function initDataGrid() {
	grid = Util.createTable({
		loadURL : Util.getRootPath() + "/manage/user/list",
		ajaxLoad : true,
		gridContainer : 'tableDiv',
		toolbarContainer : 'pagingDiv',
		onGridComplete : function(grid) {
			// 重置iframe高度 
			$(window.parent.document).find("iframe").height("");
			$(window.parent.document).find("iframe").height(document.body.offsetHeight+70);
		},
		columns:[{
			id : 'user',
			title : '<b>姓名</b>',
			type : "string",
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return value.name;
			}
		},
		{
			id : 'user',
			title : '<b>性别</b>',
			type : 'string',
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return i18n["user_gender_" + value.gender];
			}
		},
		{
			id : 'user',
			title : '<b>账号</b>',
			type : "string",
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return value.username;
			}
		},
		{
			id : 'role',
			title : '<b>角色</b>',
			type : "string",
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return value.name;
			}
		},
		{
			id : 'user',
			title : '<b>手机号</b>',
			type : "string",
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return value.phone;
			}
		},
		{
            id: 'user',
            title: '<b>区域</b>',
            type: "string",
            columnClass: 'text-center',
            resolution: function (value, record, column, grid, dataNo, columnNo) {
                return value.resource.replace("重庆市/重庆市", "重庆市");
            }
        },
		{
			id : 'user',
			title : '<b>状态</b>',
			type : "string",
			columnClass : 'text-center',
			resolution : function(value, record, column, grid, dataNo, columnNo) {
				return i18n["user_status_" + value.status];
			}
		}]
	});
	grid.parameters = getParameters();
	grid.load();
}


/**
 * 获取查询参数
 * 
 * @param dtGrid
 */
function getParameters() {
	return {
		id : $.trim($("select[name='roleId']").val()),
		name : $.trim($("input[name='stuName']").val()),
		username : $.trim($("input[name='userName']").val()),
		phone : $.trim($("input[name='phone']").val()),
		status : $.trim($("select[name='status']").val())
	};
}
/**
 * 获取弹出窗体
 * 
 * @returns
 */
function getLayerIndex() {
	return layerObj;
}

/**
 * 获取表格对象
 * 
 * @returns {___anonymous_grid}
 */
function getGrid() {
	return grid;
}

function searchData() {
	grid.parameters = getParameters();
    grid.refresh(true);
}