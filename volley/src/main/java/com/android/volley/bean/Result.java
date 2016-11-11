package com.android.volley.bean;

/**
 * Created by Terry on 2016/8/19.
 * 京柏 旧数所交互类
 */
public class Result<T> extends  Info {


    //由于早期约定 data  一定是个数组【】,
    // 所以早期框架也就定死。
    public T data;


    /**
     * 请求的方法名
     */
    public String method;


    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", method='" + method + '\'' +
                '}';
    }





    public T getSingleItem(){
        if(data == null ) return null;
        return data;
    }


    public boolean isEmpty(){
        return data == null;
    }



}
