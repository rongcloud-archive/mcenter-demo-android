package cn.rongcloud.sample.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.rongcloud.sample.activity.MessageCenterListActivity;
import cn.rongcloud.sample.R;
import cn.rongcloud.sample.utils.StatusBarUtils;
import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;

public class MeFragment extends Fragment {

    private View viewStatusBar;
    private ImageView imgRight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        viewStatusBar = view.findViewById(R.id.view_status_bar);
        ViewGroup.LayoutParams params = viewStatusBar.getLayoutParams();
        params.height = StatusBarUtils.getStatusBarHeight(getContext());
        viewStatusBar.setLayoutParams(params);
        imgRight = view.findViewById(R.id.img_right);
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MessageCenterListActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.tv_title_left).setVisibility(View.GONE);
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
        return view;
    }
}
