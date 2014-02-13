package com.yy.msg.normal.event;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEvent;

/**
 *   扫描带参数二维码事件(已关注) 
 * @author yyang21
 *
 */
public class MsgScan extends BaseMsgEvent {
    private final static String event=MsgContentConstant.EVENT_SCAN;//事件类型，scan
    private String eventKey;//事件KEY值，qrscene_为前缀，后面为二维码的参数值
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
