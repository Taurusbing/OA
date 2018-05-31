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
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <style>
    .all{
	  	margin:20px
	  }
	 .top{
		width: 300px;
		background: cadetblue;
		color: white;
		border-radius: 3px;
		font-size:18px;
		padding:3px;
	}
  </style>
</head>
<body>

	<div class="all">
		<div class="top">点击下面表格中的列，添加学生成绩</div>
		<table class="layui-hide" id="test" lay-filter="demoEvent"></table>
	</div>


<script src="../js/jquery-3.3.1.min.js" charset="utf-8"></script>         
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
layui.use('table', function(){
  var table = layui.table; 
  
   table.render({
    elem: '#test'
    ,height: 313
    ,width: 1000 
    ,url:'showScore'
    ,method:'post'
    ,cols: [[
      {field:'id', width:100, title: 'ID', sort: true}
      ,{field:'userName', width:100, title: '学生名'}
      ,{field:'one', title: '第一阶段',event: 'setSign',width:100,sort: true, style:'cursor: pointer;'}
      ,{field:'two', width:100,event: 'setSign2',title: '第二阶段', sort: true,style:'cursor: pointer;'}
      ,{field:'three', width:100,event: 'setSign3', title: '第三阶段',minWidth: 150, sort: true,style:'cursor: pointer;'}
    ]]
    ,page: true
  });
  //监听单元格事件
  table.on('tool(demoEvent)', function(obj){
    var data = obj.data;
    if(obj.event === 'setSign'){
      layer.prompt({
        formType: 2
        ,title: '添加 ['+ data.userName +'] 的成绩'
        ,value: data.one
      }, function(value, index){
          $.post('scorein',{'score':value,'type':1,'id':data.id},function(d){
          	
          })
        layer.close(index);

        //这里一般是发送修改的Ajax请求
        
        //同步更新表格和缓存对应的值
        obj.update({
          one: value
        });
      });
    }
    
    if(obj.event === 'setSign2'){
      layer.prompt({
        formType: 2
        ,title: '添加 ['+ data.userName +'] 的成绩'
        ,value: data.two
      }, function(value, index){
        layer.close(index);
        $.post('scorein',{'score':value,'type':2,'id':data.id},function(d){
          	
        })
        //这里一般是发送修改的Ajax请求
        
        //同步更新表格和缓存对应的值
        obj.update({
          two: value
        });
      });
    }
    
    if(obj.event === 'setSign3'){
      layer.prompt({
        formType: 2
        ,title: '添加 ['+ data.userName +'] 的成绩'
        ,value: data.three
      }, function(value, index){
        layer.close(index);
        $.post('scorein',{'score':value,'type':3,'id':data.id},function(d){
          	
        })
        //这里一般是发送修改的Ajax请求
        
        //同步更新表格和缓存对应的值
        obj.update({
          three: value
        });
      });
    }
  });
});
</script>

</body>
</html>