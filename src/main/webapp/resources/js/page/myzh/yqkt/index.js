var grid;// 表格
var layerObj;// 弹出窗体

$(function () {
    initButton();
    initDataGrid();
});

/**
 * 初始化按钮
 */
function initButton() {
	/** --新增按钮-- */
	$("#add-btn").on("click", function () {
		window.location.href =  Util.getRootPath() + "/myzh/yqkt/toAdd/0";
	});
	
	/** --修改按钮-- */
	$("#edit-btn").on("click", function () {
		var datas = getGrid().getCheckedRecords();
		if (datas.length <= 0) {
			top.layer.msg("请至少选择一条数据", {time: 2000, icon: 5});
		} else if (datas.length > 1) {
			top.layer.msg("只能选择一条数据", {time: 2000, icon: 5});
		} else {
			window.location.href = Util.getRootPath() + "/myzh/yqkt/toAdd/" + datas[0].id;
		}
	});
	
	// 活动页大图
    $("#img-btn").on("click", function () {
		layerObj = top.layer.open({
			title: "头部大图修改",
			type: 2,
			area: ['600px', '300px'],
			content: [Util.getRootPath() + '/myzh/yqkt/editImg', 'no'],
			closeBtn: 1
		});
    });

    /** --查询按钮-- */
    $(".searchBtn").on("click", function () {
        grid.parameters = getParameters();
        grid.refresh(true);
    });
}

/**
 * 初始化表格
 */
function initDataGrid() {
    grid = Util.createTable({
        loadURL: Util.getRootPath() + "/myzh/yqkt/list",
        ajaxLoad: true,
        gridContainer: 'tableDiv',
        toolbarContainer: 'pagingDiv',
        onGridComplete: function (grid) {
            // 重置iframe高度
            $(window.parent.document).find("iframe").height("");
            $(window.parent.document).find("iframe").height(document.body.offsetHeight + 70);
        },
        columns: [
            {
                id: 'title',
                title: '<b>标题</b>',
                type: "string",
                columnClass: 'text-left',
                resolution: function (value, record, column, grid, dataNo, columnNo) {
	                return Util.substringVal(value);
	            }
            },
            {
                id: 'activeDt',
                title: '<b>活动时间</b>',
                type: 'date',
                format: 'yyyy-MM-dd',
                columnClass: 'text-center'
            }
        ]
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
    	title: $.trim($("input[name='title']").val())
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
