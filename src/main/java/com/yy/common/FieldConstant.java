package com.yy.common;

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
    
    public static final String USR_MSG_CONTENT = "Content";// 文本消息内容
    public static final String USR_MSG_MSGID = "MsgId";// 文本消息内容 

    public static final String RES_TEXT_CONTENT = "Content";// 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    public static final String RES_TEXT_ArticleCount = "ArticleCount";// 图文消息个数，限制为10条以内
    public static final String RES_TEXT_Articles = "Articles";// 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
    public static final String RES_TEXT_Article_ITEM = "item";// 图文消息
    public static final String RES_TEXT_Article_Title = "Title";// 图文消息标题 
    public static final String RES_TEXT_Article_Description = "Description";// 图文消息描述
    public static final String RES_TEXT_Article_PicUrl = "PicUrl";// 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    public static final String RES_TEXT_Article_Url = "Url";// 点击图文消息跳转链接 
}

