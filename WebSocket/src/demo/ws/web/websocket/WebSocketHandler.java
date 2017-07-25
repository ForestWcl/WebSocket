package demo.ws.web.websocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/* 指定当前类是处理WebSocket请求的服务器终端对象 */
@ServerEndpoint("/websocket/handler")
public class WebSocketHandler {
	
	private static List<Session> allClientSessions = Collections.synchronizedList(new ArrayList<Session>());
	
	public static void sendDataToAllClients(String data) {
		for(Session session : allClientSessions) {
			session.getAsyncRemote().sendText(data);
		}
	}

	@OnOpen /* 每当有客户端建立ws请求，就会调用有@OnOpen注解的方法，并将代表当前客户端的Session对象传入 */
	public void onOpen(Session session) {
		System.out.println("\n==== WebSocketHandler onOpen, session id: " + session.getId()); 
		allClientSessions.add(session);
	}
	
	@OnMessage
	public void onMessage(String message) {
		System.out.println("\n==== WebSocketHandler onMessage, message: " + message); 
	}

	@OnClose /* 每当有客户端断开ws请求，就会调用有@OnClose注解的方法，并将代表当前客户端的Session对象传入 */
	public void onClose(Session session) {
		System.out.println("\n==== WebSocketHandler onClose, session id: " + session.getId());
		allClientSessions.remove(session);
	}
		
	@OnError /* 每当有客户端断开ws请求，就会调用有@OnClose注解的方法，并将代表当前客户端的Session对象传入 */
	public void onError(Throwable throwable) {
		System.out.println("\n==== WebSocketHandler onError, throwable: " + throwable);
	}
}
