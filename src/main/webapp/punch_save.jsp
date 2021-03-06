<%@ page import="java.util.Date" %>
<%@ page import="com.jc.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/3
  Time: 22:11
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
                    <span class="x-red">*</span>打卡人</label>
                <div class="layui-input-inline">
                    <input type="text"  name="punchName" readonly value="${employee.empName}" autocomplete="off" class="layui-input">
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">打卡时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="punchDate" id="punchDate" <c:if test="${type=='edit'}">value="${punchCard.punchDate}"</c:if> autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <textarea name="punchText" <c:if test="${type=='edit'}">readonly</c:if> class="layui-textarea" ><c:if test="${type=='edit'}">${punchCard.punchText}</c:if></textarea>
                    </div>
                </div>
                <c:if test="${type=='add'}">
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-filter="add" lay-submit="">保存</button>
                    </div>
                </c:if>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer','jquery', 'laydate','util'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate,
            util = layui.util;
        if (!<%=request.getAttribute("type").equals("edit")%>){
            laydate.render({
                elem: '#punchDate',
                type: 'datetime',
                min: util.toDateString(new Date(), 'yyyy-MM-dd HH:mm:00')
            });
        }

        //监听提交
        form.on('submit(add)',
            function(data) {
                if (<%=request.getAttribute("type").equals("add")%>){
                    $.ajax({
                        type:'post',
                        url:'/punch/add',
                        data:{
                            punchNo:'<%=((Employee)request.getAttribute("employee")).getEmpNo()%>',
                            punchName:data.field.punchName,
                            punchDate:data.field.punchDate,
                            punchText:data.field.punchText
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

