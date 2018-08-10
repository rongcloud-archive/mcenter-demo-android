package cn.rongcloud.sample.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import cn.rongcloud.sample.MainApp;
import cn.rongcloud.sample.R;
import cn.rongcloud.sample.handle.ConfigHandler;
import io.rong.common.RLog;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static int SPLASH_TIME = 1000;
    private static long startTime;

    private ConfigHandler configHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if ((this.getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) == Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) {
            finish();
            return;
        }
        configHandler = new ConfigHandler(this);
        connectIM();
    }

    private void connectIM() {
        if (!TextUtils.isEmpty(MainApp.token)) {
            startTime = System.currentTimeMillis();
            RongIM.connect(MainApp.token, new RongIMClient.ConnectCallback() {
                @Override
                public void onTokenIncorrect() {
                    RLog.e(TAG, "onTokenIncorrect");
                }

                @Override
                public void onSuccess(String s) {
                    // test_android
                    enterMain();
                    configHandler.setUserId(s);
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RLog.e(TAG, "onError" + errorCode);
                    enterMain();
                }
            });
        }
    }

    private void enterMain() {
        long time = System.currentTimeMillis() - startTime;
        if (time < SPLASH_TIME) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    enter();
                }
            }, SPLASH_TIME - time);
        } else {
            enter();
        }
    }

    private void enter() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
