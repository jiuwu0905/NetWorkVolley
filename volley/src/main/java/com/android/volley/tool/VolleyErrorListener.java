package com.android.volley.tool;

import com.android.volley.Response;
import com.android.volley.VolleyError;

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
        String text = null;
        // 将错误传递给前端
        if (showError) {
            if (ListenerHelper.isNetworkProblem(error)) {
                text = "网络异常";
            } else {
                text = "网络异常";
            }
        }
        ListenerHelper.postError(method, text);
    }
}
