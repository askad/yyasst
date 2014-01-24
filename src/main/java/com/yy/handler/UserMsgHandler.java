package com.yy.handler;

import org.w3c.dom.Document;

import com.yy.common.CommonTools;
import com.yy.handler.service.send.MsgResponser;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgContentConstant;
import com.yy.msg.normal.msgusr.MsgUserText;
import com.yy.msg.normal.msgusr.PoJoArticle;

public class UserMsgHandler extends BaseHandler {

    private String msgType;

    public UserMsgHandler(String _msgType) {
        this.msgType = _msgType;
    }

    /**
     * 处理消息
     * 
     * @return
     */
    public Document onProcess() {
        if (MsgContentConstant.MSGTYPE_TEXT.equals(msgType)) {
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
            articles[0] = article1;
            articles[1] = article2;
            return baseResponser.createImgText(articles);
        }
        return null;
    }

    /**
     * init the request as a msg entity
     * 
     * @param document
     */
    public void setRequest(Document document) {
        if (MsgContentConstant.MSGTYPE_TEXT.equals(msgType)) {
            MsgUserText msgUserText = new MsgUserText();
            msgUserText.setContent(CommonTools.getContentFromDocument(document, FieldConstant.USR_MSG_CONTENT));
            msgUserText.setMsgId(CommonTools.getContentFromDocument(document, FieldConstant.USR_MSG_MSGID));
            msgIn = msgUserText;
        } else if (true) {
            // TODO
        }
        initMsgHead(document);
    }

}
