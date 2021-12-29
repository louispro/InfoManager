<%--
  Created by IntelliJ IDEA.
  User: 赖小燚
  Date: 2021/12/29
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.user!=null}">
    <div style="height: 80px; background-color: #39987c;">
        <p style="font-family: 楷体;font-size: 40px;margin-top:20px;margin-left:20px;float:left">
            <c:if test="${sessionScope.user.id==0}">
                用户信息管理
            </c:if>
            <c:if test="${sessionScope.user.id==1}">
                用户信息展示
            </c:if>
        </p>
        <div style="float:right">
            <img style="height: 50px;width:50px;border-radius: 25px;margin-top:15px;margin-right:20px;" src="../../../static/img/user/${sessionScope.user==null?"default.jpg":sessionScope.user.imageUrl}" title="${sessionScope.user.username}" alt="${sessionScope.user.username}">
            <a href="${pageContext.request.contextPath}/manage/logout" style="font-size: 20px;margin-right: 20px; position: relative;top:10px;color: dodgerblue">注销</a>
        </div>
    </div>
</c:if>
