package edu.udacity.java.nano.chat;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */

    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    private static int userNum = 0;

    private static void sendMessageToAll(String msg) {
        //TODO: add send message method.
        for(String id : onlineSessions.keySet()){
            Session curSession = onlineSessions.get(id);
            RemoteEndpoint.Async peer = curSession.getAsyncRemote();
            peer.sendText(msg);
        }
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) {
        //TODO: add on open connection.
        String sessionId = session.getId();
        onlineSessions.putIfAbsent(sessionId, session);
        userNum++;
        updateUserCount(userNum);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        //TODO: add send message.
        Message msg = JSON.parseObject(jsonStr, Message.class);
        msg.setType("SPEAK");
        msg.setOnlineCount(Integer.toString(userNum));
        sendMessageToAll(JSON.toJSONString(msg));
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        //TODO: add close connection.

        // exclude closed session from the broadcast listeners
        onlineSessions.remove(session.getId());

        // broadcast update number to listeners
        userNum--;
        updateUserCount(userNum);

        // close the session
        session.close();
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    private void updateUserCount(int userNum){
        Message msg = new Message();
        msg.setOnlineCount(Integer.toString(userNum));
        sendMessageToAll(JSON.toJSONString(msg));
    }

}
