<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<title>layui</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	</head>

	<body>
		<div class="layui-upload">
			<button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
			<button type="button" class="layui-btn" id="test9">开始上传</button>
		</div>
		<table class="layui-table" lay-data="{width: 892, height:332, url:'seefile',method:'post', page:true, id:'idTest'}" lay-filter="demo">
			<thead>
				<tr>
					<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
					<th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
					<th lay-data="{field:'filename', width:500}">文件名</th>
					<th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
				</tr>
			</thead>
		</table>
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		<script src="../layui/layui.js" charset="utf-8"></script>
		<script>
			layui.use('upload', function() {
				var $ = layui.jquery,
					upload = layui.upload;
				//选完文件后不自动上传
				upload.render({
					elem: '#test8',
					url: 'fileup',
					auto: false,
						//,multiple: true
					method:'post',
					accept: 'file',
					bindAction: '#test9',
/* 					done: function(res) {
						console.log("123")
						console.log(res)
					} */
					error:function(res){
						layer.msg('上传成功,请刷新页面', {time: 5000, icon:6});
					} 
				});
			});
			layui.use('table', function() {
				var table = layui.table;
				//监听表格复选框选择
				table.on('checkbox(demo)', function(obj) {
					console.log(obj)
				});
				//监听工具条
				table.on('tool(demo)', function(obj) {
					var data = obj.data;
					if(obj.event === 'detail') {
						layer.msg('ID：' + data.id + ' 的查看操作');
					} else if(obj.event === 'del') {
						layer.confirm('真的删除行么', function(index) {
							obj.del();
							layer.close(index);
						});
					} else if(obj.event === 'edit') {
						layer.alert('编辑行：<br>' + JSON.stringify(data))
					}
				});

				var $ = layui.$,
					active = {
						getCheckData: function() { //获取选中数据
							var checkStatus = table.checkStatus('idTest'),
								data = checkStatus.data;
							layer.alert(JSON.stringify(data));
						},
						getCheckLength: function() { //获取选中数目
							var checkStatus = table.checkStatus('idTest'),
								data = checkStatus.data;
							layer.msg('选中了：' + data.length + ' 个');
						},
						isAll: function() { //验证是否全选
							var checkStatus = table.checkStatus('idTest');
							layer.msg(checkStatus.isAll ? '全选' : '未全选')
						}
					};

				$('.demoTable .layui-btn').on('click', function() {
					var type = $(this).data('type');
					active[type] ? active[type].call(this) : '';
				});
			});
		</script>
	</body>

</html>