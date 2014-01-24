package com.yy.msg.normal;

public class MsgContentConstant {
    /** 关注事件|扫描带参数二维码事件(未关注) */
    public final static String EVENT_SUBSCRIBE="subscribe";
    /** 取消关注事件 */
    public final static String EVENT_UNSUBSCRIBE="unsubscribe";
    /** 上报地理位置事件 */
    public final static String EVENT_LOCATION="LOCATION";
    /** 扫描带参数二维码事件(已关注) */
    public final static String EVENT_SCAN="scan";
    /** 自定义菜单事件 */
    public final static String EVENT_CLICK="CLICK";
    
    /** 事件消息 */
    public final static String MSGTYPE_EVENT="event";
    /** 文本消息 */
    public final static String MSGTYPE_TEXT="text";
    /** 图片消息 */
    public final static String MSGTYPE_IMAGE="image";
    /** 语音消息 */
    public final static String MSGTYPE_VOICE="voice";
    /** 视频消息 */
    public final static String MSGTYPE_VIDEO="video";
    /** 地理位置消息 */
    public final static String MSGTYPE_LOCATION="location";
    /** 链接消息 */
    public final static String MSGTYPE_LINK="link";
    /** 图文消息 */
    public final static String MSGTYPE_NEWS="news";
}

