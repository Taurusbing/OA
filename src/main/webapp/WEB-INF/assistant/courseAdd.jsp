<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>

<body>
	<form action="putCourse" method="get" class="layui-form layui-form-pane ">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 30px;">
			<legend>课程推送</legend>
		</fieldset>
		<input type="hidden" name="adminId" id="adminId" value=1>
		<div class="layui-form layui-form-item"
			style="margin-left: 20px; margin-right: 20px;">
			<label class="layui-form-label">课程名</label>
			<div class="layui-input-block">
				<input type="text" name="courseName" id="courseName" autocomplete="off"
					placeholder="请输入课程名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text"
			style="margin-left: 20px; margin-right: 20px;">
			<label class="layui-form-label">课程描述</label>
			<div class="layui-input-block">
				<textarea  placeholder="请输入课程描述" id="coment" name="coment" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-upload-drag" id="test10" style="margin-left: 20px;">
			<i class="layui-icon"></i>
			<p>点击上传，或将文件拖拽到此处</p>
		</div>
		<div class="layui-form-item"
			style="margin-left: 20px; margin-top: 20px;">
			<button id="btn" class="layui-btn" lay-submit="" lay-filter="demo2">立即发布</button>
		</div>
	</form>
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use('upload', function() {
			var $ = layui.jquery, upload = layui.upload;
			//拖拽上传
			upload.render({
				elem : '#test10',
				url : 'upload',
				accept: 'file',
/*   			done : function(res) {
				}  */
 				error:function(res){
					layer.msg('上传成功,请发布课程', {time: 5000, icon:6});
				} 
			});
		});
		$("#btn").click(function() {
			$("form").submit();
		})
 		$("form").submit(function(e) {
			return true;
		}) 
	</script>
</body>

</html>