package cn.rongcloud.sample.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.rongcloud.sample.R;
import cn.rongcloud.sample.handle.ConfigHandler;
import cn.rongcloud.sample.handle.interfaces.IConfig;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.mcenter.fragments.MessageCenterListFragment;
import io.rong.mcenter.messages.MCCommunityHelpInfo;
import io.rong.mcenter.messages.MCInteractionLiked;
import io.rong.push.RongPushClient;

public class MessageCenterListActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private ImageView btnBack;

    private IConfig config;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        initView();
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null && intent.getData().getScheme() != null
                && intent.getData().getScheme().equals("rong") && intent.getData().getQueryParameter("isFromPush") != null
                && intent.getData().getQueryParameter("isFromPush").equals("true")) {
            // 统计华为push点击事件。
            RongPushClient.recordHWNotificationEvent(intent);
        }
        config = new ConfigHandler(this);
        insertMessages();
    }

    private void initView() {
        tvTitle = findViewById(R.id.txt_title);
        tvTitle.setText(getString(R.string.text_title));
        btnBack = findViewById(R.id.icon_back);
        btnBack.setOnClickListener(this);
        initMessageListFragment();
    }

    private void initMessageListFragment() {
        MessageCenterListFragment messageCenterListFragment = new MessageCenterListFragment();
        messageCenterListFragment.init(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.rl_mcenterlist, messageCenterListFragment).commitAllowingStateLoss();
    }

    private void insertMessages() {
        if (config.isFirstLogin()) {
            config.setFirstLogin(false);
            // 社区帮助消息
            MCCommunityHelpInfo helpInfo = new MCCommunityHelpInfo();
            helpInfo.setContent("有个问题向你求助：小唐山 有停车位吗？");
            helpInfo.setOpreatorName("小胖");
            helpInfo.setOpreatorPortraitUrl("https://rongcloud-res.cn.ronghub.com/70cb59b054e5e7587ea1750adf074849");
            helpInfo.setContentUrl("http://www.rongcloud.cn");
            RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.SYSTEM,
                    "rong_system_community",
                    "rong_system_community", new Message.ReceivedStatus(8), helpInfo, null);

            //互动点赞消息
            MCInteractionLiked liked = new MCInteractionLiked();
            liked.setContentUrl("http://www.rongcloud.cn");
            liked.setOpreatorPortraitUrl("https://rongcloud-res.cn.ronghub.com/70cb59b054e5e7587ea1750adf074849");
            liked.setOpreatorName("小胖");
            RongIM.getInstance().insertIncomingMessage(Conversation.ConversationType.SYSTEM,
                    "rong_system_interaction",
                    "rong_system_interaction", new Message.ReceivedStatus(8),liked,null);
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
