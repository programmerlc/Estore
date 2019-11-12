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
    <title>结算</title>
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
        <c:set var="login_user" value="${sessionScope.user}" scope="page"/>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${login_user.headerpic_url}" class="layui-nav-img">
                        ${login_user.nickname}
                </a>
            </li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black left-side" >
        <img src="${login_user.headerpic_url}" width="65%" height="20%" style="margin-top: 45%;">
        <p style="margin-top: 5%;">${login_user.nickname}，您好!</p>
        <p>欢迎来到订单结算页</p>
        <p style="margin-top: 5%;">用户名：${login_user.username}</p>
        <a href="myorder" class="layui-btn" style="margin-top: 5%;">我的订单</a>
        <a href="#" class="layui-btn" style="margin: 5% auto;">我的购物车</a>
    </div>

    <div class="layui-body" style="background-image: url(static/images/bg.png)">
        <c:set var="orderItems" value="${requestScope.orderItems}" scope="page"/>
        <c:if test="${empty orderItems}">
            <div style="margin:0% auto;width:80%">
                <div style="line-height:150px;margin:20% auto;width:40%;height:150px;background-color: #c2c2c2;">
                    <h1 style="text-align: center;">当前没有任何商品可以结算</h1>
                </div>
            </div>
        </c:if>

        <c:if test="${not empty orderItems}">
        <div style="margin:6% 7%;width:80%">
            <form action="order" class="layui-form" method="post" id="form">
                <div class="layui-container">
                    <div class="layui-row">
                        <c:forEach var="orderItem" items="${orderItems}" varStatus="status">
                            <div class="layui-col-md3" style="height: 230px;text-align: center;">
                                <img src="${orderItem.key.img_url}" width="80%" height="100%">
                            </div>
                            <div class="layui-col-md9" style="height: 230px;position: relative;">
                                <div style="margin: 0 auto;width: 95%;">
                                    <p style="font-size: large;">${orderItem.key.description}</p>
                                    <div style="color: red;width: 30%;height: 50px;line-height: 50px;">
                                        <font class="product_price" size="6px" id="price${status.count}">￥${orderItem.key.price}</font>
                                    </div>
                                    <div style="position: absolute;right: 20px;bottom: 70px;width: 28%;height: 50px;line-height: 50px;">
                                        <font size="4px">x${orderItem.value}</font>
                                    </div>
                                </div>
                            </div>
                         </c:forEach>
                    </div>
                </div>
                <div style="height: 300px;">
                    <div style="float: left;height: 100%;width: 50%;">
                        <div style="margin:8% 3%;width: 80%;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">收货人姓名</label>
                                <div class="layui-input-block">
                                    <input type="text" name="name" required  lay-verify="required" placeholder="请输入收货人姓名" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">收货人电话</label>
                                <div class="layui-input-block">
                                    <input type="text" name="phone" required  lay-verify="phone" placeholder="请输入收货人电话" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">收货人地址</label>
                                <div class="layui-input-block">
                                    <input type="text" name="address" required  lay-verify="required" placeholder="请输入收货人地址" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="height: 100%;width: 50%;margin-top: 20px;padding-top: 50px;text-align: right;float: right;">
                        <div>
                            订单总价：<font color="red" size="6px">￥${requestScope.sumprice}</font>
                        </div>
                        <div style="margin-top: 30px;">
                            <button type="button" class="layui-btn layui-btn-danger" onclick="addToOrder()">确认下单</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        </c:if>
    </div>

    <div class="layui-footer">
        © www.programminglife.cn
    </div>
</div>
<script src="static/layui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

    var layer;
    layui.use('layer',function () {
        layer = layui.layer;
    });

    layui.use('form', function(){
        var form = layui.form;

        form.verify({
            name: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '姓名不能有特殊字符';
                }
            }
            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,name: [
                /^[\S]{2,4}$/
                ,'姓名必须2到4位，且不能出现空格'
            ]
            ,address: [
                /^[\S]{6,30}$/
                ,'地址必须6到30位，且不能出现空格'
            ]
        });

    });
</script>
</body>
</html>
