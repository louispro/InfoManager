<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2022/1/1
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>408 Request Timeout</title>
</head>
<body>
<%@ include file="../common/myheader.jsp"%>
<div class="layui-row" style="margin-top: 80px;">
    <div class="layui-col-md8 layui-col-md-offset3">
        <a class="nflink" href="http://localhost:8080/user/toUserInfo">
            <img src="../../../static/img/error/408.png" title="返回首页" alt="返回首页" style=""/><br/>
        </a>
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-md-offset3">
                <a class="nflink" href="http://localhost:8080/user/toUserInfo" style="border:2px; border-color: dodgerblue; border-radius: 5px;font-size: 20px;color: dodgerblue">您访问的页面不存在，返回首页</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/myfooter.jsp"%>
</body>
</html>
