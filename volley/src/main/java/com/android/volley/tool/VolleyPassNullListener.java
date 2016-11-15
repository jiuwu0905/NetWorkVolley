package com.android.volley.tool;

import com.android.volley.bean.Result;

/**
 * Created by Terry on 2016/11/15 12:04.
 *
 * <p> 这个类很危险。</p>
 * <P> 使用者要自己做非空判断</P>
 * <P> 否则会引起空指针异常</P>
 *
 * @author Terry
 * @version [1.5, 2016/11/15]
 * @since [产品/高危模块]
 */

public class VolleyPassNullListener<T> extends VolleyListener<T> {


    public VolleyPassNullListener() {
    }

    public VolleyPassNullListener(String methodName) {
        super(methodName);
    }

    public VolleyPassNullListener(String methodName, boolean showSuccessMsg) {
        super(methodName, showSuccessMsg);
    }

    public VolleyPassNullListener(String methodName, boolean showSuccessMsg, boolean showSuccessEmptyMsg) {
        super(methodName, showSuccessMsg, showSuccessEmptyMsg);
    }

    /**
     *  将得到数据，回传到界面
     * @param response 结果
     */
    @Override
    public void onResponse(T response) {
        Result<?> result = (Result<?>) response;
        if ( Tools.isNull(result) || result.msg == 0 ) {
            sendErrorMessage(result == null ? null : result.msgbox);
        } else {
            sendOkMessage(result);
        }
    }



}
