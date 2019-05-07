<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrapValidator.css" />
<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrapValidator.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {

		$(".form-horizontal").bootstrapValidator({

			feedbackIcons : {

				valid : "glyphicon glyphicon-ok",
				invalid : "glyphicon glyphicon-remove",
				validating : "glyphicon glyphicon-refresh"
			},

			fields : {

				username : {

					validators : {

						notEmpty : {

							message : '用户名不能为空'

						},

						regexp : {

							regexp : /^[A-z0-9_]{3,12}$/,
							message : '用户名必须由3-12个英文字母、数字和下划线组成'

						},

						remote : {

							url : "validate.action",

							message : '该用户已被注册，请重新输入',

							type : 'post',

							data : function(validator) {

								return {

									userName : $("input[name=username]").val()
								}
							}
						}

					}
				}
			}
		});
	});
</script>

</head>

<body>
	<div class="container">
		<h1 align="center">妖怪管理系统———注册页面</h1>

		<hr width="1000px">

		<form action="add" class="form-horizontal" method="post">

			<div class="form-group">

				<label for="username" class="col-sm-4 control-label">用户名</label>

				<div class="col-sm-4">

					<input type="text" class="form-control" id="username"
						name="username">

				</div>

			</div>

			<div class="form-group">

				<label for="password" class="col-sm-4 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>

				<div class="col-sm-4">

					<input type="password" class="form-control" id="password"
						name="password">

				</div>

			</div>

			<div class="form-group">

				<div class="col-sm-offset-4 col-sm-4">

					<button type="submit" class="btn btn-primary">注册</button>

				</div>

			</div>

		</form>

		<div class="col-sm-offset-4 col-sm-4">

			<a href="login.jsp"><font size="2" color="black">还不是会员？立即注册</font></a>

		</div>

	</div>

</body>

</html>
