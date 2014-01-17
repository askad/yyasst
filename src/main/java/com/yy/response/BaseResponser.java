package com.yy.response;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yy.common.CommonTools;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgConstant;

public class BaseResponser {
    private BaseMsgEvent msg;
    private Document document;

    public BaseResponser(BaseMsgEvent _msg) {
        document = CommonTools.getDocumentBuilder().newDocument();
        msg = _msg;
    }

    public Document createText(String text) {
        msg.setMsgType(MsgConstant.MSGTYPE_TEXT);
        Element root = initHead();
        Element textContent = document.createElement(FieldConstant.RES_TEXT_CONTENT);
        textContent.setTextContent(text);
        root.appendChild(textContent);
        document.appendChild(root);
        return this.document;
    }

    private Element initHead() {

        msg.setCreateTime(CommonTools.getCurrentTime());

        Element root = document.createElement(FieldConstant.HEAD_ROOT);
        Element toUserNameElement = document.createElement(FieldConstant.HEAD_TO_USER_NAME);
        toUserNameElement.setTextContent(msg.getToUserName());
        Element fromUserNameElement = document.createElement(FieldConstant.HEAD_FROM_USER_NAME);
        fromUserNameElement.setTextContent(msg.getFromUserName());
        Element createTimeElement = document.createElement(FieldConstant.HEAD_CREATE_TIME);
        createTimeElement.setTextContent(msg.getCreateTime());
        Element msgTypeElement = document.createElement(FieldConstant.HEAD_MSG_TYPE);
        msgTypeElement.setTextContent(msg.getMsgType());

        root.appendChild(toUserNameElement);
        root.appendChild(fromUserNameElement);
        root.appendChild(createTimeElement);
        root.appendChild(msgTypeElement);
        return root;
    }
}
