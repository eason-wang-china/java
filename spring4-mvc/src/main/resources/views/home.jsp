<html>
<body>
	<div style="width: 300px; float:left;">
		<h2>Hello ${ myName }!</h2>
		<img alt="vue logo" src="${ ctx }/pics/vue-logo.png" width="150">
	</div>
	<div style="width: 500px; float:left;">
		<a href="${ ctx }/logs">验证日志框架</a><br>
		<a href="${ ctx }/return-chinese">验证中文编码</a><br>
		<a href="${ ctx }/books">浏览图书</a><br>
		<a href="${ ctx }/students/2">获取一个学生</a><br>
		<a href="${ ctx }/login">登陆</a><br>
		<a href="${ ctx }/model-attr?name=eason&author=zhg&username=wys&loginname=wyswangn&other=123">验证 ModelAttribute</a><br>
	</div>
</body>
</html>
