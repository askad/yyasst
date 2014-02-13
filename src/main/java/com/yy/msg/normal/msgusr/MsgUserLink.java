package com.yy.msg.normal.msgusr;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEntity;


/**
 * 链接消息
 * @author yyang21
 *
 */
public class MsgUserLink extends BaseMsgEntity{
    private String title ;// 消息标题 
    private String description;// 消息描述
    private String url ;// 消息链接
    private String msgId;// 消息id，64位整型 
    public MsgUserLink() {
        setMsgType(MsgContentConstant.MSGTYPE_LINK);//消息类型，event
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
