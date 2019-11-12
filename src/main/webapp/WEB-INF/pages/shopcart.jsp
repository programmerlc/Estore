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
    <title>购物车</title>
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
        <p>欢迎来到购物车</p>
        <p style="margin-top: 5%;">用户名：${login_user.username}</p>
        <a href="myorder" class="layui-btn" style="margin-top: 5%;">我的订单</a>
        <a href="#" class="layui-btn" style="margin: 5% auto;">我的购物车</a>
    </div>

    <div class="layui-body" style="background-image: url(static/images/bg.png)">
        <c:set var="shopcart" value="${requestScope.allShopcart}" scope="page"/>
        <c:if test="${empty shopcart}">
            <div style="margin:0% auto;width:80%">
                <div style="line-height:150px;margin:20% auto;width:40%;height:150px;background-color: #c2c2c2;">
                    <h1 style="text-align: center;">当前购物车中没有任何商品</h1>
                </div>
            </div>
        </c:if>

        <c:if test="${not empty shopcart}">
        <div style="margin:6% 7%;width:80%">
            <form action="order" method="post" id="form">
                <div class="layui-container">
                    <div class="layui-row">
                        <c:forEach var="shopinfo" items="${shopcart}" varStatus="status">
                            <div class="layui-col-md3" style="height: 230px;">
                                <div style="width: 20%;line-height: 230px;text-align: center;float: left;">
                                    <input class="choose" style="width: 20px;height: 20px;" type="checkbox" id="switch${status.count}" name="switch${status.count}"/>
                                </div>
                                <div style="width: 80%;float: left;">
                                    <img src="${shopinfo.key.img_url}" width="90%" height="95%"/>
                                </div>
                            </div>
                            <div class="layui-col-md9" style="height: 230px;position: relative;">
                                <div style="margin: 0 auto;width: 95%;">
                                    <p style="font-size: large;">${shopinfo.key.description}</p>
                                    <div style="color: red;width: 30%;height: 50px;line-height: 50px;">
                                        <font class="product_price" size="6px" id="price${status.count}">￥${shopinfo.key.price}</font>
                                    </div>
                                    <div style="position: absolute;right: 20px;bottom: 110px;width: 28%;height: 50px;line-height: 50px;">
                                        <input type="hidden" value="${shopinfo.key.id}" id="pid${status.count}">
                                        <button type="button" class="layui-btn" onclick="reduceNum(${status.count})" style="width: 5px;">-</button>
                                        <input type="button" class="layui-btn layui-btn-primary" style="width: 20px;" value="${shopinfo.value}" id="buynum${status.count}"/>
                                        <button type="button" class="layui-btn" onclick="addNum(${status.count})" style="width: 5px;">+</button>
                                    </div>
                                    <div style="position: absolute;right: 50px;bottom: 50px;width: 28%;height: 50px;line-height: 50px;">
                                        小计：<font id="proprice${status.count}" color="red" size="4px">￥${shopinfo.key.price}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="button" class="layui-btn layui-btn-warm" onclick="deleteproduct(${shopinfo.key.id})">删除本项</button>
                                    </div>
                                </div>
                            </div>
                         </c:forEach>
                    </div>
                </div>
                <div style="height: 200px;width: 100%;position: relative;">
                    <div style="position: absolute;left: 35px;top:20px;">
                        <button class="layui-btn" type="button" onclick="clearShopcart()">清空购物车</button>
                    </div>
                    <div style="line-height: 200px;float: left;margin-left: 35px;">
                        <input type="checkbox" id="allchoose" style="width: 17px;height: 17px;">
                        <font size="4px">全选</font>
                    </div>
                    <div style="line-height: 200px;text-align: right;float: right;display: inline;">
                        合计：<font size="3px" color="red" id="sumprice">￥0</font>&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="layui-btn layui-btn-danger" onclick="toOrder()">结算</button>
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

    function deleteproduct(shopid){
        $.ajax({
            dataType:"text",
            type:"post",
            url:"deleteShopcart",
            data:{shopid:shopid},
            success: function () {
                layer.msg("删除成功");
                setTimeout(function () {
                    location.reload(true);
                },3000);
            }
        });
    };

    function clearShopcart() {
        $.ajax({
            dataType:"text",
            type:"post",
            url:"clearShopcart",
            data:{user_id:${login_user.id}},
            success: function () {
                layer.msg("清空购物车成功");
                setTimeout(function () {
                    location.reload(true);
                },3000);
            }
        });
    };

    function toOrder() {
        var chooses = $("input.choose");
        var index = 0;
        for (var i=0;i<chooses.length;i++){
            if(chooses[i].checked){
                index++;
            }
        }
        if(index==0){
            layer.msg("请至少选择一项商品");
        }else{
            var data = "";
            for (var i=0;i<chooses.length;i++){
                if(chooses[i].checked){
                    data += ("pid:"+document.getElementById("pid"+(i+1)).value+" ");
                    data += ("buynum:"+document.getElementById("buynum"+(i+1)).value+" ");
                }
            }
            $.ajax({
                data:{info:data},
                type:"post",
                dataType:"text",
                url:"order",
                success: function (data) {
                    window.location.href = data;
                }
            });
        }
    }

    var allchoose = document.getElementById("allchoose");
    allchoose.onclick=function() {
        if(allchoose.checked){
            var form = document.getElementById("form");
            var checkboxs = form.querySelectorAll("input.choose");
            for (var i=0;i<checkboxs.length;i++){
                checkboxs[i].checked = true;
            }
            var prices = form.querySelectorAll("font.product_price");
            var pnums = form.querySelectorAll("input.layui-btn-primary");
            var sumprice = 0.0;
            for (var i=0;i<prices.length;i++){
                var price = prices[i].innerHTML.substring(1);
                var pnum = pnums[i].value;
                sumprice+=(parseFloat(price)*parseInt(pnum));
            }
            document.getElementById("sumprice").innerHTML = '￥'+sumprice;
        }else{
            var form = document.getElementById("form");
            var checkboxs = form.querySelectorAll("input.choose");
            for (var i=0;i<checkboxs.length;i++){
                checkboxs[i].checked = false;
            }
            document.getElementById("sumprice").innerHTML = '￥0';
        }
    };

    <c:forEach var="shopinfo" items="${shopcart}" varStatus="status">
        //var switchBtn = $("#switch${shopinfo.key.id}");
        var switchBtn = document.getElementById("switch${status.count}");
        switchBtn.onclick=function () {
            if(switchBtn.checked){
                //var before = $("#sumprice").innerHTML.substring(1);
                var before = document.getElementById("sumprice").innerHTML.substring(1);
                //var res = parseFloat(before)+(${shopinfo.key.price}*parseInt($("#buynum${status.count}").val()));
                var proprice = document.getElementById("proprice${status.count}").innerHTML.substring(1);
                var res = parseFloat(before)+parseFloat(proprice);
                //$("#sumprice").innerHTML = '￥'+res;
                document.getElementById("sumprice").innerHTML = '￥'+res;
            }else{
                //var before = $("#sumprice").innerHTML.substring(1);
                var before = document.getElementById("sumprice").innerHTML.substring(1);
                //var res = parseFloat(before)+(${shopinfo.key.price}*parseInt($("#buynum${status.count}").val()));
                var proprice = document.getElementById("proprice${status.count}").innerHTML.substring(1);
                var res = parseFloat(before)-parseFloat(proprice);
                //$("#sumprice").innerHTML = '￥'+res;
                document.getElementById("sumprice").innerHTML = '￥'+res;
            }
        };
    </c:forEach>


    function addNum(statusCount){
        <c:forEach var="shopinfo" items="${shopcart}" varStatus="status">
            if(statusCount==(${status.count})){
                var count = document.getElementById("buynum${status.count}").value;
                count = parseInt(count)+1;
                document.getElementById("buynum${status.count}").value = count;
                var price = document.getElementById("price${status.count}").innerHTML.substring(1);
                var res = parseFloat(price)*count;
                document.getElementById("proprice${status.count}").innerHTML = "￥"+res;
            }
        </c:forEach>
    };

    function reduceNum(statusCount){
        <c:forEach var="shopinfo" items="${shopcart}" varStatus="status">
            if(statusCount==(${status.count})){
                var count = document.getElementById("buynum${status.count}").value;
                if(count<=1){
                    count=1;
                }else{
                    count=parseInt(count)-1;
                }
                document.getElementById("buynum${status.count}").value = count;
                var price = document.getElementById("price${status.count}").innerHTML.substring(1);
                var res = parseFloat(price)*count;
                document.getElementById("proprice${status.count}").innerHTML = "￥"+res;
            }
        </c:forEach>
    };
</script>
</body>
</html>
