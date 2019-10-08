<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/4
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>新增</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/xadmin.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->

</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>员工编码</label>
                <div class="layui-input-inline">
                    <input type="text"  name="staNo" readonly value="${reportDetail.reportNo}" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>员工名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="staName" readonly value="${reportDetail.reportName}" autocomplete="off" class="layui-input"></div>
                </div>


                <div class="layui-inline">
                    <label class="layui-form-label">上午上班时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="punchDate" readonly value="${reportDetail.reportMorning}"autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">下午下班时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="punchDate" readonly value="${reportDetail.reportEvening}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">出勤情况</label>
                    <div class="layui-input-inline">
                        <input type="text" name="punchDate" readonly value="${reportDetail.reportStatus}" autocomplete="off" class="layui-input">
                    </div>
                </div>
             </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer','jquery'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;



    });
</script>
</body>

</html>

