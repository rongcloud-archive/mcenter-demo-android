package cn.rongcloud.sample.activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.rongcloud.sample.R;

public class ConversationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView btnBack;
    private TextView tvTitle;

    private boolean isFromPush;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        initView();

        Uri uri = getIntent() != null ? getIntent().getData() : null;
        String params = uri != null ? uri.getQueryParameter("isFromPush") : null;
        isFromPush = params != null && params.equals("true");
    }

    private void initView() {
        btnBack = findViewById(R.id.icon_back);
        tvTitle = findViewById(R.id.txt_title);
        btnBack.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            String targetId = intent.getData().getQueryParameter("targetId");
            String title = intent.getData().getQueryParameter("title");
            setTitle(title);
        }
    }

    private void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (isFromPush) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        finish();
    }
}
