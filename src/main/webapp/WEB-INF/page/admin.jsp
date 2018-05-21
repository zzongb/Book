<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员界面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">图书管理系统后台</a>
					</div>
					<div class="collapse navbar-collapse" id="example-navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"><span class="text-success">${username }</span></a></li>
							<li><a href="${path }">安全退出</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		
		
		<!-- 加载页面顶部 -->
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${path }/admin">用户管理</a>
					</div>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${path}/selectList">图书管理</a>
					</div>
					
				</div>
			</nav>
		</div>
		
		
		<!--查询开始-->
		<div class="container">
			<div>
				<form action="${path }/admin" class="bs-example bs-example-form" role="form" method="post">
					<div class="row">
						<div class="col-md-3">
							<div class="input-group">
								<input type="text" id="suser" name="suser" value=""  placeholder="用户名进行模糊查询" class="form-control"> 
								<span class="input-group-btn">
									<!-- <button class="btn btn-default" type="button" onclick="queryPage()">查询</button> -->
									<input type="submit" class="btn btn-default" value="查询">
								</span>
							</div>
						</div>
						<div class="col-md-4">
							<a href="${path }/addpage" class="btn btn-info">添加用户</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--查询结束-->
		
		<!--列表主体开始-->
		<div class="container">
			<div class="table-responsive">
				<table class="table table-hover">
					<caption>全部用户信息</caption>
					<thead>
						<tr class="active">
							<th>用户id</th>
							<th>用户名</th>
							<th>用户年级</th>
							<th>院校</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${studentList }" var="student">
							<tr>
								<td>${student.id }</td>
								<td>${student.suser }</td>
								<td>${student.grade }</td>
								<td>${student.major }</td>
								<td>
									<a href="${path }/updatepage?id=${student.id}" class="btn btn-warning">修改</a>
									<a href="javascript:delStudentBeffer(${student.id });" class="btn btn-warning">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!--列表主体结束-->
		
		<!-- 加载页面底部 -->
		<div class="container">
			<div class="row">
				<div class="row text-center">
					<div class="col-md-12">
						<span class="text-info">图书管理后台系统 |&nbsp;</span>
						<span class="text-info">2002－2020 </span>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		
		//删除
		function delStudentBeffer(id){
			//询问框
			layer.confirm('确认删除吗？', {
			  btn: ['必须的','算了吧'] //按钮
			}, function(){
				$.ajax({
					url:"${path }/deletepage",
					data:{"id":id},
					type:"post",
					success:function(msg){
						if(msg == "OK"){
							layer.alert("删除成功");
							window.location.href = "${path }/admin";
							return;
						}else{
							layer.alert("删除失败");
							return false;
						}
					}
				});
			}, function(){
			  layer.closeAll();
			});
		  }
	</script>
</html>
