package org.movie.util;

/**
 * 获取uuid实体类
 * Created by Wkz on 2017/3/15.
 */
public class UUID {
    /**
     * 获取uuid
     * @return 返回字符串类型的uuid
     */
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString();
    }
}
