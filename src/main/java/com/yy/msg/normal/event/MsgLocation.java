package com.yy.msg.normal.event;

import com.yy.common.MsgContentConstant;
import com.yy.msg.normal.BaseMsgEvent;

/**
 *   上报地理位置事件
 * @author yyang21
 *
 */
public class MsgLocation extends BaseMsgEvent {
    private final static String event=MsgContentConstant.EVENT_LOCATION;//事件类型，CLICK
    private String latitude;//地理位置纬度
    private String longitude;// 地理位置经度 
    private String precision;// 地理位置精度
    
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getPrecision() {
        return precision;
    }
    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
