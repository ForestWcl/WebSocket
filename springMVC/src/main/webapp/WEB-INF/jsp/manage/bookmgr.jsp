<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
</head>
<body>
	<table id="bookList" border="1">
		<tr>
			<th width="150px" height="50px">书名</th>
			<th width="150px" height="50px">作者</th>
			<th width="150px" height="50px">价钱</th>
			<th width="150px" height="50px">出版社</th>
		</tr>
	</table>
	
	
	<form action="${pageContext.request.contextPath }/manage/book/save" method="POST" enctype="multipart/form-data">
		<p>书名:<input type="text" name="title"/></p>
		<p>作者:<input type="text" name="author"/></p>
		<p>价格:<input type="text" name="price"/></p>
		<p>出版社:<input type="text" name="pulisher"/></p>
		<p>图片:<input type="file" name="pic"/></p>
		<p><button>录入 ${tip }</button></p>
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function(){
			load();
		})
		function load(){
			$.getJSON("<%= application.getContextPath()%>/manage/book/list", function(bookArr){
				var trsData = "";
				for(var i in bookArr) {
					var c = bookArr[i];
					trsData += "<tr align='center'>";
					trsData += "<td>" + c.title + "</td>";
					trsData += "<td>" + c.author +"</td>";
					trsData += "<td>" + c.price +"</td>";
					trsData += "<td>" + c.pulisher +"</td>";
					trsData += "</tr>";
				}				
				$("#bookList tr:first").after(trsData);
			});
		}
	</script>
</body>
</html>