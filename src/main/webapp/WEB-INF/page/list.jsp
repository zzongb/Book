<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户界面</title>
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
						<a class="navbar-brand" href="${path }/user">借书模块</a>
					</div>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="${path}/returnBook">还书模块</a>
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
					</div>
				</form>
			</div>
		</div>
		<!--查询结束-->
		
		<!--列表主体开始-->
		<div class="container">
			<div class="table-responsive">
				<table class="table table-hover">
				<c:choose>
					<c:when test="${borrowVo.borrows == null || borrowVo.borrows == ''}">
						<p style='font-size:10px;color:red'>数据为空</p>
					</c:when>
					<c:otherwise>
						<caption>全部用户信息</caption>
					<thead>
						<tr class="active">
							<th>借书用户id</th>
							<th>借阅时间</th>
							<th>归还时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${borrowVo.borrows }" var="borrow">
								<tr>
									<td>${borrow.sid}</td>
									<td>${borrow.borrowDate }</td>
									<td>${borrow.returnBook }</td>
									<td>
										<a href="${path }/borrowBookXingqing?id=${borrow.bid}" class="btn btn-warning">书籍详情</a>
										<a href="${path }/returnBookPage?id=${borrow.bid}" class="btn btn-warning">归还图书</a>
									</td>
								</tr>
						</c:forEach>
					</tbody>
					</c:otherwise>
				</c:choose>
				
					
				
					
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
		  }
	</script>
</html>
