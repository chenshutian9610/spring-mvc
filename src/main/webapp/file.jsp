<%@ page contentType="text/html;charset=utf-8"%>
<html>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile">
    <input type="submit" value="submit">
</form>
<a href="/download?name=C:/Users/wanna/Desktop/cache.txt">download</a><br>
${message}
</body>
</html>
