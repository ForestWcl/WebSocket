<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>WebSocket示例</title>
	<style type="text/css">
		.debug { font-size: 12px; font-weight: bold; font-style: italic; }
	</style>
</head>
<body>
	<h1>WebSocket示例</h1>
	<form action="<%= application.getContextPath()%>/manage/messageSend" method="POST">
		<h3>发布新通知</h3>
		<p>内容：<input type="text" name="message"></p>
		<p><input type="submit" value="发布"> ${tip }</p>
	</form>
	<h4>收到的websocket的调试消息</h4>
	<ul class="debug"></ul>
	<script type="text/javascript" src="<%= application.getContextPath() %>/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function(){
			/* 创建与服务器的连接，并让服务器保持会话 */
			var ws = new WebSocket("ws://localhost:8080/<%=application.getContextPath() %>/websocket/handler");
			
			ws.onopen = function(event) {			
				putDebug("websocket open ocurr");
			}
			
			ws.onmessage = function(event) {
				putDebug("websocket message ocurr data: " + event.data);
			}

			ws.onclose = function(event) {			
				putDebug("websocket close ocurr");
			}
			
			ws.onerror = function(event){
				putDebug("websocket error ocurr");
			}
			
			window.onbeforeunload = function() {
				ws.close(); //关闭websocket连接
			}
			
		})	
		
		function putDebug(debug) {
			$(".debug").append("<li>" + debug + "</li>");
		}
	</script>
</body>
</html>