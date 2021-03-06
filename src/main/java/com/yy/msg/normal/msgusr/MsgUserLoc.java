package com.yy.msg.normal.msgusr;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEntity;


/**
 * 地理位置消息
 * @author yyang21
 *
 */
public class MsgUserLoc extends BaseMsgEntity{
    private String location_X ;// 地理位置维度
    private String location_Y;//  地理位置经度 
    private String scale ;// 地图缩放大小
    private String label ;// 地理位置信息
    private String msgId;// 消息id，64位整型 
    public MsgUserLoc() {
        setMsgType(MsgContentConstant.MSGTYPE_LOCATION);//消息类型，event
    }
    public String getLocation_X() {
        return location_X;
    }
    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }
    public String getLocation_Y() {
        return location_Y;
    }
    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }
    public String getScale() {
        return scale;
    }
    public void setScale(String scale) {
        this.scale = scale;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
