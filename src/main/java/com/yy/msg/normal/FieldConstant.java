package com.yy.msg.normal;

public class FieldConstant {
    public static final String HEAD_ROOT = "xml";
    public static final String HEAD_TO_USER_NAME = "ToUserName";
    public static final String HEAD_FROM_USER_NAME = "FromUserName";
    public static final String HEAD_CREATE_TIME = "CreateTime";
    public static final String HEAD_MSG_TYPE = "MsgType";

    public static final String EVENT_EVENT = "Event";
    public static final String EVENT_EVENT_KEY = "EventKey";
    public static final String EVENT_TICKET = "Ticket";
    public static final String EVENT_LATITUDE = "Latitude";// 地理位置纬度
    public static final String EVENT_LONGITUDE = "Longitude";// 地理位置经度
    public static final String EVENT_PRECISION = "Precision";// 地理位置精度

    public static final String RES_TEXT_CONTENT = "Content";// 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
}
