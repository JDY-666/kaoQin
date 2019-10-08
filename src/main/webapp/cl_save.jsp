<%@ page import="com.jc.entity.Classes" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/3
  Time: 16:01
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
                    <span class="x-red">*</span>班次编码</label>
                <div class="layui-input-inline">
                    <input type="text"  name="clNo" required="" value="<c:if test="${type=='edit'}">${classes.clNo}</c:if>" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>班次名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="clName" required="" value="<c:if test="${type=='edit'}">${classes.clName}</c:if>" autocomplete="off" class="layui-input"></div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">上班时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="clMorning" id="clMorning" value="<c:if test="${type=='edit'}">${classes.clMorning}</c:if>"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">下班时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="clEvening" id="clEvening" value="<c:if test="${type=='edit'}">${classes.clEvening}</c:if>" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="add" lay-submit="">保存</button></div></div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer','jquery', 'laydate'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate;
        laydate.render({
            elem: '#clMorning',
            type: 'time'
        });
        laydate.render({
            elem: '#clEvening',
            type: 'time'
        });
        //监听提交
        form.on('submit(add)',
            function(data) {
                if (<%=request.getAttribute("type").equals("add")%>){
                    console.log(data.field)
                    $.ajax({
                        type:'post',
                        url:'/cl/add',
                        data:{
                            clNo:data.field.clNo,
                            clName:data.field.clName,
                            clMorning:data.field.clMorning,
                            clEvening:data.field.clEvening,

                        },
                        dataType: 'json',
                        success:function (data) {
                            if (data.code == 0 ){
                                //关闭当前frame
                                xadmin.close();
                                //可以对父窗口进行刷新
                                xadmin.father_reload();
                            } else {
                                layer.msg('添加失败');
                            }
                        }
                    });
                }else if (<%=request.getAttribute("type").equals("edit")%>){
                    $.ajax({
                        type:'post',
                        url:'/cl/update',
                        data:{
                            clId:<%=((Classes)request.getAttribute("classes")).getClId()%>,
                            clNo:data.field.clNo,
                            clName:data.field.clName,
                            clMorning:data.field.clMorning,
                            clEvening:data.field.clEvening,
                        },
                        dataType: 'json',
                        success:function (data) {
                            if (data.code == 0 ){
                                //关闭当前frame
                                xadmin.close();
                                //可以对父窗口进行刷新
                                xadmin.father_reload();
                            } else {
                                layer.msg('添加失败');
                            }
                        }
                    });
                }
                return false;
            });

    });
</script>
</body>

</html>
