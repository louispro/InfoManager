<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2021/12/27
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改用户信息</title>
    <base href="http://localhost:8080/"/>
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
    <script src="../../../static/js/jquery-1.9.1.min.js"></script>
</head>
<body>
    <div style="height: 80px; background-color: #39987c">
        <p style="font-family: 楷体;font-size: 40px;margin-top:20px;margin-left:20px;float:left">
            用户信息管理
        </p>
        <div style="float:right">
            <img style="height: 50px;width:50px;border-radius: 25px;margin-top:15px;margin-right:20px;" src="../../../static/img/user/default.jpg" title="${sessionScope.user.username}" alt="${sessionScope.user.username}">

            <a href="${pageContext.request.contextPath}/manage/logout" style="font-size: 20px;margin-right: 20px; position: relative;top:10px;color: dodgerblue">注销</a>
        </div>

    </div>

    <div style="height: 200px;"></div>
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
                <th id="operate">${requestScope.user==null?"添加":"修改"}</th>
                </thead>
                    <tr>
                        <td id="userId" contenteditable="false">${requestScope.user==null?requestScope.sysId:requestScope.user.id}</td>
                        <td id="username" contenteditable="true">${requestScope.user==null?"":requestScope.user.username}</td>
                        <td id="password"contenteditable="true">${requestScope.user==null?"":requestScope.user.password}</td>
                        <td id="gender" contenteditable="true">${requestScope.user==null?"":requestScope.user.gender}</td>
                        <td id="education" contenteditable="true">${requestScope.user==null?"":requestScope.user.education}</td>
                        <td id="phonenumber" contenteditable="true">${requestScope.user==null?"":requestScope.user.phonenumber}</td>
                        <td id="address" contenteditable="true">${requestScope.user==null?"":requestScope.user.address}</td>
                        <td id="email" contenteditable="true">${requestScope.user==null?"":requestScope.user.email}</td>
                        <td id="height" contenteditable="true">${requestScope.user==null?"":requestScope.user.height}</td>
                        <td id="weight" contenteditable="true">${requestScope.user==null?"":requestScope.user.weight}</td>
                        <td id="imageUrl" contenteditable="true">${requestScope.user==null?"":requestScope.user.imageUrl}</td>
                        <td id="roleName" contenteditable="true">${requestScope.user==null?"":requestScope.user.roleName}</td>
                        <td><a id="updateUser" href="JavaScript:void(0)" style="color: dodgerblue">提交</a> </td>
                    </tr>
            </table>
        </div>
    </div>
    <div style="height: 200px;"></div>

    <div style="height:50px;background-color: #39987c;position: fixed;bottom:0; width:100%;">
        <p style=" text-align:center; font-size: 20px;position:relative;top:15px;">
            李月.Copyright &copy;2021/12/22
        </p>
    </div>

    <script>
        $(function(){
            $("#updateUser").click(function (){
                var id = $("#userId").text()
                var username = $("#username").text()
                var password = $("#password").text()
                var gender = $("#gender").text()
                var education = $("#education").text()
                var phonenumber = $("#phonenumber").text()
                var address = $("#address").text()
                var email = $("#email").text()
                var height = $("#height").text()
                var weight = $("#weight").text()
                var imageUrl = $("#imageUrl").text()
                var roleName = $("#roleName").text()
                var operate = $("#operate").text()  //操作
                //表格不能为空
                if(id==""
                    || username==""
                    || password==""
                    || password==""
                    || education==""
                    || phonenumber==""
                    || address==""
                    || email==""
                    || height==""
                    || weight==""
                    || imageUrl==""
                    || roleName==""){
                    alert("表格信息不能为空！")
                } else {
                    if(operate == "修改"){
                        var url = "manage/edit?pageNum="+${requestScope.pageNum}
                    }
                    if(operate == "添加"){
                        var url = "manage/add?pageNum="+${requestScope.pageNum}
                    }
                    $.post(url,
                        {
                            "id":id,
                            "username":username,
                            "password":password,
                            "gender":gender,
                            "education":education,
                            "phonenumber":phonenumber,
                            "address":address,
                            "email":email,
                            "height":height,
                            "weight":weight,
                            "imageUrl":imageUrl,
                            "roleName":roleName,
                            "pageNum":${requestScope.pageNum}
                        },function (data){
                            alert(data)
                            window.location.href = "http://localhost:8080/manage/list?pageNum="+data
                        })
                }
            })
        })
    </script>
</body>
</html>
