package com.yy.handler.event;

import org.w3c.dom.Document;

import com.yy.common.CommonTools;
import com.yy.handler.BaseHandler;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgConstant;
import com.yy.msg.normal.event.MsgScan;
import com.yy.msg.normal.event.MsgSubscribe;
import com.yy.response.BaseResponser;

public class EventHandler extends BaseHandler {
    private String eventName;
    private BaseMsgEvent msgIn;

    public EventHandler(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 处理消息
     * 
     * @return
     */
    public Document onProcess() {
        if (MsgConstant.EVENT_SCAN.equals(eventName)) {

        } else if (MsgConstant.EVENT_SUBSCRIBE.equals(eventName)) {
            BaseMsgEvent baseMsgEvent = new BaseMsgEvent();
            baseMsgEvent.setFromUserName(msgIn.getToUserName());
            baseMsgEvent.setToUserName(msgIn.getFromUserName());
            BaseResponser baseResponser = new BaseResponser(baseMsgEvent);
            return baseResponser.createText("test /r/n line2 <br/> line3");
        }
        return null;
    }

    /**
     * init the request as a msg entity
     * 
     * @param document
     */
    public void setRequest(Document document) {
        if (MsgConstant.EVENT_SCAN.equals(eventName)) {
            MsgScan msgScan = new MsgScan();
            // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
            msgScan.setEventKey(CommonTools.getContentFromDocument(document, FieldConstant.EVENT_EVENT_KEY));
            // 二维码的ticket，可用来换取二维码图片
            msgScan.setTicket(CommonTools.getContentFromDocument(document, FieldConstant.EVENT_TICKET));
            msgIn = msgScan;
        } else if (MsgConstant.EVENT_SUBSCRIBE.equals(eventName)) {
            MsgSubscribe msgSubscribe = new MsgSubscribe();
            msgIn = msgSubscribe;
        } else if (true) {
            // TODO
        }
        initMsgHead(document);
    }

    /**
     * common user info
     * 
     * @param document
     * @return
     */
    protected void initMsgHead(Document document) {
        msgIn.setToUserName(CommonTools.getContentFromDocument(document, FieldConstant.HEAD_TO_USER_NAME));
        msgIn.setFromUserName(CommonTools.getContentFromDocument(document, FieldConstant.HEAD_FROM_USER_NAME));
        msgIn.setCreateTime(CommonTools.getContentFromDocument(document, FieldConstant.HEAD_CREATE_TIME));
        msgIn.setMsgType(CommonTools.getContentFromDocument(document, FieldConstant.HEAD_MSG_TYPE));
    }
}
