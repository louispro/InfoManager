<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2021/12/22
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
<head>
    <title>个人信息管理登录页面</title>
    <!--静态包含base标签，css，js-->
    <%@ include file="../common/head.jsp"%>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.png" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form" style="width:360px; height: 340px;">
            <div class="login_box">
                <div class="tit">
                    <h1>用户登录</h1>
                </div>
                <div class="msg_cont" style="width:260px; margin-left: 0px;">
                    <b></b>
                    <span class="errorMsg" style="width:320px">${requestScope.msg==null?"请输入用户名和密码":requestScope.msg}</span>
                </div>
                <div class="form">
                    <form id="login" action="${pageContext.request.contextPath}/user/login" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入账号/手机号/邮箱" autocomplete="off" tabindex="1" name="userKey"
                               value="${requestScope.username==null?"":requestScope.username}"/>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
                               value="${requestScope.password==null?"":requestScope.password}"/>
                        <div>
                            <input id="user" type="radio" name="roleId" value="1" checked/><label style="margin-right: 165px;">普通用户</label>
                            <input id="manager" type="radio" name="roleId" value="0"><label>管理员</label>
                        </div>
                        <div>
                            <a style="margin-right: 180px; text-decoration-line: none;color:dodgerblue" href="${pageContext.request.contextPath}/user/toRegist">立即注册</a>
<%--                            <a style="text-decoration-line: none; color:dodgerblue" href="">忘记密码</a>--%>
                        </div>
                        <input type="submit" value="登录" id="sub_btn" style="width:320px"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        $("#user").click(function(){
            $("#login").attr("action","${pageContext.request.contextPath}/user/login")
        })

        $("#manager").click(function(){
            $("#login").attr("action","${pageContext.request.contextPath}/manage/login")
        })
    })
</script>

<!--静态包含页脚-->
<%@ include file="../common/footer.jsp"%>
</body>
</html>