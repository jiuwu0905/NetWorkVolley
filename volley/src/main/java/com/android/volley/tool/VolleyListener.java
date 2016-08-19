package com.android.volley.tool;

import com.android.volley.Response;
import com.android.volley.bean.Result;
import com.android.volley.eventtype.ErrorEvent;
import com.android.volley.eventtype.EventRequestOk;

import de.greenrobot.event.EventBus;

/**
 * 网络请求结果响应
 * Created by Terry on 2016/1/15.
 */
public class VolleyListener<T> implements Response.Listener<T> {

    public String methodName;
    /**
     * 显示成功消息与否
     */
    boolean mShowSuccessMsg = false;
    /**
     * 显示成功的，数据为空消息与否
     */
    boolean mShowSuccessEmptyMsg = true;

    public VolleyListener() {
    }

    /**
     * 构造一个Volley 结果监听
     *  默认不会显示成功的消息，<br>
     *  会显示结果是空集时候的消息
     *
     *  @see #VolleyListener(String, boolean, boolean)
     *
     * @param methodName 请求的方法名
     */
    public VolleyListener(String methodName) {
        this(methodName,false,true);
    }


    /**
     * 构造一个Volley 结果监听
     * @param methodName 请求的方法名
     * @param showSuccessMsg 显示成成消息与否
     */
    public VolleyListener(String methodName, boolean showSuccessMsg) {
        this(methodName,showSuccessMsg,true);
    }

    /**
     * 构造一个Volley 结果监听
     * @param methodName 请求的方法名
     * @param showSuccessMsg 显示成成消息与否
     * @param showSuccessEmptyMsg 显示成功的，数据为空消息与否
     */
    public VolleyListener(String methodName, boolean showSuccessMsg,
                          boolean showSuccessEmptyMsg) {
        this.methodName = methodName;
        this.mShowSuccessMsg = showSuccessMsg;
        this.mShowSuccessEmptyMsg = showSuccessEmptyMsg;
    }

    /**
     *  将得到数据，回传到界面
     * @param response 结果
     */
    @Override
    public void onResponse(T response) {
        Result<?> result = (Result<?>) response;
        if (Tools.isNull(result) || result.msg == 0 ||
                Tools.isDataNull(result)) {
            sendErrorMessage(result == null ? null : result.msgbox);
        } else {
            sendOkMessage(result);
        }
    }


    /**
     * 发送成功消息
     * @param result  结果
     */
    protected void sendOkMessage(Result result){
        boolean isShowTip;
        if (Tools.isEmpty(result)) {
            isShowTip = mShowSuccessEmptyMsg;
        } else {
            isShowTip = mShowSuccessMsg;
        }
        sendOkMessage(result, methodName, isShowTip);
    }


    /**
     *  发送失败消息
     * @param msg 消息文字
     */
    protected void sendErrorMessage(String msg){
        ErrorEvent e = ListenerHelper.postError(methodName, msg );
        EventBus.getDefault().post(e);
    }


    /**
     * 发送ok 消息
     * @param result 结果
     * @param methodName 请求方法名
     * @param isShowTip 是否显示后台给的提示
     */
    protected void sendOkMessage(Result<?> result, String methodName, boolean isShowTip) {
        if (methodName != null) {
            result.method = methodName;
        }
        if (isShowTip) {
            EventBus.getDefault().post(new EventRequestOk(
                    result.msgbox));
        }
        EventBus.getDefault().post(result);
    }

}
