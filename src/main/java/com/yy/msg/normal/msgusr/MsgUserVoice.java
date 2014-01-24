package com.yy.msg.normal.msgusr;

import com.yy.msg.normal.BaseMsgEntity;
import com.yy.msg.normal.MsgContentConstant;


/**
 * 语音消息
 * @author yyang21
 *
 */
public class MsgUserVoice extends BaseMsgEntity{
    private String format ;// 语音格式，如amr，speex等 
    private String mediaId ;// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String msgId;//   消息id，64位整型 
    public MsgUserVoice() {
        setMsgType(MsgContentConstant.MSGTYPE_VOICE);//消息类型，event
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getMediaId() {
        return mediaId;
    }
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
