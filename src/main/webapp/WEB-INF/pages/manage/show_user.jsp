<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2021/12/26
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户信息管理</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
    <script src="../../../static/js/jquery-1.9.1.min.js"></script>
    <style>
        ul{
            list-style-type: none;
            margin:0;
            padding:0;
            overflow: hidden;
            background-color: white;
        }
        li{
            float: left;
        }
        li a{
            display: block;
            color: dodgerblue;
            text-align: center;
            padding:14px 16px;
            text-decoration: none;
        }
        /*鼠标移动到选项上的背景颜色*/
        li a:hover{
            background-color: whitesmoke;
        }
        li input{
        }
        td a:hover{
            color: blue;
        }
    </style>
</head>
<body>
    <div style="height: 80px; background-color: #39987c;">
        <p style="font-family: 楷体;font-size: 40px;margin-top:20px;margin-left:20px;float:left">
            用户信息管理
        </p>
        <div style="float:right">
            <img style="height: 50px;width:50px;border-radius: 25px;margin-top:15px;margin-right:20px;" src="../../../static/img/user/${sessionScope.user==null?"default.jpg":sessionScope.user.imageUrl}" title="${sessionScope.user.username}" alt="${sessionScope.user.username}">

            <a href="${pageContext.request.contextPath}/manage/logout" style="font-size: 20px;margin-right: 20px; position: relative;top:10px;color: dodgerblue">注销</a>
        </div>

    </div>
        <div class="layui-row">
            <div class="layui-col-md10 layui-col-md-offset1">
                <table class="layui-table" border="1px" cellspacing="1px" style="text-align: center;font-family: 楷体;font-size: 30px;font-weight: bolder">
                    <thead>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>性别</th>
                    <th>学历</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>邮箱</th>
                    <th>身高</th>
                    <th>体重</th>
                    <th>头像</th>
                    <th>角色</th>
                    <th>操作1</th>
                    <th>操作2</th>
                    </thead>
                    <c:forEach items="${requestScope.users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.gender}</td>
                            <td>${user.education}</td>
                            <td>${user.phonenumber}</td>
                            <td>${user.address}</td>
                            <td>${user.email}</td>
                            <td>${user.height}</td>
                            <td>${user.weight}</td>
                            <td>${user.imageUrl}</td>
                            <td>${user.roleName}</td>
                            <td><a class="updateUser" href="${pageContext.request.contextPath}/manage/toEdit?id=${user.id}&pageNum=${requestScope.pageNum}" style="color: dodgerblue">修改</a> </td>
                            <td><a class="deleteUser" href="JavaScript:void(0)" style="color: dodgerblue">删除</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-col-md10 layui-col-md-offset1">
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list?pageNum=1">首页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list?pageNum=${requestScope.pageNum-1}">上一页</a>
                    </li>
                    <li>
                        <a href="JavaScript:void(0)" style="color: black">当前页：${requestScope.pageNum}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list?pageNum=${requestScope.pageNum+1}">下一页</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list?pageNum=${requestScope.pages}">尾页</a>
                    </li>
                    <li>
                        <a href="JavaScript:void(0)" style="color: black">到第<input id="pageInput" type="text" style="width:50px; text-align: center" value="${requestScope.pageNum}">页</a>
                    </li>
                    <li>
                        <a id="searchLink" href="JavaScript:void(0)">确定</a>
                    </li>
                    <li>
                        <a href="JavaScript:void(0)" style="color: black">共${requestScope.pages}页,${requestScope.total}条记录</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/toEdit?pageNum=${requestScope.pageNum}">添加用户</a>
                    </li>
                </ul>
            </div>
        </div>
        <div style="height: 100px"></div>

        <div style="height:50px;background-color: #39987c;position: fixed;bottom:0; width:100%; ">
            <p style=" text-align:center; font-size: 20px;position:relative;top:15px;">
                李月.Copyright &copy;2021/12/22
            </p>
        </div>

    <script>
        $(function(){
            $(".deleteUser").click(function (){
                var userId = $(this).parent().parent().children("td:first").text();
                var username = $(this).parent().parent().children("td:eq(1)").text()
                if(confirm("确定删除"+username+"吗？")){
                    location.href = "http://localhost:8080/manage/delete?id="+userId
                }
            })

            $("#searchLink").click(function (){
                var pageNum = $("#pageInput").val();
                window.location.href = "http://localhost:8080/manage/list?pageNum="+pageNum
            })
        })
    </script>
</body>
</html>
