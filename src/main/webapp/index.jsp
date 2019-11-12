<%--
  Created by IntelliJ IDEA.
  User: programmerlc
  Date: 2019/10/10
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="cn.programminglife.bean.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="static/css/layui.css">
    <style>
        .left-side{
            text-align:center;
            color:white;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Estore</div>
        <ul class="layui-nav layui-layout-left">
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
        <c:set var="login_user" value="${sessionScope.user}"/>
        <ul class="layui-nav layui-layout-right">
        <c:if test="${login_user!=null}">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${login_user.headerpic_url}" class="layui-nav-img">
                        ${login_user.nickname}
                </a>
            </li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </c:if>

        <c:if test="${login_user==null}">
            <li class="layui-nav-item"><a href="toregis">注册</a></li>
            <li class="layui-nav-item"><a href="tologin">登录</a></li>
        </c:if>
        </ul>
    </div>

    <div class="layui-side layui-bg-black left-side" >
        <c:if test="${login_user==null}">
            <img src="static/images/welcome.jpg" width="65%" height="20%" style="margin-top: 60%;">
            <p style="padding-top: 5%;">游客，您好!</p>
            <p>欢迎来到主页</p>
        </c:if>
        <c:if test="${login_user!=null}">
            <img src="${login_user.headerpic_url}" width="65%" height="20%" style="margin-top: 45%;">
            <p style="margin-top: 5%;">${login_user.nickname}，您好!</p>
            <p>欢迎来到主页</p>
            <p style="margin-top: 5%;">用户名：${login_user.username}</p>
            <a href="myorder" class="layui-btn" style="margin-top: 5%;">我的订单</a>
            <a href="myshopcar" class="layui-btn" style="margin: 5% auto;">我的购物车</a>
        </c:if>
    </div>

    <div class="layui-body" style="background-image: url(static/images/bg.png)">
        <c:set var="allproducts" value="${applicationScope.allproducts}" scope="page"/>
        <c:if test="${empty allproducts}">
            <div style="margin:0% auto;width:80%">
                <div style="line-height:150px;margin:20% auto;width:30%;height:150px;background-color: #c2c2c2;">
                    <h1 style="text-align: center;">当前没有任何商品</h1>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty allproducts}">
            <div style="margin:5% 7%;width:80%">
                <div class="layui-container">
                    <div class="layui-row">
                        <c:forEach var="product" items="${allproducts}" varStatus="status">
                            <div class="layui-col-md2" style="height:380px;">
                                <a href="todetails?pid=${product.id}"><img src="${product.img_url}" width="100%" height="220px"/></a>
                                <div style="color:red;"><font size="5px">￥${product.price}</font></div>
                                <div><a href="todetails?pid=${product.id}" style="text-decoration:none;">${product.description}</a></div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:if>
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
</script>
</body>
</html>
