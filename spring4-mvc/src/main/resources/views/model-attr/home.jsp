<html>
<body>
	<div style="width: 300px; float:left;">
		<h2>Hello ${ myName }!</h2>
		<img alt="vue logo" src="${ ctx }/pics/vue-logo.png" width="150">
	</div>
	<div style="width: 500px; float:left;">
		<a href="${ ctx }/model-attr/home?my-name=eason wang">验证 ModelAttribute 路径作为视图地址</a><br>
		<a href="${ ctx }/model-attr?name=eason&author=zhg&username=wys&loginname=wyswangn&other=123">验证 ModelAttribute 参数</a><br>
	</div>
</body>
</html>
