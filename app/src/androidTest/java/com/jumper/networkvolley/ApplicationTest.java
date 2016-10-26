package com.jumper.networkvolley;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.android.volley.bean.ResultList;
import com.jumper.networkvolley.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }




    public void testResult(){
        ResultList resultList = new ResultList<UserInfo>();
        List<UserInfo> infos = new ArrayList<>();
        infos.add(new UserInfo());


        resultList.data = infos;

        Log.d("Terry",resultList.data.getClass()+"");

    }
}