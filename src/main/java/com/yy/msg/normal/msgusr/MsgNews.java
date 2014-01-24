package com.yy.msg.normal.msgusr;

import com.yy.msg.normal.BaseMsgEntity;
import com.yy.msg.normal.MsgContentConstant;

public class MsgNews extends BaseMsgEntity {

    /** 图文消息个数，限制为10条以内 */
    private String articleCount;
    /** 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应 */
    private PoJoArticle[] articles;

    public MsgNews() {
        setMsgType(MsgContentConstant.MSGTYPE_NEWS);// 消息类型，news
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public PoJoArticle[] getArticles() {
        return articles;
    }

    public void setArticles(PoJoArticle[] articles) {
        this.articles = articles;
    }
}
