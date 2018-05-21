<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>借书界面</title>
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
						<a class="navbar-brand" href="${path }/user">借阅图书</a>
					</div>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span><span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${path}/returnBook">归还图书</a>
					</div>
					
				</div>
			</nav>
		</div>
		<!--查询开始-->
		<div class="container">
			<div>
				<form action="${path }/user" class="bs-example bs-example-form" role="form" method="post">
					<div class="row">
						<div class="col-md-3">
							<div class="input-group">
								<input type="text" id="bname" name="book.bname" value=""  placeholder="用户名进行模糊查询" class="form-control"> 
								<span class="input-group-btn">
									<!-- <button class="btn btn-default" type="button" onclick="queryPage()">查询</button> -->
									<input type="submit" class="btn btn-default" value="查询">
								</span>
							</div>
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
					<caption>全部图书信息</caption>
					<thead>
						<tr class="active">
							<th>图书编号</th>
							<th>图书名</th>
							<th>作者</th>
							<th>价格</th>
							<th>出版社</th>
							<th>出版日期</th>
							<th>图书类别</th>
							<th>图书总量</th>
							<th>图书剩余</th>
							<th>图书信息</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="book">
							<tr>
								<td>${book.isbn }</td>
								<td>${book.bname }</td>
								<td>${book.author}</td>
								<td>${book.price}</td>
								<td>${book.publishhouse}</td>
								<td><fmt:formatDate value="${book.publishDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
								<td>${book.info }</td>
								<td>${book.num }</td>
								<td id="num">${book.balante }</td>
								<td>${book.type}</td>
								<td>
									<a href="${path }/borrowPage?id=${book.id}" class="btn btn-warning">借阅</a>
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
	
		/* //删除
		function delFilms(){
			//询问框
			layer.confirm('确认删除吗？', {
			  btn: ['必须的','算了吧'] //按钮
			}, function(){
				var ids = "";
				for(var i=0;i<$(".cks:checked").length;i++){
					ids += $(".cks:checked:eq(" + i + ")").val() + ",";//1,2
				}
				ids = ids.substr(0,ids.length-1);
				
				$.ajax({
					url:"${path }/back/filmDel",
					data:{"ids":ids},
					type:"post",
					success:function(msg){
						//判断是否登陆成功
						if(msg == "success"){
							layer.msg("删除成功");
							window.location.href = "${path }/back/filmList";
							return;
						}else{
							return false;
						}
					}
				});
			}, function(){
			  layer.closeAll();
			});
		  } */
	</script>
</html>
