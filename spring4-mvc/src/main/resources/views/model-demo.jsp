<%@page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date" isELIgnored="false" %>
<html>
<body>
<h2>Hello World! - <% out.println(new Date()); %></h2>
<h2>obj--${obj.name}--${obj.id}</h2>
<h2>thirdModel--${third.name}--${third.id}</h2>
<h2>requestObj--${requestObj.name}--${requestObj.id}</h2>
</body>
</html>
