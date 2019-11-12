<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>注册</title>
  <link rel="stylesheet" href="static/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
	  <div class="layui-header">
	    <div class="layui-logo">注 册</div>
	    <ul class="layui-nav layui-layout-left">
	      <li class="layui-nav-item"><a href="index.jsp">主页</a></li>
	      <li class="layui-nav-item"><a href="http://www.programminglife.cn">前往博客</a></li>
	      <li class="layui-nav-item">
	        <a href="javascript:;">在线工具</a>
	        <dl class="layui-nav-child">
	          <dd><a href="https://smallpdf.com/cn/pdf-to-word" target="_blank">PDF转换器</a></dd>
	          <dd><a href="https://cli.im/" target="_blank">二维码生成</a></dd>
	          <dd><a href="https://www.moakt.com/" target="_blank">临时邮箱</a></dd>
	          <dd><a href="https://cn.office-converter.com/" target="_blank">在线文件转换</a></dd>
	          <dd><a href="https://www.kuaidi100.com/" target="_blank">快递查询</a></dd>
	        </dl>
	      </li>
	    </ul>

      	<ul class="layui-nav layui-layout-right">
      		<li class="layui-nav-item"><a href="tologin">登录</a></li>
      	</ul>
  </div>

  <div class="layui-side layui-bg-black" style="text-align:center;color:white;">
    <img src="static/images/welcome.jpg" width="65%" height="20%" style="margin-top: 60%;">
	<p style="padding-top: 5%;">游客，您好!</p>
	<p>欢迎来到主页</p>
  </div>

  <div class="layui-body" style="background-image: url(static/images/bg.png)">
  	<div style="width:50%;height:87%;background-color: white;margin:3% auto;position: relative;">
  		<div style="position:absolute; left:10%;top:5%;height:94%;width:94%;">
  			<form class="layui-form" action="doregis" method="post">
			  <div class="layui-form-item">
			    <label class="layui-form-label">昵&nbsp;&nbsp;&nbsp;&nbsp;称</label>
			    <div class="layui-input-inline">
			      <input type="text" name="nickname" required  lay-verify="nickname" placeholder="请输入昵称" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">用户名</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="text" name="username" required lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="password" name="password" required lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="sex" value="男" title="男" checked>
			      <input type="radio" name="sex" value="女" title="女">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">生&nbsp;&nbsp;&nbsp;&nbsp;日</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="text" class="layui-input" name="birthday" id="birth" placeholder="yyyy-MM-dd" lay-verify="date">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">号&nbsp;&nbsp;&nbsp;&nbsp;码</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="text" name="phone" required lay-verify="phone" placeholder="请输入号码" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="text" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">地&nbsp;&nbsp;&nbsp;&nbsp;址</label>
			    <div class="layui-input-inline" style="width:70%;">
			      <input type="text" name="address" required lay-verify="address" placeholder="请输入地址" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即注册</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
			</form>
			<div style="position: absolute;right:8%;">已有账号？前往<a href="tologin"><font color="blue">登录</font></a></div>
  		</div>
  	</div>
  </div>

  <div class="layui-footer">
    © www.programminglife.cn
  </div>
</div>
<script src="static/layui.js"></script>
<script>
	//JavaScript代码区域
	layui.use('element', function(){
	  var element = layui.element;

	});

	//加载laydate
	layui.use('laydate', function(){
	  var laydate = layui.laydate;

	  //执行一个laydate实例
	  laydate.render({
	    elem: '#birth' //指定元素
	  });
	});

	layui.use('layer', function(){
	  var layer = layui.layer;
	  var regis_msg = '${regis_msg}';
	  if(regis_msg!=null&&regis_msg!=""){
		  layer.msg(regis_msg);
	  }
	});

	//Demo
	layui.use('form', function(){
	  var form = layui.form;

  	form.verify({
	  username: function(value, item){ //value：表单的值、item：表单的DOM对象
	    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
	      return '用户名不能有特殊字符';
	    }
	  }

	  //我们既支持上述函数式的方式，也支持下述数组的形式
	  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
	  ,username: [
	    /^[\S]{2,20}$/
	    ,'用户名必须2到20位，且不能出现空格'
	  ]
	  ,pass: [
	    /^[\S]{6,30}$/
	    ,'密码必须6到30位，且不能出现空格'
	  ]
	  ,nickname: [
	    /^[\S]{2,8}$/
	    ,'昵称必须2到8位，且不能出现空格'
	  ]
		,address: [
			/^[\S]{6,30}$/
			,'地址必须6到30位，且不能出现空格'
		]
	});

	//监听提交
	form.on('submit(formDemo)', function(data){
   		//layer.msg(JSON.stringify(data.field));
   		form.submit();
   		return false;
		});
	});
</script>
</body>
</html>