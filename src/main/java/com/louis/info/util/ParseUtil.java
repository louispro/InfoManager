package com.louis.info.util;

/**
 * 赖小燚
 * www.louis.com
 */
public class ParseUtil {

    public static String parseParamIsIdPhoneEmail(String userKey){
        if(userKey.length()==8){
            return "id";    //用户用id登录
        }
        if(userKey.length()==11){
            return "phonenumber";   //用户用手机号登录
        }
        return "email"; //用户用邮箱登录
    }

    /**
     * 将字符串转为数字
     * @param str
     * @return
     */
    public static Integer parseString2Int(String str){
        if(str!=null && str!=""){
            return Integer.parseInt(str);
        }
        return 1;
    }
}
