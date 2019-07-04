package com.qwer.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class EncoderUtil {
    private final static Logger logger = LoggerFactory.getLogger("EncoderUtil");

    public static String decode(String result) {
        try {
            result = java.net.URLDecoder.decode(result,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info(e.getMessage());
        }
        return result;
    }

    public static String encode(String result){
        try {
            result = java.net.URLEncoder.encode(result,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info(e.getMessage());
        }
        return result;
    }
}
