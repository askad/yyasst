package com.yy.common;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;

public class CommonTools {
    /** Document构建类 */
    private static DocumentBuilder builder;
    private static TransformerFactory tffactory;
    static {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        // 格式化工厂对象
        tffactory = TransformerFactory.newInstance();
    }

    public static DocumentBuilder getDocumentBuilder() {
        return builder;
    }

    public static TransformerFactory getTransformerFactory() {
        return tffactory;
    }

    public static String getContentFromDocument(Document document, String name) {
        return document.getElementsByTagName(name).item(0).getTextContent();
    }

    public static String getCurrentTime() {
        return Long.toString(new Date().getTime());
    }
}
