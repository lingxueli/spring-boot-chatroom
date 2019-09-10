package edu.udacity.java.nano.chat;

import java.sql.Struct;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.
    private String username;
    private String msg;
/*
    private String type;
    private Struct onlineCount;
*/

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

/*
    public void setType(String type) {
        this.type = type;
    }

    public void setOnlineCount(Struct onlineCount) {
        this.onlineCount = onlineCount;
    }
*/

    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }

/*
    public String getType() {
        return type;
    }

    public Struct getOnlineCount() {
        return onlineCount;
    }
*/
}
