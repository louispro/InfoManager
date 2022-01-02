<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2021/12/24
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户信息修改</title>
    <link rel="stylesheet" type="text/css" href="../../../static/css/bootstrap.min.css">
    <script src="../../../static/js/jquery-1.9.1.min.js"></script>
    <script src="../../../static/js/bootstrap.min.js"></script>
    <style type="text/css">
        .top{
            height: 50px;
        }
        .mid{
            background-color: #39987c;
        }
        .userLabel{
            font-size: 16px;
            font-family: 楷体;
        }
    </style>
</head>
<body>
<div style="height: 80px; background-color: white">
    <p style="font-family: 楷体;font-size: 40px;margin-top:10px;margin-left:20px;float:left">
        用户信息展示
    </p>
    <div style="float:right">
        <img style="height: 50px;width:50px;border-radius: 25px;margin-top:15px;margin-right:20px;" src="../../../static/img/user/default.jpg" title="${sessionScope.user.username}" alt="${sessionScope.user.username}">

        <a href="${pageContext.request.contextPath}/user/logout" style="font-size: 20px;margin-right: 20px; position: relative;top:10px;color: dodgerblue">注销</a>
    </div>

</div>
<div style="margin:0px; padding:0px; border:0px;">
    <div class="mid">
        <div style="height: 40px"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="thumbnail">
                        <div class="userForm">
                            <form action="/user/editInfo" method="post" enctype="multipart/form-data">
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">姓&nbsp&nbsp&nbsp&nbsp名：</label><input class="input-group-sm" name="username" type="text" value="${sessionScope.user.username}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">上传图片：</label><input class="input-group-sm" name="imageUrl" type="file"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label  class="userLabel">学&nbsp&nbsp&nbsp&nbsp历：</label><input class="input-group-sm" name="education" type="text" value="${sessionScope.user.education}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">手&nbsp机&nbsp号：</label><input class="input-group-sm" name="phonenumber" type="text" value="${sessionScope.user.phonenumber}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">住&nbsp&nbsp&nbsp&nbsp址：</label><input class="input-group-sm" name="address" type="text" value="${sessionScope.user.address}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">邮&nbsp&nbsp&nbsp&nbsp箱：</label><input class="input-group-sm" name="email" type="text" value="${sessionScope.user.email}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">身高(cm)：</label><input class="input-group-sm" name="height" type="text" value="${sessionScope.user.height}"/>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="userLabel">体重(kg)：</label><input class="input-group-sm" name="weight" type="text" value="${sessionScope.user.weight}"/>
                                    </div>
                                </div>
<%--                                <div class="row" style="margin-top:15px;margin-bottom: 15px">--%>
<%--                                    <div class="col-md-8 col-md-offset-4">--%>
<%--                                        <label class="userLabel">密&nbsp&nbsp&nbsp&nbsp码：</label><input class="input-group-sm" name="password" type="password"/>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div class="row" style="margin-top:15px;margin-bottom: 15px">--%>
<%--                                    <div class="col-md-8 col-md-offset-4">--%>
<%--                                        <label class="userLabel">确认密码：</label><input class="input-group-sm" name="rePassword" type="password"/>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                                <div class="row" style="margin-top:15px;margin-bottom: 15px">
                                    <div class="col-md-3 col-md-offset-6">
                                        <input type="submit" class="input-group-sm" value="修改">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="width:100%; text-align:center;">
        <p style="width:100%;text-align:center; font-size: 20px;">
            赖小燚.Copyright ©2021/12/22
        </p>
    </div>
</div>
</body>
</html>
