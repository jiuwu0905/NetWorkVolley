package com.android.volley.tool;

import android.util.Log;

import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.bean.Info;

import de.greenrobot.event.EventBus;

/**
 *
 *
 * Created by Terry on 2016/1/15.
 */
public class VolleyErrorListener implements Response.ErrorListener {

    public String method;
    public boolean showError = true;

    public VolleyErrorListener() {
    }


    public VolleyErrorListener(String method) {
        this.method = method;
    }


    public VolleyErrorListener(boolean showError) {
        this.showError = showError;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Terry","volley报错。。。",error);
        String text = null;
        Info info = null;

        if(error instanceof ParseError){
            info = ((ParseError)error).getInfo();
        }

        // 将错误传递给前端
        if (showError) {
            if (ListenerHelper.isNetworkProblem(error)) {
                text = "网络异常";
            } else {
                text = (info == null?"网络异常":info.msgbox);
            }
        }
        EventBus.getDefault().post(ListenerHelper.postError(method, text)) ;
    }
}
