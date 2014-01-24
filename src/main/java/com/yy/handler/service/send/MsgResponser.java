package com.yy.handler.service.send;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.yy.common.CommonTools;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.FieldConstant;
import com.yy.msg.normal.MsgContentConstant;
import com.yy.msg.normal.msgusr.PoJoArticle;

public class MsgResponser {
    private BaseMsgEvent msg;
    private Document document;

    public MsgResponser(BaseMsgEvent _msg) {
        document = CommonTools.getDocumentBuilder().newDocument();
        msg = _msg;
    }

    public Document createText(String text) {
        msg.setMsgType(MsgContentConstant.MSGTYPE_TEXT);
        Element root = initHead();
        Element textContent = document.createElement(FieldConstant.RES_TEXT_CONTENT);
        textContent.setTextContent(text);
        root.appendChild(textContent);
        document.appendChild(root);
        return this.document;
    }

    public Document createImgText(PoJoArticle[] articles) {
        msg.setMsgType(MsgContentConstant.MSGTYPE_NEWS);
        Element root = initHead();
        Element artCount = document.createElement(FieldConstant.RES_TEXT_ArticleCount);
        artCount.setTextContent(Integer.toString(articles.length));
        root.appendChild(artCount);

        Element articlesNode = document.createElement(FieldConstant.RES_TEXT_Articles);
        for (PoJoArticle poJoArticle : articles) {
            Element itemNode = document.createElement(FieldConstant.RES_TEXT_Article_ITEM);

            Element titleNode = document.createElement(FieldConstant.RES_TEXT_Article_Title);
            titleNode.setTextContent(poJoArticle.getTitle());
            itemNode.appendChild(titleNode);

            Element descNode = document.createElement(FieldConstant.RES_TEXT_Article_Description);
            descNode.setTextContent(poJoArticle.getDescription());
            itemNode.appendChild(descNode);

            Element picUrlNode = document.createElement(FieldConstant.RES_TEXT_Article_PicUrl);
            descNode.setTextContent(poJoArticle.getPicUrl());
            itemNode.appendChild(picUrlNode);

            Element urlNode = document.createElement(FieldConstant.RES_TEXT_Article_Url);
            descNode.setTextContent(poJoArticle.getUrl());
            itemNode.appendChild(urlNode);
            articlesNode.appendChild(itemNode);
        }
        root.appendChild(articlesNode);

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
