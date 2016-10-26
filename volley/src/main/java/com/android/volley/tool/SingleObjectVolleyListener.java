package com.android.volley.tool;

import android.text.TextUtils;

import com.android.volley.bean.SingleResult;

/**
 * Created by Terry on 2016/8/19.
 * 单对象结果。
 */
public class SingleObjectVolleyListener<T> extends VolleyListener<T>{


    public SingleObjectVolleyListener() {
    }

    public SingleObjectVolleyListener(String methodName) {
        super(methodName);
    }

    public SingleObjectVolleyListener(String methodName, boolean showSuccessMsg) {
        super(methodName, showSuccessMsg);
    }

    public SingleObjectVolleyListener(String methodName, boolean showSuccessMsg, boolean showSuccessEmptyMsg) {
        super(methodName, showSuccessMsg, showSuccessEmptyMsg);
    }

    /**
     * 回调到界面上
     * @param response 结果
     */
    @Override
    public void onResponse(T response) {
        if( null == response){
            sendErrorMessage(null);
            return ;
        }

        SingleResult<?> result = (SingleResult<?>)response;

        if(null == result.data ){
            sendErrorMessage(TextUtils.isEmpty(result.method)?null:result.method);
            return ;
        }

//        sendOkMessage(result.getResult());
        //Result<T> fixResult = result.getResult();
    }
}
