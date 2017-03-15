package org.movie.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Describe
 * Created by Wkz on 2017/3/15.
 */
public class ThisTime {
    public static String getTisTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    }
}
