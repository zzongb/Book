<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加页面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/update.css" />
		<link rel="stylesheet" href="${path }/js/jquery-upload/css/jquery.fileupload-ui.css" />
		<link rel="stylesheet" href="${path }/js/jquery-upload/css/jquery.fileupload.css" />
		<style type="text/css">
			.error{
				color:red;
			}
		</style>
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
						<a class="navbar-brand" href="#">图书管理系统</a>
					</div>
					<div class="collapse navbar-collapse" id="example-navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"><span class="text-success">jack</span></a></li>
							<li><a href="${path }/user/safeExit">安全退出</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="container">
			<div id="update">
				<form id="filmForm" action="#" method="post"  class="form-horizontal" role="form" enctype="multipart/form-data">
					<fieldset>
						<legend>新增用户信息</legend>
						<input type="hidden" value="${book.id }" name="id">
						<div class="form-group">
							<label for="isbn" class="col-md-3 control-label">图书编号</label>
							<div class="col-md-6">
								<input type="text" name="isbn" value="${book.isbn }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="bname" class="col-md-3 control-label">书名</label>
							<div class="col-md-6">
								<input type="text" name="bname" value="${book.bname }" class="form-control" required="required">
							</div>
						</div>
						
						<div class="form-group">
							<label for="author" class="col-md-3 control-label">作者</label>
							<div class="col-md-6">
								<input type="text" name="author" value="${book.author }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="price" class="col-md-3 control-label">价格</label>
							<div class="col-md-6">
								<input type="text" name="price" value="${book.price }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="publishhouse" class="col-md-3 control-label">出版社</label>
							<div class="col-md-6">
								<input type="text" name="publishhouse" value="${book.publishhouse }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="num" class="col-md-3 control-label">图书总数</label>
							<div class="col-md-6">
								<input type="text" name="num" value="${book.num }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="balante" class="col-md-3 control-label">图书剩余数量</label>
							<div class="col-md-6">
								<input type="text" name="balante" value="${book.balante }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="type" class="col-md-3 control-label">图书类别</label>
							<div class="col-md-6">
								<input type="text" name="type" value="${book.type }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<div>
								<div class="form-group has-feedback">
									<label for="publishDate" class="col-md-3 control-label">出版时间</label>
									<div class="col-md-6">
										<input name="publishDate" value="${book.publishDate }" type="text" class="form-control" id="datetimepicker" required="required"> 
										<span class="glyphicon glyphicon-time form-control-feedback"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div>
								<div class="form-group has-feedback">
									<label for="info" class="col-md-3 control-label">图书信息</label>
									<div class="col-md-8">
										<textarea id="remarks" name="info"  rows="10" cols="80">${book.info }</textarea>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-warning" onclick="saveFilm()">保存</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
		
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
	<!--引入js-->
	<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="${path }/js/moment.js" ></script>
	<script type="text/javascript" src="${path }/js/bootstrap-datetimepicker.min.js" ></script>
	<script type="text/javascript" src="${path }/js/update.js" ></script>
	<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
	<script type="text/javascript">
		function saveFilm() {
			var data = $("#filmForm").serialize();
			
			layer.alert(data)
			$.ajax({
				url:"${path}/saveBook",
				data:data,
				type:"post",
				success:function(msg){
					//判断是否登陆成功
					if(msg == "success"){
						layer.msg("保存成功");
						window.location.href = "${path }/selectList";
						return;
					}else{
						return false;
					}
				}
			});
		}
	</script>
	
</html>
