package com.yy.handler.service;

import org.w3c.dom.Document;

import com.yy.msg.normal.BaseMsgEntity;

public interface MsgRecvService {
    public Document onService(BaseMsgEntity msgIn);
}
