<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/3
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header ">
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" id="userName" name="userName"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <div class="layui-btn" id="search" lay-filter="search" data-type="reload"><i class="layui-icon">&#xe615;</i></div>
                    </div>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-hide" id="demo" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    function createrFormat(o){
        return o;
    }

    layui.use(['layer', 'table','form','jquery'], function(){
        var layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form = layer.form

        var $ = layui.jquery;
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/emp/list' //数据接口
            ,title: '用户表'
            ,page: true //开启分页
            ,id:'tableOne'
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'empId', title: 'ID', sort: true}
                ,{field: 'empNo', title: '员工编码'}
                ,{field: 'empName', title: '姓名', sort: true}
                ,{field: 'empSex', title: '性别'}
                ,{field: 'empAge', title: '年龄'}
                ,{field: 'empNation', title: '民族'}
                ,{field: 'station', templet: '<div>{{createrFormat(d.station.staName)}}</div>',title: '岗位'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件templet: '<div>{{createrFormat(d.userAccount.accountName)}}</div>'
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    xadmin.open('添加用户','/emp/type?type=add',600,400)
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：'+ checkStatus.data[0].userId);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.confirm('真的删除', function(index){
                            // layer.alert(JSON.stringify(data));
                            $.ajax({
                                type:'post',
                                url:'/emp/delete',
                                traditional: true,//传数组一定要加的
                                data:{
                                    data:JSON.stringify(data)
                                },
                                dataType: 'json',
                                success:function (data) {
                                    if (data.code==0){
                                        location.reload();//刷新页面
                                        layer.msg('删除成功');
                                    } else {
                                        layer.msg('删除失败');
                                    }
                                }
                            })
                            index.close();
                        });
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                xadmin.open('分配','Allocate?id='+data.id,600,400)
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    // layer.close(index);
                    $.ajax({
                        type:'post',
                        url:'/emp/delete',
                        data:{
                            empId2:data.empId
                        },
                        dataType: 'json',
                        success:function (data) {
                            if (data.code==0){
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.msg('删除成功');

                            } else {
                                layer.msg('删除失败');
                            }
                        }
                    })
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){
                console.log(data.userId)
                xadmin.open('编辑','/emp/type?type=edit&empId='+data.empId,600,400)
            }
        });
        var $ = layui.$, active = {
            //layui 搜索模块
            reload: function () {
                var userName = $('#userName');
                console.log("ss"+userName)

                table.reload('tableOne', {
                    page: {
                        curr: 1
                    }
                    , where: {
                        username: userName.val()
                    }
                });
            }
        };
        //监听搜索
        $('#search').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


    });
</script>
</body>
</html>

