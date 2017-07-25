package demo.ws.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.ws.web.websocket.WebSocketHandler;

@SuppressWarnings("serial")
@WebServlet("/manage/messageSend")
public class MessageSendAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String message = req.getParameter("message");
		WebSocketHandler.sendDataToAllClients("【通知】" + message);
		req.setAttribute("tip", "通知信息发送成功！");
		req.getRequestDispatcher("/demo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doGet(req, resp);
	}
}
