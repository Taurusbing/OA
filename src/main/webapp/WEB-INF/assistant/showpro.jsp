<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<style>
			.content{
				margin-left: 110px;
				padding: 10px 0;
				margin-top: 10px;
				margin-bottom: 10px;
				width: 969px;
				background: rgba(242, 242, 242,0.5);
			}
			p{
				margin: 5px 20px;
			}
			.p1{
				font-size: 16px;
			}
			.p2{
				font-size: 25px;
				font-weight: 600;
				color: #00b386;
			}
			.p3{
				font-size: 20px;
				margin-bottom: 20px;
			}
		</style>
</head>
<body>
		<div class="write" style="display: none;">
			<div class="content">
				<p class="p1"></p>
				<p class="p4"></p>
				<p class="p2"></p>
				<p class="p3"></p>
			</div>
			
			<form action="write" method="get">
				<input type="hidden" name="proId" id="inp" value="">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label" style="font-size: 20px; color: #00b386;">解答</label>
					<div class="layui-input-block" style="margin-right: 50px;">
						<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button id="area" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	<div style="margin-bottom: 5px;">

		<!-- 示例-970 -->
		<ins class="adsbygoogle"
			style="display: inline-block; width: 970px; height: 90px"
			data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

	</div>

	<div class="layui-btn-group demoTable">
		<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
		<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
		<button class="layui-btn" data-type="isAll">验证是否全选</button>
	</div>

	<table class="layui-table"
		lay-data="{width: 1100, height:480, url:'problem',method:'post', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
				<th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
				<th lay-data="{field:'name', width:100}">问题标题</th>
				<th lay-data="{field:'content', width:160, sort: true}">问题内容</th>
				<th lay-data="{field:'que_date', width:160}">问题发布时间</th>
				<th lay-data="{field:'studentName', width:100}">提问学生</th>
				<th lay-data="{field:'is_finish', width:100,templet: '#is_finish'}">解答状态</th>
				<th lay-data="{field:'answer', width:160}">问题答案</th>
				<th lay-data="{field:'adminName', width:100, sort: true}">解答人</th>
				<th
					lay-data="{fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}"></th>
			</tr>
		</thead>
	</table>
	
	<script type="text/html" id="is_finish">
		{{#  if(d.is_finish=== 1){ }}
    		已解答
  		{{#  } }} 
		{{#  if(d.is_finish=== 0){ }}
    		<b style="color:red">未解答</b>
  		{{#  } }}
	</script>
	
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
		{{#  if(d.is_finish=== 1){ }}
    		<a class="layui-btn layui-btn-xs layui-btn-disabled">解答</a>
  		{{#  } }} 
		{{#  if(d.is_finish=== 0){ }}
    		<a class="layui-btn layui-btn-xs" lay-event="edit">解答</a>
  		{{#  } }} 
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script src="../js/jquery-3.3.1.min.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
    console.log($(".ans")[0])
		layui.use([ 'form', 'layer', 'layedit','laydate', 'table', 'laytpl' ],
				function() {
			var form = layui.form, layedit = layui.layedit,layer = parent.layer === undefined ? layui.layer
					: top.layer, $ = layui.jquery, laydate = layui.laydate, laytpl = layui.laytpl, table = layui.table;
			 //日期
	        laydate.render({
	            elem: '#date'
	        });
	        laydate.render({
	            elem: '#date1'
	        });

	        //创建一个编辑器
	        var editIndex = layedit.build('LAY_demo_editor');

	        //自定义验证规则
	        form.verify({
	            title: function(value) {
	                if (value.length < 5) {
	                    return '标题至少得5个字符啊';
	                }
	            },
	            pass: [/(.+){6,12}$/, '密码必须6到12位'],
	            content: function(value) {
	                layedit.sync(editIndex);
	            }
	        });

	        //监听指定开关
	        form.on('switch(switchTest)', function(data) {
	            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
	                offset: '6px'
	            });
	            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
	        });

	        //监听提交
/* 	        form.on('submit(demo1)', function(obj) {
	        	alert(obj.data);
	            layer.alert(JSON.stringify(data), {
	                title: '最终的提交信息'
	            })
	            return false;
	        });  */
			
			$("#area").click(function(){
				$("form").submit();
				
			})
			$("form").submit(function(e){
				return true;
			})
			//监听表格复选框选择
			table.on('checkbox(demo)', function(obj) {
				console.log(obj)
			}); 
			//监听工具条
			table.on('tool(demo)', function(obj) {
				var data = obj.data;
				if (obj.event === 'detail') {
					layer.msg('ID：' + data.id + ' 的查看操作');
				} else if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						$.post('prodel',{"id":data.id},function(d){
				        	  
				         })
						obj.del();
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					/* layer.alert('编辑行：<br>'+ JSON.stringify(data)) */
					addNews(data);
				}
			});

			function addNews(data) {
				var index = layui.layer.open({
							title : "助教解答",
							type : 1,
							content : $(".write"),
							success : function(layero, index) {
								var body = layui.layer.getChildFrame('body',index);
								setTimeout(
										function() {
											 $(".p1").text(data.studentName);
											 $(".p4").text(data.que_date);
											 $(".p2").text(data.name);
											 $(".p3").text(data.content);
											 $("#inp").attr("value",data.id)
											layui.layer.tips(
															'点击此处返回问题列表',
															'.layui-layer-setwin .layui-layer-close',
															{
																tips : 3
															});
										}, 500)
							}
						})
				layui.layer.full(index);
				//改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
				$(window).on("resize", function() {
					layui.layer.full(index);
				})
			}

			var $ = layui.$, active = {
				getCheckData : function() { //获取选中数据
					var checkStatus = table
							.checkStatus('idTest'), data = checkStatus.data;
					layer.alert(JSON.stringify(data));
				},
				getCheckLength : function() { //获取选中数目
					var checkStatus = table
							.checkStatus('idTest'), data = checkStatus.data;
					layer.msg('选中了：' + data.length + ' 个');
				},
				isAll : function() { //验证是否全选
					var checkStatus = table
							.checkStatus('idTest');
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