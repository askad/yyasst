package com.yy.handler;

import org.w3c.dom.Document;

import com.yy.common.CommonTools;
import com.yy.handler.service.send.MsgResponser;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgContentConstant;
import com.yy.msg.normal.event.MsgScan;
import com.yy.msg.normal.event.MsgSubscribe;
import com.yy.msg.normal.msgusr.PoJoArticle;

public class EventHandler extends BaseHandler {
    private String eventName;


    public EventHandler(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 处理消息
     * 
     * @return
     */
    public Document onProcess() {
        if (MsgContentConstant.EVENT_SCAN.equals(eventName)) {

        } else if (MsgContentConstant.EVENT_SUBSCRIBE.equals(eventName)) {
            BaseMsgEvent baseMsgEvent = new BaseMsgEvent();
            baseMsgEvent.setFromUserName(msgIn.getToUserName());
            baseMsgEvent.setToUserName(msgIn.getFromUserName());
            MsgResponser baseResponser = new MsgResponser(baseMsgEvent);
            PoJoArticle[] articles = new PoJoArticle[2];
            PoJoArticle article1 = new PoJoArticle();
            article1.setDescription("desc1");
            article1.setDescription("description1");
            article1.setPicUrl("picUrl1");
            article1.setTitle("title1");
            article1.setUrl("url1");
            PoJoArticle article2 = new PoJoArticle();
            article2.setDescription("desc2");
            article2.setDescription("description2");
            article2.setPicUrl("picUrl2");
            article2.setTitle("title2");
            article2.setUrl("url2");
            articles[0]=article1;
            articles[1]=article2;
            return baseResponser.createImgText(articles);
        }
        return null;
    }

    /**
     * init the request as a msg entity
     * 
     * @param document
     */
    @Override
    public void setRequest(Document document) {
        if (MsgContentConstant.EVENT_SCAN.equals(eventName)) {
            MsgScan msgScan = new MsgScan();
            // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
            msgScan.setEventKey(CommonTools.getContentFromDocument(document, FieldConstant.EVENT_EVENT_KEY));
            // 二维码的ticket，可用来换取二维码图片
            msgScan.setTicket(CommonTools.getContentFromDocument(document, FieldConstant.EVENT_TICKET));
            msgIn = msgScan;
        } else if (MsgContentConstant.EVENT_SUBSCRIBE.equals(eventName)) {
            MsgSubscribe msgSubscribe = new MsgSubscribe();
            msgIn = msgSubscribe;
        } else if (true) {
            // TODO
        }
        initMsgHead(document);
    }
}
