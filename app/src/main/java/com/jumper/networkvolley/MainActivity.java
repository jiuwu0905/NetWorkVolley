package com.jumper.networkvolley;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.VolleyLog;
import com.android.volley.bean.Result;
import com.android.volley.bean.SingleResult;
import com.android.volley.tool.SingleObjectVolleyListener;
import com.android.volley.tool.VolleyErrorListener;
import com.android.volley.tool.VolleyListener;
import com.android.volley.toolbox.GsonListRequest;
import com.google.gson.reflect.TypeToken;
import com.jumper.networkvolley.bean.NewsDetails;
import com.jumper.networkvolley.bean.UserInfo;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VolleyLog.RESULT_DEBUG = true;


        EventBus.getDefault().register(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getUserInfo();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getNewsDetails();
            }
        });





    }


    public void onEvent(Result result){
        if("jumper.usercenter.get.userInfo".equals(result.method)){
            Log.d("Terry", ((UserInfo) result.data.get(0)).toString());
        }else{
            if(result.data.isEmpty()) return;
            Log.d("Terry",((NewsDetails)result.data.get(0)).toString());
        }
    }




    public  void getUserInfo(){
        String method = "jumper.usercenter.get.userInfo";
        String url = " http://mobile.jumper-health.com/mobile/api/v3/handler.do?method=jumper.usercenter.get.userInfo&params=60ABA304E94758C8F0B757FC16ED1CAAC9622D209253F0A347AE7E40DB5DA21C&sign=DBFABC63F8E9571C8E98BF4E014ADB54";
        GsonListRequest<Result<UserInfo>> gsonListRequest = new GsonListRequest<Result<UserInfo>>(url,
                new TypeToken<Result<UserInfo>>() {
                }.getType(),
                new VolleyListener<Result<UserInfo>>(method),
                new VolleyErrorListener(), true);
        VolleyReqest.getInstance(this).addReqesut(gsonListRequest);
    }

//http://mobile.jumper-health.com:80/mobile/api/handler.do?method=jumper.news.news.newsDetail&params=563D78FEF6EFF8BE81D4245DE9FB86418131129C5C6D34BBB4FC007215C65692DF5B78DAEF0164BA3B3AD6444AC72CCA447D447A8C73FEA1E2CBCE37735A7D42A4C7103FC11A3BEAD0E33E4D85AB97D057CE648C75429734&sign=28B9DEC6259EE924398CD35B53E1AFFF


    public void getNewsDetails(){
        String method = "jumper.news.news.newsDetail";
        String url = "http://mobile.jumper-health.com:80/mobile/api/handler.do?method=jumper.news.news.newsDetail&params=563D78FEF6EFF8BE81D4245DE9FB86418131129C5C6D34BBB4FC007215C65692DF5B78DAEF0164BA3B3AD6444AC72CCA447D447A8C73FEA1E2CBCE37735A7D42A4C7103FC11A3BEAD0E33E4D85AB97D057CE648C75429734&sign=28B9DEC6259EE924398CD35B53E1AFFF";
        GsonListRequest<SingleResult<NewsDetails>> gsonListRequest = new GsonListRequest<SingleResult<NewsDetails>>(url,
                new TypeToken<SingleResult<NewsDetails>>() {
                }.getType(),
                new SingleObjectVolleyListener<SingleResult<NewsDetails>>(method),
                new VolleyErrorListener(), true);
        VolleyReqest.getInstance(this).addReqesut(gsonListRequest);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
