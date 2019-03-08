<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta content="always" name="referrer">
		<title>登录首页</title>
		<link href="css/login.css" type="text/css" rel="stylesheet" />
		<script src="js/jquery-3.3.1.min.js"></script>
		<script>
			$(function() {
				$("#btn_login").click(function() {
					$("#form1").submit();
				});
			});
			
			function myReload() {
				document.getElementById("CreateCheckCode").src = document
						.getElementById("CreateCheckCode").src
						+ "?nocache=" + new Date().getTime();
			}
			
			$.post("Check.do",{},function(data){
				
			})
			
			
			
			$(function() {
				windowSize();
				scrollBanner();
			})
			$(window).resize(function() {
				windowSize();
			});
			function windowSize() {
				if ($(window).height() < 640) {
					$('#footer').css('position', 'static');
				} else {
					$('#footer').css('position', 'fixed');
				}
			}

			//轮播
			var iNow = 1;
			var scrollTimer = null;
			function scrollBanner() {
				clearInterval(scrollTimer);
				scrollTimer = setInterval(auto, 4000);
				function auto() {
					if (iNow == $('.banner li').length) {
						iNow = 0;
					}
					scrollRun(iNow);
					iNow++;
				}

				function scrollRun(index) {
					$('.banner li').fadeOut(1000);
					$('.banner li').eq(index).fadeIn(1000);
				}
			}
		</script>
</head>
<body>
	<div id="header">
		<a class="fl" href="#"><img width="226" height="50"
			src="images/logo.jpg" /></a>
	</div>

	<form action="login.do" id="form1" method="post">
		<div id="wrap">
			<div class="fl">
				<ul class="banner">
					<li class="active"><img src="images/b1.png" /></li>
					<li><img src="images/b2.png" /></li>
					<li><img src="images/b3.png" /></li>
				</ul>
			</div>
			<div class="login fr">
				<div class="login_1">
					<img src="images/login_box_logo.png" />种子项目管理系统
				</div>
				<div class="login_2">
					<div class="login_3">
						<input class="username" name="empNo" type="text" placeholder="用户名" />
						<input type="password" name="passWord" placeholder="密码" />

						<!-- <input class="yzm fl" type="text" placeholder="验证码" />
                <div class="yzm_img fl"><img src="images/yzm.png" /></div>
                <a class="hyz fl" href="#">换一张</a>  -->

						<form action="Check.jsp" method="post">
							<table>
								<tr>
									<td><input name="checkCode" class="yzm fl" type="text"
										id="checkCode" title="验证码区分大小写" size="8" ,maxlength="4" /></td>

									<td>
										<div class="yzm_img fl">
											<img src="PictureCheckCode" id="CreateCheckCode"
												align="middle">
										</div>

									</td>
									<td><a href="" onclick="myReload()" class="hyz fl">换一个</a>
									</td>
								</tr>


							</table>

							<!-- <input name="checkCode" class="yzm fl" type="text" id="checkCode" title="验证码区分大小写"
					size="8" ,maxlength="4" />
					
					
					<img src="PictureCheckCode" id="CreateCheckCode" align="middle" > 
					<a href="" onclick="myReload()" class="hyz fl">换一个</a>  -->
						</form>

						<div class="clear"></div>
						<div class="login_4">
							<label> <input type="checkbox" name="rem" value="604800" />
								<span>七天免密码登录</span>
							</label> <a href="#" class="fr">忘记密码</a>
						</div>
					</div>
					<!-- <a href="html/index.html" class="login_5">登&nbsp;&nbsp;&nbsp;&nbsp;录</a> -->
				</div>
				<a href="javascript:return void(0)" class="login_7" id="btn_login">登
					录</a>
			  <!-- <input type="submit" id="btn_login" class="login_7" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>   -->
			</div>
		</div>
	</form>
	
	
	<div id="footer">
		<div class="footer_2">版权所有：欧辰科技有限公司</div>
	</div>
</body>
</html>
