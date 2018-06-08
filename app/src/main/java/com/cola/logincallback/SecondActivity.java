package com.cola.logincallback;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements LoginCallback{

    private static final String TAG = SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 注册回调接口
        LoginManager.getInstance().addLoginCallback(this);
        Button button = (Button)findViewById(R.id.in_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void loginIn() {
        Log.e(TAG, "用户登录了");
    }

    @Override
    public void loginOut() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoginManager.getInstance().removeLoginCallback(this);
    }
}
