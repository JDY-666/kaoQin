<%@ page import="com.jc.entity.Department" %>
<%@ page import="com.jc.entity.Station" %><%--
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
                    <span class="x-red">*</span>岗位编码</label>
                <div class="layui-input-inline">
                    <input type="text"  name="staNo" required="" value="<c:if test="${type=='edit'}">${station.staNo}</c:if>" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>岗位名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="staName" required="" value="<c:if test="${type=='edit'}">${station.staName}</c:if>" autocomplete="off" class="layui-input"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        所在部门</label>
                    <div class="layui-input-inline">
                        <select name="depId" lay-verify="required" >
                            <c:forEach items="${dep}" var="list">
                                <option value="${list.depId}" <c:if test="${type=='edit'&&list.depId==station.depId}">selected="selected"</c:if>>${list.depName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        直接上级</label>
                    <div class="layui-input-inline">
                        <select name="staSuperior" lay-verify="required" >
                            <c:forEach items="${sta}" var="list">
                                <option value="${list.staNo}" <c:if test="${type=='edit'&&list.staNo==station.staSuperior}">selected="selected"</c:if>>${list.staNo}-${list.staName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        岗位类别</label>
                    <div class="layui-input-inline">
                        <select name="staCategory" lay-verify="required">
                            <option value="管理类" <c:if test="${type=='edit'&&station.staCategory=='管理类'}">selected="selected"</c:if>>管理类</option>
                            <option value="技术类" <c:if test="${type=='edit'&&station.staCategory=='技术类'}">selected="selected"</c:if>>技术类</option>
                            <option value="文职类" <c:if test="${type=='edit'&&station.staCategory=='文职类'}">selected="selected"</c:if>>文职类</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">岗位职责</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" name="staDesc" class="layui-textarea"><c:if test="${type=='edit'}">${station.staDesc}</c:if></textarea>
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
                        url:'/sta/add',
                        data:{
                            staNo:data.field.staNo,
                            staName:data.field.staName,
                            depId:data.field.depId,
                            staSuperior:data.field.staSuperior,
                            staCategory:data.field.staCategory,
                            staDesc:data.field.staDesc
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
                        url:'/sta/update',
                        data:{
                            staId:<%=((Station)request.getAttribute("station")).getStaId()%>,
                            staNo:data.field.staNo,
                            staName:data.field.staName,
                            depId:data.field.depId,
                            staSuperior:data.field.staSuperior,
                            staCategory:data.field.staCategory,
                            staDesc:data.field.staDesc
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
