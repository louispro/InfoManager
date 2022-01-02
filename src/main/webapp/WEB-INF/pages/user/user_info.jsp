<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息展示</title>
    <link rel="stylesheet" type="text/css" href="../../../static/css/bootstrap.min.css">
    <script src="../../../static/js/jquery-1.9.1.min.js"></script>
    <script src="../../../static/js/bootstrap.min.js"></script>
    <style>
        h4{
            padding-left: 15%;
            font-family: sun;
        }
        .top{
            height: 50px;
        }
        .mid{
            background-color: #39987c;
        }
        .userImg{
            width:100px;
            height:100px;
            margin-top: 20px;
            margin-bottom: -5px;
            border-radius: 50px;
        }
        .imgDiv{
            align:center;
            background-color: #01AAED;
        }
        .welcomeP{
            margin-bottom: 0px;
        }

    </style>
</head>
<body>
<div style="height: 80px; background-color: white">
    <p style="font-family: 楷体;font-size: 40px;margin-top:10px;margin-left:20px;float:left">
        用户信息展示
    </p>
    <div style="float:right">
        <img style="height: 50px;width:50px;border-radius: 25px;margin-top:15px;margin-right:20px;" src="../../../static/img/user/${sessionScope.user.imageUrl==null?"default.jpg":sessionScope.user.imageUrl}" title="${sessionScope.user.username}" alt="${sessionScope.user.username}">

        <a href="${pageContext.request.contextPath}/user/logout" style="font-size: 20px;margin-right: 20px; position: relative;top:10px;color: dodgerblue">注销</a>
    </div>

</div>
    <div class="mid">
        <div style="height: 40px"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-7">
                    <div class="thumbnail">
                        <div class="imgDiv" align="center">
                            <img class="userImg" src="../../../static/img/user/${sessionScope.user.imageUrl==null?"default.jpg":sessionScope.user.imageUrl}"/>
                            <h4 style="padding-left: 0px;padding-bottom: 10px;">${sessionScope.user.username}</h4>
                        </div>
                        <h4>性&nbsp&nbsp&nbsp&nbsp别： ${sessionScope.user.gender==null?"":sessionScope.user.gender}</h4>
                        <h4>手机号： ${sessionScope.user.phonenumber==null?"":sessionScope.user.phonenumber}</h4>
                        <h4>地&nbsp&nbsp&nbsp&nbsp址： ${sessionScope.user.address==null?"":sessionScope.user.address}</h4>
                        <h4>邮&nbsp&nbsp&nbsp&nbsp箱： ${sessionScope.user.email==null?"":sessionScope.user.email}</h4>
                        <h4>学&nbsp&nbsp&nbsp&nbsp历： ${sessionScope.user.education==null?"":sessionScope.user.education}</h4>
                        <h4>身&nbsp&nbsp&nbsp&nbsp高： ${sessionScope.user.height==null?"":sessionScope.user.height}${sessionScope.user.height==null?"":"cm"}</h4>
                        <h4>体&nbsp&nbsp&nbsp&nbsp重： ${sessionScope.user.weight==null?"":sessionScope.user.weight}${sessionScope.user.weight==null?"":"斤"}</h4>
                        <div style="height: 20px">
                            <a href="${pageContext.request.contextPath}/user/toEdit" style="float:right;">修改信息</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="height: 40px"></div>
    </div>
    <div style="height:100px; text-align:center; font-size: 20px; margin-top:15px">
        赖小燚.Copyright &copy;2021/12/22
    </div>
</body>
</html>