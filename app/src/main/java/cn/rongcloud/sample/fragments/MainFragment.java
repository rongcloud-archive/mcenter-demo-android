package cn.rongcloud.sample.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.rongcloud.sample.R;
import cn.rongcloud.sample.activity.MessageCenterListActivity;
import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        final View remind = view.findViewById(R.id.view_remid);
        RongIM.getInstance().addUnReadMessageCountChangedObserver(new IUnReadMessageObserver() {
            @Override
            public void onCountChanged(int i) {
                if (i > 0) {
                    remind.setVisibility(View.VISIBLE);
                } else {
                    remind.setVisibility(View.GONE);
                }
            }
        }, Conversation.ConversationType.SYSTEM, Conversation.ConversationType.PRIVATE, Conversation.ConversationType.GROUP);
        ImageView messages = view.findViewById(R.id.img_right);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageCenterListActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
