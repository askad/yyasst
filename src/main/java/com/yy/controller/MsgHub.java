package com.yy.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.yy.common.CommonTools;
import com.yy.handler.EventHandler;
import com.yy.handler.UserMsgHandler;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgContentConstant;

public class MsgHub {

    public void onExec(InputStream is, OutputStream os) throws SAXException, IOException {
        // 提出, 解析xml
        Document documentIn = CommonTools.getDocumentBuilder().parse(is);
        Document documentOut = null;
        String msgType = getMsgType(documentIn);
        // 根据MsgType执行不同的handler
        if (MsgContentConstant.MSGTYPE_EVENT.equals(msgType)) {
            // 事件消息
            EventHandler eventHandler = new EventHandler(CommonTools.getContentFromDocument(documentIn,
                    FieldConstant.EVENT_EVENT));
            eventHandler.setRequest(documentIn);
            documentOut = eventHandler.onProcess();
        } else {
            // 文本消息
            UserMsgHandler userMsgHandler = new UserMsgHandler(msgType);
            userMsgHandler.setRequest(documentIn);
            documentOut = userMsgHandler.onProcess();
            // TODO THROW ERROR
        }
        responseResult(documentOut, os);
    }

    private void responseResult(Document document, OutputStream os) {
        try {
            Transformer transformer = CommonTools.getTransformerFactory().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(os, "utf-8")));
        } catch (Exception e) {
            e.printStackTrace();// 保存dom至目输出流
        }
    }

    /**
     * 
     * 
     * @param document
     * @return
     */
    private String getMsgType(Document document) {
        return CommonTools.getContentFromDocument(document, FieldConstant.HEAD_MSG_TYPE);
    }
}
