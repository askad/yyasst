package com.yy.msg.normal.msgusr;

import com.yy.msg.normal.BaseMsgEntity;
import com.yy.msg.normal.MsgContentConstant;


/**
 * 文本消息
 * @author yyang21
 *
 */
public class MsgUserText extends BaseMsgEntity{
    private String content ;// 文本消息内容
    private String msgId;//   消息id，64位整型 
    public MsgUserText() {
        setMsgType(MsgContentConstant.MSGTYPE_TEXT);//消息类型，event
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
