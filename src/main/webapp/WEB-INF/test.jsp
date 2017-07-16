<html>
<body>
<h2>Hello World!</h2>

${ceshi}
---------|
${aa}
----------|
<%if(request.getSession().getAttribute("aa").equals("cc")){%>
quanxian
<%}else {%>wuquanxian<%}%>
<a href="/add?procInsId=1000">addUser</a>
<a href="/addHttp?procInsId=1000">addHttp</a>
</body>
</html>
