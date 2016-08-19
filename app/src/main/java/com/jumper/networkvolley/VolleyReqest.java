package com.jumper.networkvolley;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

/**
 * Created by Terry on 2016/8/19.
 */
public class VolleyReqest {


    public static VolleyReqest mInstance;


    private RequestQueue mRequestQueue;

    private VolleyReqest(Context context){
        ArrayMap<String,String> map = new ArrayMap<String , String>();

        map.put("name","hello");

        HttpStack httpStack = new HurlStack(map);
        mRequestQueue  =  Volley.newRequestQueue(context, httpStack);
        mRequestQueue.setDesKey("");

    }


    public static VolleyReqest getInstance(Context context){
        if(mInstance == null){
            mInstance = new VolleyReqest(context.getApplicationContext());
        }
        return mInstance;
    }



    public void addReqesut(Request request){
        mRequestQueue.add(request);
    }

}
