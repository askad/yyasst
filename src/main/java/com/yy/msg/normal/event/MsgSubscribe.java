package com.yy.msg.normal.event;

import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.MsgContentConstant;

/**
 *   关注事件
 * @author yyang21
 *
 */
public class MsgSubscribe extends BaseMsgEvent {
    private final static String event=MsgContentConstant.EVENT_SUBSCRIBE;//事件类型，subscribe(订阅)
    
    public static String getEvent() {
        return event;
    }
    
}
