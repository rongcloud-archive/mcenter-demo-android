package cn.rongcloud.sample.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.rongcloud.sample.MainApp;
import cn.rongcloud.sample.R;
import cn.rongcloud.sample.utils.StatusBarUtils;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class BaseActivity extends AppCompatActivity {


    private ViewGroup contentLayout;
    protected boolean isFromPush;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        StatusBarUtils.setStatusBar(this);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        contentLayout = findViewById(R.id.layout_content);
        Uri uri = getIntent() != null ? getIntent().getData() : null;
        String params = uri != null ? uri.getQueryParameter("isFromPush") : null;
        isFromPush = params != null && params.equals("true");
        if (isFromPush && RongIM.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.DISCONNECTED)) {
            reconnect();
        }
    }


    @Override
    public void setContentView(View view) {
        contentLayout.addView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        contentLayout.addView(view);
    }

    private void reconnect() {
        RongIM.connect(MainApp.token, null);
    }
}
