package com.yy.msg.normal;

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
}
