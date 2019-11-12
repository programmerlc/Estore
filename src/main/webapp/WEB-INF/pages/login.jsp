<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>登录</title>
  <link rel="stylesheet" href="static/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
	  <div class="layui-header">
	    <div class="layui-logo">登 录</div>
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
      		<li class="layui-nav-item"><a href="toregis">注册</a></li>
      	</ul>
	  </div>

  <div class="layui-side layui-bg-black" style="text-align:center;color:white;">
    <img src="static/images/welcome.jpg" width="65%" height="20%" style="margin-top: 60%;">
	<p style="padding-top: 5%;">游客，您好!</p>
	<p>欢迎来到登录页</p>
  </div>

  <div class="layui-body" style="background-image: url(static/images/bg.png)">
    <div style="width:30%;height:55%;margin:10% auto;background-color: white;position: relative;">
    	<div style="width:90%;height:90%;position: absolute;top: 17%;left:3%;right:5%;">
    		<form class="layui-form" action="dologin" method="post">
			  <div class="layui-form-item">
			    <label class="layui-form-label">用户名</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="text" name="username" required  lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <br>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
			    <div class="layui-input-inline" style="width:60%;">
			      <input type="password" name="password" required lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
			    </div>
			  </div>
	      	  <div style="display: inline;left:14%;position:relative;">
	      		  <input type="checkbox" name="switch_value">
	      		  <label>十天内免登录</label>
	      	  </div>
			  <br><br>
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即登录</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
			</form>
			<br>
			<div style="text-align: right;">没有账号？前往<a href="toregis"><font color="blue">注册</font></a></div>
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
	  	});

	  	//监听提交
	  	form.on('submit(formDemo)', function(data){
	    	//layer.msg(JSON.stringify(data.field));
	    	form.submit();
	    	return false;
	  	});
  	});

	layui.use('layer', function(){
	  var layer = layui.layer;
	  var login_msg = '${login_msg}';
	  if(login_msg!=null&&login_msg!=""){
		  layer.msg(login_msg);
	  }
	});

	layui.use('element', function(){
	  var element = layui.element;

	});
</script>
</body>
</html>