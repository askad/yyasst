package com.yy.handler;

import org.w3c.dom.Document;

import com.yy.common.CommonTools;
import com.yy.common.FieldConstant;
import com.yy.common.MsgContentConstant;
import com.yy.handler.service.MsgRecvService;
import com.yy.handler.service.recv.MsgTextServiceImpl;
import com.yy.msg.normal.msgusr.MsgUserText;

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
            
            MsgRecvService msgRecvService = new MsgTextServiceImpl();
            msgRecvService.onService(msgIn);
            // return null
        } else if (MsgContentConstant.MSGTYPE_IMAGE.equals(msgType)) {

        } else if (MsgContentConstant.MSGTYPE_LOCATION.equals(msgType)) {

        } else if (MsgContentConstant.MSGTYPE_VOICE.equals(msgType)) {

        } else if (MsgContentConstant.MSGTYPE_VIDEO.equals(msgType)) {

        } else if (MsgContentConstant.MSGTYPE_LINK.equals(msgType)) {

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
