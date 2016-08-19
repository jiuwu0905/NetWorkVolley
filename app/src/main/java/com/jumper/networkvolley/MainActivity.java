package com.jumper.networkvolley;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.bean.Result;
import com.android.volley.tool.VolleyListener;
import com.android.volley.toolbox.GsonListRequest;
import com.google.gson.reflect.TypeToken;
import com.jumper.networkvolley.bean.UserInfo;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            }
        });





    }


    public void onEvent(Result<?> result){
        Log.d("Terry", ((UserInfo) result.data.get(0)).toString());
    }




    public  void getUserInfo(){
        String method = "jumper.usercenter.get.userInfo";
        String url = " http://mobile.jumper-health.com/mobile/api/v3/handler.do?method=jumper.usercenter.get.userInfo&params=60ABA304E94758C8F0B757FC16ED1CAAC9622D209253F0A347AE7E40DB5DA21C&sign=DBFABC63F8E9571C8E98BF4E014ADB54";
        GsonListRequest<Result<UserInfo>> gsonListRequest = new GsonListRequest<Result<UserInfo>>(url,
                new TypeToken<Result<UserInfo>>(){}.getType(),
                new VolleyListener<Result<UserInfo>>(),null,true);
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
