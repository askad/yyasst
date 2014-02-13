package com.yy.msg.normal;

import com.yy.common.MsgContentConstant;

/**
 * 事件消息
 * 
 * @author yyang21
 * 
 */
public class BaseMsgEvent extends BaseMsgEntity {
    public BaseMsgEvent() {
        setMsgType(MsgContentConstant.MSGTYPE_EVENT);// 消息类型，event
    }

    public BaseMsgEvent(String fromUserName, String toUserName) {
        setMsgType(MsgContentConstant.MSGTYPE_EVENT);// 消息类型，event
        this.setFromUserName(fromUserName);
        this.setToUserName(toUserName);
    }
}
