package com.yy.msg.normal.event;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEvent;

/**
 *   取消关注事件
 * @author yyang21
 *
 */
public class MsgUnSubscribe extends BaseMsgEvent {
    private final static String event=MsgContentConstant.EVENT_UNSUBSCRIBE;//事件类型，unsubscribe(取消订阅)

    public static String getEvent() {
        return event;
    }
    
}
