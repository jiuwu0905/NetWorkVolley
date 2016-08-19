package com.android.volley.tool;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.eventtype.ErrorEvent;

/**
 * 结果响应工具
 * Created by Terry on 2016/1/15.
 */
public class ListenerHelper {


    public static ErrorEvent postError(String method) {
        return postError(method, null);
    }

    public static ErrorEvent postError(String method, String msg) {
        ErrorEvent errorEvent = new ErrorEvent(method);
        if (msg != null)
            errorEvent.setMsg(msg);
        return errorEvent;
    }


    // 服务器错误
    public static boolean isServerProblem(Object error) {
        return (error instanceof ServerError)
                || (error instanceof AuthFailureError);
    }

    // 网络异常
    public static boolean isNetworkProblem(Object error) {
        return (error instanceof NetworkError);
    }

    public static String handleServerError(VolleyError error) {

        NetworkResponse response = error.networkResponse;

        if (response != null) {
            switch (response.statusCode) {
                case 404:
                case 422:
                case 401:
                    return error.getMessage();

                default:
                    return "服务器宕机";
            }
        }
        return "generic_error";
    }


}
