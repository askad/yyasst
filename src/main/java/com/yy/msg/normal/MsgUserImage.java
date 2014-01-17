package com.yy.msg.normal;


/**
 * 图片消息
 * @author yyang21
 *
 */
public class MsgUserImage extends BaseMsgEntity{
    private String picUrl ;// 图片链接 
    private String mediaId ;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String msgId;//   消息id，64位整型 
    public MsgUserImage() {
        setMsgType(MsgConstant.MSGTYPE_IMAGE);//消息类型，event
    }
    public String getPicUrl() {
        return picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
