package com.android.volley.tool;

import com.android.volley.bean.Result;

import java.util.List;

/**
 * Created by Terry on 2016/8/19.
 *  工具类
 */
public class Tools {



    public static boolean isNull(Result<?> info) {
        if (info == null) {
            return true;
        }
        return false;
    }

    public static boolean isDataNull(Result<?> info) {
        if (info.data == null) {
            return true;
        }
        return false;
    }



    public static boolean isEmpty(Result<?> info) {
        if(info.data instanceof List){
            return ((List)info.data).isEmpty();
        }
       return false;
    }
}
