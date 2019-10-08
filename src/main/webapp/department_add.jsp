<%@ page import="com.jc.entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/1
  Time: 20:11
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
                    <span class="x-red">*</span>部门编码</label>
                <div class="layui-input-inline">
                    <input type="text"  name="depNo" required="" value="<c:if test="${type=='edit'}">${dep.depNo}</c:if>" autocomplete="off" class="layui-input">
                </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>部门名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="depName" required="" value="<c:if test="${type=='edit'}">${dep.depName}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    部门负责人</label>
                <div class="layui-input-inline">
                    <select name="depLeader" lay-verify="required" >
                        <c:forEach items="${empName}" var="list">
                            <option value="${list}" <c:if test="${type=='edit'&&list==dep.depLeader}">selected="selected"</c:if>>${list}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    部门职责</label>
                <div class="layui-input-inline">
                    <input type="text" name="depDuty" required="" value="<c:if test="${type=='edit'}">${dep.depDuty}</c:if>" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    上级部门</label>
                <div class="layui-input-inline">
                    <input type="text" name="depHigher" required="" value="<c:if test="${type=='edit'}">${dep.depHigher}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" name="empDesc" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-filter="add" lay-submit="">保存</button></div></div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer','jquery'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //监听提交
        form.on('submit(add)',
            function(data) {
            if (<%=request.getAttribute("type").equals("add")%>){
                $.ajax({
                    type:'post',
                    url:'/dep/add',
                    data:{
                        depNo:data.field.depNo,
                        depName:data.field.depName,
                        depLeader:data.field.depLeader,
                        depDuty:data.field.depDuty,
                        depHigher:data.field.depHigher
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
                        url:'/dep/update',
                        data:{
                            depId:<%=((Department)request.getAttribute("dep")).getDepId()%>,
                            depNo:data.field.depNo,
                            depName:data.field.depName,
                            depLeader:data.field.depLeader,
                            depDuty:data.field.depDuty,
                            depHigher:data.field.depHigher
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
