package com.yy.msg.normal.event;

import com.yy.msg.normal.BaseMsgEntity;
import com.yy.msg.normal.MsgContentConstant;

/**
 *  自定义菜单事件
 * @author yyang21
 *
 */
public class MsgClick extends BaseMsgEntity {
    private final static String event=MsgContentConstant.EVENT_CLICK;//事件类型，CLICK
    private String eventKey; // 事件KEY值，与自定义菜单接口中KEY值对应 
    
    public String getEventKey() {
        return eventKey;
    }
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    public static String getEvent() {
        return event;
    }
}
