package tree.tool;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MyWebSocket extends AbstractWebSocketHandler {
    //  建立连接时，相当于 onopen
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connected");
    }
    //  处理信息，相当于 onmessage
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("received_data: "+message.getPayload());
        Thread.sleep(1000);
        session.sendMessage(new TextMessage("I'm fine"));
    }
    //  断开连接时，相当于 onclose
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("closed");
    }
}
