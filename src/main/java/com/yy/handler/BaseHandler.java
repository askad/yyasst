package com.yy.handler;

import org.w3c.dom.Document;

import com.yy.common.CommonTools;
import com.yy.common.FieldConstant;
import com.yy.msg.normal.BaseMsgEntity;

public abstract class BaseHandler {
    protected BaseMsgEntity msgIn;

    public abstract void setRequest(Document document);

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
