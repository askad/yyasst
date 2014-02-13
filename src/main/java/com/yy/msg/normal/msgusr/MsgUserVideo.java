package com.yy.msg.normal.msgusr;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEntity;


/**
 * 视频消息
 * @author yyang21
 *
 */
public class MsgUserVideo extends BaseMsgEntity{
    private String thumbMediaId ;// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String mediaId ;// 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。 
    private String msgId;//   消息id，64位整型 
    public MsgUserVideo() {
        setMsgType(MsgContentConstant.MSGTYPE_VIDEO);//消息类型，event
    }
    public String getThumbMediaId() {
        return thumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
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
