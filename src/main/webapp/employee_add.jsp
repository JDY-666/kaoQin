<%--
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
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>员工编码</label>
                <div class="layui-input-inline">
                    <input type="text"  name="empNo" required="" value="<c:if test="${type=='edit'}">${emp.empNo}</c:if>" lay-verify="empNo" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入名</div></div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="empName" required="" value="<c:if test="${type=='edit'}">${emp.empName}</c:if>" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-block">
                    <input type="radio" name="empSex" value="男" title="男" <c:if test="${type=='edit'&&emp.empSex=='男'}">checked</c:if>>
                    <input type="radio" name="empSex" value="女" title="女" <c:if test="${type=='edit'&&emp.empSex=='女'}">checked</c:if>>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>年龄</label>
                <div class="layui-input-inline">
                    <input type="text" name="empAge" required="" value="<c:if test="${type=='edit'}">${emp.empAge}</c:if>" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>民族</label>
                <div class="layui-input-inline">
                    <input type="text" name="empNation" required="" value="<c:if test="${type=='edit'}">${emp.empNation}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>身份证</label>
                <div class="layui-input-inline">
                    <input type="text" name="empIdentity" required="" value="<c:if test="${type=='edit'}">${emp.empIdentity}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    薪水</label>
                <div class="layui-input-inline">
                    <input type="text" name="empSalary" value="<c:if test="${type=='edit'}">${emp.empSalary}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="empPhone" required="" value="<c:if test="${type=='edit'}">${emp.empPhone}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>紧急联系人</label>
                <div class="layui-input-inline">
                    <input type="text" name="emergency" required="" value="<c:if test="${type=='edit'}">${emp.emergencyName}</c:if>" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    岗位</label>
                <div class="layui-input-inline">
                    <select name="staSuperior" lay-verify="required" >
                        <c:forEach items="${sta}" var="list">
                            <option value="${list.staNo}" <c:if test="${type=='edit'&&list.staNo==emp.empSta}">selected="selected"</c:if>>${list.staNo}-${list.staName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    班次</label>
                <div class="layui-input-inline">
                    <select name="clId" lay-verify="required" >
                        <c:forEach items="${classes}" var="list">
                            <option value="${list.clId}" <c:if test="${type=='edit'&&list.clId==emp.clId}">selected="selected"</c:if>>${list.clNo}-${list.clName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">个人描述</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" name="empDesc" class="layui-textarea"><c:if test="${type=='edit'}">${emp.empDesc}</c:if></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-filter="add" lay-submit="">增加</button></div>
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
                        url:'/emp/add',
                        data:{
                            empNo:data.field.empNo,
                            empName:data.field.empName,
                            empSex:data.field.empSex,
                            empAge:data.field.empAge,
                            empNation:data.field.empNation,
                            empIdentity:data.field.empIdentity,
                            emergencyName:data.field.emergency,
                            empSta:data.field.staSuperior,
                            empDesc:data.field.empDesc,
                            clId:data.field.clId
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
                        url:'/emp/update',
                        data:{
                            empNo:data.field.empNo,
                            empName:data.field.empName,
                            empSex:data.field.empSex,
                            empAge:data.field.empAge,
                            empNation:data.field.empNation,
                            empIdentity:data.field.empIdentity,
                            emergencyName:data.field.emergency,
                            empSta:data.field.staSuperior,
                            empDesc:data.field.empDesc,
                            clId:data.field.clId
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

    });</script>
</body>

</html>
