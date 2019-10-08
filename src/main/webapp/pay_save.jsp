<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/5
  Time: 10:52
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
                    <span class="x-red">*</span>领薪人</label>
                <div class="layui-input-inline">
                    <c:if test="${type=='add'}">
                        <select name="empNo" lay-verify="required" >
                            <c:forEach items="${employees}" var="list">
                                <option value="${list.empNo}">${list.empName}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                    <c:if test="${type=='edit'}">
                    <input type="text" name="empNo" readonly value="${pay.payNo}" autocomplete="off" class="layui-input"></div>
                    </c:if>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>领薪区间</label>
                    <div class="layui-input-inline">
                        <input type="text" id="startDate" name="startDate" required="" value="<c:if test="${type=='edit'}">${pay.payStartDate}</c:if>" autocomplete="off" class="layui-input"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        </label>
                    <div class="layui-input-inline">
                        <input type="text" id="endDate" name="endDate" required="" value="<c:if test="${type=='edit'}">${pay.payEndDate}</c:if>" autocomplete="off" class="layui-input"></div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">
                        <span class="x-red">*</span>薪水</label>
                    <div class="layui-input-inline">
                        <input type="text" id="salary" name="salary" readonly value="<c:if test="${type=='edit'}">${pay.paySalary}</c:if>" autocomplete="off" class="layui-input"></div>
                </div>

                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="counts" lay-submit="">计算薪水</button>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="add" lay-submit="">保存</button>
                </div>
            </div>
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
            elem: '#startDate'
            // type: 'datetime',
            // min: util.toDateString(new Date(), 'yyyy-MM-dd HH:mm:00')
        });
        laydate.render({
            elem: '#endDate'
        });
        //监听提交
        form.on('submit(counts)',function (data) {
            $.ajax({
                type:'post',
                url:'/pay/counts',
                data:{
                    payNo:data.field.empNo,
                    payStartDate:data.field.startDate,
                    payEndDate:data.field.endDate,
                },
                dataType: 'json',
                success:function (data) {
                    if (data.code == 0 ){
                        $('#salary').val(data.data)
                    } else {
                        layer.msg('失败');
                    }
                }
            })
            return false;
        });
        form.on('submit(add)',
            function(data) {
                if (<%=request.getAttribute("type").equals("add")%>){
                    $.ajax({
                        type:'post',
                        url:'/pay/add',
                        data:{
                            payNo:data.field.empNo,
                            payStartDate:data.field.startDate,
                            payEndDate:data.field.endDate,
                            paySalary:data.field.salary
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
                        url:'/pay/update',
                        data:{
                            payNo:data.field.empNo,
                            payStartDate:data.field.startDate,
                            payEndDate:data.field.endDate,
                            paySalary:data.field.salary
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
