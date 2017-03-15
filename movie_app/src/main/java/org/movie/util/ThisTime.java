package org.movie.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * Created by Wkz on 2017/3/15.
 */
public class ThisTime {
    /**
     * 获取当前系统时间
     * @return 返回字符串类型的时间
     */
    public static String getTisTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    }
}
