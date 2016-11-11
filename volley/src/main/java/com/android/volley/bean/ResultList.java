package com.android.volley.bean;

import java.util.List;

/**
 * Created by Terry on 2016/10/26.
 */

public class ResultList<T> extends Result<List<T>>{



    public T getFirstItem() {
        if(data == null) return null;
        List<T> list = (List<T>)data;
        if(list.isEmpty() ) return null;
        return list.get(0);
    }



    public boolean isEmpty(){
        if(data == null) return false;
        return data.isEmpty();
    }


}
