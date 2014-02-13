package com.yy.msg.normal.event;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEvent;

/**
 * 扫描带参数二维码关注事件
 * 
 * @author yyang21
 * 
 */
public class MsgSubscribeScan extends BaseMsgEvent {
    private final static String event = MsgContentConstant.EVENT_SUBSCRIBE;// 事件类型，subscribe(订阅)
    private String eventKey; // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String ticket;// 二维码的ticket，可用来换取二维码图片
    
    public String getEventKey() {
        return eventKey;
    }
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public static String getEvent() {
        return event;
    }
}
