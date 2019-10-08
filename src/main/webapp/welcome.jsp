<%@ page import="com.jc.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎</title>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<script>
    var time;
    setInterval(function (args) {
        var date = new Date();
        time = date.getFullYear()+"年";
        time += date.getMonth()+1+"月";
        time += date.getDate()+"日 ";
        time += add(date.getHours()) + ":";
        time += add(date.getMinutes()) + ":";
        time += add(date.getSeconds());
        $('#times').html(time);
    }, 1000)
    function add(i){
        if(i<10){
            return "0"+i;
        }
        return i;
    }
</script>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <blockquote class="layui-elem-quote">欢迎：
                        <span class="x-red"><%=((Account)request.getSession().getAttribute("userAccount")).getUsername()%></span>! 当前时间:<i id="times"></i>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
