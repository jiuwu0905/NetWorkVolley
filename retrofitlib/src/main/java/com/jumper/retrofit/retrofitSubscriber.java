package com.jumper.retrofit;

import com.android.volley.bean.Result;
import com.android.volley.eventtype.ErrorEvent;
import com.android.volley.eventtype.EventRequestOk;
import com.android.volley.tool.Tools;

import de.greenrobot.event.EventBus;
import rx.Subscriber;

/**
 * Created by Terry on 2016/10/26.
 *
 *
 */

public class RetrofitSubscriber extends Subscriber<Result>{


    /**
     * 方法名
     */
    public String method;


    public boolean showLoading;

    /**
     * 显示成功的，数据为空消息与否
     */
    private boolean mShowSuccessEmptyMsg = true;



    public RetrofitSubscriber(){

    }




    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        EventBus.getDefault().post(new ErrorEvent(method));
    }

    @Override
    public void onNext(Result r) {

        // handle error
        if(Tools.isNull(r) || Tools.isDataNull(r) || r.msg == 0){
            ErrorEvent errorEvent = new ErrorEvent(method);
            if (r != null && r.msgbox != null)
                errorEvent.setMsg(r.msgbox);
            EventBus.getDefault().post(errorEvent);
        }else{ // handle ok

            if(Tools.isEmpty(r) && mShowSuccessEmptyMsg){
                EventBus.getDefault().post(new EventRequestOk(
                        r.msgbox));
            }

            r.method = method;

            EventBus.getDefault().post(r);

        }
    }



    public static class Builder{

        RetrofitSubscriber rs = null;


        public Builder(){
            rs = new RetrofitSubscriber();
        };


        public Builder setMethodStr(String methodStr){
            rs.method = methodStr;
            return this;
        }


        public Builder setProgressShow(boolean showLoading){
            rs.showLoading = showLoading;
            return this;
        }


        public Builder setShowSuccessEmptyMsg(boolean showSuccessEmptyMsg){
            rs.mShowSuccessEmptyMsg = showSuccessEmptyMsg;
            return this;
        }


        public RetrofitSubscriber create(){
            return rs;
        }



    }

}
