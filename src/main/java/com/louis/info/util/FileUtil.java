package com.louis.info.util;

/**
 * 赖小燚
 * www.louis.com
 */
public class FileUtil {

    public static boolean isImage(String format){
        if("jpg".equals(format) || "jpeg".equals(format) || "png".equals(format)){
            return true;
        }
        return false;
    }
}
