<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<html>
	<head>
		<title>个人信息管理注册页面</title>
		<!--静态包含base标签，css，js-->
		<%@ include file="../common/head.jsp"%>
		<script type="text/javascript">
			// 页面加载完成之后
			$(function () {
				// $("#username").blur(function(){
				// 	//通过ajax验证用户名是否可用
				// 	//绑定输入框失去焦点事件
				// 	var username = this.value;
				// 	$.getJSON("http://localhost:8080/book/user","action=ajaxExistUsername&username="+username,function (data){
				// 		if(data.existUsername == true){
				// 			$("span.errorMsg").text("用户名已存在")
				// 		}else{
				// 			$("span.errorMsg").text("用户名可用")
				// 		}
				// 	})
				// })

				// 给注册绑定单击事件
				$("#sub_btn").click(function () {
					// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
					//1 获取用户名输入框里的内容
					var usernameText = $("#username").val();
					//2 创建正则表达式对象
					var usernamePatt = /^[\u4e00-\u9fa5]{2,10}$/;	//姓名必须为中文，长度在2-10
					//3 使用test方法验证
					if (!usernamePatt.test(usernameText)) {
						//4 提示用户结果
						$("span.errorMsg").text("用户名不合法！");
						return false;
					}

					// 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
					//1 获取用户名输入框里的内容
					var passwordText = $("#password").val();
					//2 创建正则表达式对象
					var passwordPatt = /^\w{5,12}$/;
					//3 使用test方法验证
					if (!passwordPatt.test(passwordText)) {
						//4 提示用户结果
						$("span.errorMsg").text("密码不合法！");

						return false;
					}

					// 验证确认密码：和密码相同
					//1 获取确认密码内容
					var repwdText = $("#repwd").val();
					//2 和密码相比较
					if (repwdText != passwordText) {
						//3 提示用户
						$("span.errorMsg").text("确认密码和密码不一致！");
						return false;
					}

					// 邮箱验证：xxxxx@xxx.com
					//1 获取邮箱里的内容
					var phoneText = $("#phonenumber").val();
					//2 创建正则表达式对象
					var phonePatt = /^[1][0-9]{10}$/;
					//3 使用test方法验证是否合法
					if (!phonePatt.test(phoneText)) {
						//4 提示用户
						$("span.errorMsg").text("手机号格式不合法！");
						return false;
					}

					// 去掉错误信息
					$("span.errorMsg").text("");

				});

			});

		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.png" style="height: 80px;" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册个人账号</h1>
								<span class="errorMsg">${requestScope.msg==null?"":requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="${pageContext.request.contextPath}/user/regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入真实姓名"
										   autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username==null?"":requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
											value="${requestScope.password==null?"":requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>手&nbsp&nbsp机&nbsp&nbsp号：</label>
									<input class="itxt" type="text" placeholder="请输入手机号"
										   autocomplete="off" tabindex="1" name="phonenumber" id="phonenumber" />
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>

		<!--静态包含页脚-->
		<%@ include file="../common/footer.jsp"%>
	</body>
</html>