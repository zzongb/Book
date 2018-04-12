<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆界面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/loginView.css" />
	</head>
	
	<body>
		<!--登陆begin-->
		<div id="login" class="container">
			<form id="loginForm" action="#" class="form-horizontal" role="form" method="post">
				<fieldset>
					<legend>登陆界面</legend>
					<div class="form-group has-feedback">
						<label for="firstname" class="col-md-2 control-label">用户名</label>
						<div class="col-md-5">
							<span class="glyphicon glyphicon-user form-control-feedback">
							</span> <input type="text"  name="username" value=""
								class="form-control" id="firstname" placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group has-feedback">
						<label for="lastname" class="col-md-2 control-label">密码</label>
						<div class="col-md-5">
							<span class="glyphicon glyphicon-lock form-control-feedback"></span>
							<input type="password" name="password" class="form-control" value=""
								id="lastname" placeholder="请输入密码" >
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox" name="cookie">请记住我
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="btn" class="btn btn-info" type="button" class="btn btn-default" onclick="loginHandler()">登录</button>
						</div>
					</div>
				</fieldset>
			</form> 
		</div>
		<!--登陆end-->
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
		<script type="text/javascript" src="${path }/js/jquery-validator/jquery.validate.min.js"></script>
		<script type="text/javascript">
			
			function loginHandler(){
				var username = $("#firstname").val();
				var password = $("#lastname").val();
				$.ajax({
					url:"${path}/login",
					data:{username:username,password:password},
					type:"post",
					success:function(meg){
						//如果传回的101就是管理员，跳转到管理员界面
						if(meg == "101"){
							window.location.href="${path}/admin";
						} else if(meg =="102"){
							//如果传回的是102就是普通用户，跳转到用户界面
							window.location.href="${path}/user";
						} else {
							//如果是103就是错误界面
							layer.alert("用户名或者密码错误");
						}
					}
				})
			}
			
			
			
			
			
		</script>
</html>