<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.Date" %>
<html>
<body>
<h2>Hello World! Date: <% out.println(new Date()); %></h2>
<%
String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//pageContext.setAttribute("basePath",basePath);
//out.println(path+ " - " + basePath);
pageContext.setAttribute("basePath", path);
%>
<img alt="vue logo" src="${ basePath }/assets/vue-logo.png" width="150">
<ul>
<li>--base--</li>
<li><a href="${ basePath }/index">访问controller转向jsp</a></li>
<li><a href="${ basePath }/">删除webapp下面的index.jsp可以访问</a></li>
<li>--request--</li>
<li><a href="${ basePath }/request/">返回文本，指定了 produces = "text/plain; charset=UTF-8" </a></li>
<li><a href="${ basePath }/request/index-2">返回文本，没有指定produces，自动识别，因为@ResponseBody指定了，就不会返回网页</a></li>
<li>--params--</li>
<li><a href="${ basePath }/params/this is a params">获取路径参数</a></li>
<li><a href="${ basePath }/params?id=123">获取普通的键值对</a></li>
<li><a href="${ basePath }/params/obj?id=123&name=eason&token=123">对象参数</a></li>
<li><a href="${ basePath }/params/request-param?my-id=123&name=eason&token=123">@RequestParam使用</a></li>
<li>--response--</li>
<li><a href="${ basePath }/response/obj?id=123&name=eason">返回JSON对象</a></li>
<li><a href="${ basePath }/response/obj-2?id=123&name=eason">返回JSON对象</a></li>
<li><a href="${ basePath }/response/obj-3?id=123&name=eason">返回JSON对象</a></li>
<li>--rest--</li>
<li><a href="${ basePath }/rest">返回JSON对象</a></li>
<li><a href="${ basePath }/rest/2">返回JSON对象</a></li>
<li><a href="${ basePath }/rest/3">返回JSON对象</a></li>
<li>--model--</li>
<li><a href="${ basePath }/model?name=eason-wang&id=33&age=36">使用ModelAttribute返回字符串</a></li>
<li><a href="${ basePath }/model/to-jsp?name=eason-wang&id=33">使用ModelAttribute返回jsp页面</a></li>
<li><a href="${ basePath }/model/no-model?name=eason-wang&id=33">参数中没有model</a></li>

</ul>
</body>
</html>
