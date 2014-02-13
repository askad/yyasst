package com.yy.handler.service.recv;

import java.util.Random;

import org.w3c.dom.Document;

import yy.weibo.service.WeiboTrafficService;

import com.yy.common.ControlConstant;
import com.yy.common.TipConstant;
import com.yy.handler.service.MsgRecvService;
import com.yy.handler.service.send.MsgResponser;
import com.yy.msg.normal.BaseMsgEntity;
import com.yy.msg.normal.BaseMsgEvent;
import com.yy.msg.normal.msgusr.MsgUserText;

public class MsgTextServiceImpl implements MsgRecvService {

    public Document onService(BaseMsgEntity msgIn) {
        MsgUserText msgInText = (MsgUserText) msgIn;
        String result = parseText(msgInText.getContent());
        if (result == null) {
            result = msgIn.getFromUserName() + TipConstant.TIP_DEFAULT_WARING;
        }
        BaseMsgEvent baseMsgEvent = new BaseMsgEvent();
        baseMsgEvent.setFromUserName(msgIn.getToUserName());
        baseMsgEvent.setToUserName(msgIn.getFromUserName());
        MsgResponser baseResponser = new MsgResponser(baseMsgEvent);
        return baseResponser.createText(result);
    }

    private String parseText(String text) {
        if (ControlConstant.OPTIONAL_0.equals(text)) {
            // TODO
            return "Zzzz.....";
        }
        if (ControlConstant.TRAFFIC_1.equals(text)) {
            WeiboTrafficService wts = new WeiboTrafficService();
            return wts.getTextFromSc();
        }
        if (ControlConstant.EGGS_2.equals(text)) {
            Random random = new Random();
            int i = Math.abs(random.nextInt()) % TipConstant.TIP_MAGIC_EGGS.length;
            return TipConstant.TIP_MAGIC_EGGS[i];
        }
        // TODO
        return null;
    }
}
