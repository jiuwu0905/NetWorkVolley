package com.android.volley.bean;

/**
 * Created by Terry on 2016/8/19.
 * 单对象请求
 */
public class SingleResult<T> extends Info {


    // 单一的对象。
    public T data;

    // 请求的方法名
    public String method;


    /**
     * 为请求框架做个兼容。<br>
     *
     * <strong>这里自已本地构建一个Result</strong>
     *
     * <p>此处主要是用来解决后台，越来越多人开发，越来越乱，不愿意按照约定的来写，
     * 都自以为自己写得很好，很历害。<strong>殊不知约定 大于 效率。。</strong>
     * </p>
     *
     * <p>可以有更简单的方法，来实现。但是现有的实现Result 的Activity
     * 太多了，改起来成本太高，而且容易出问题 </p>
     *
     *
     *
     *
     * @return
     */
//    public  Result<T> getResult(){
//        Result<T> rst = new Result<>();
//        rst.method = this.method;
//        rst.data = new ArrayList<T>();
//        rst.data.add(data);
//        rst.msg = msg;
//        rst.msgbox = msgbox;
//        return rst;
//
//    }








}
