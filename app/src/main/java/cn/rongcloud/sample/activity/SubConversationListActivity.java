package cn.rongcloud.sample.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import cn.rongcloud.sample.R;
import io.rong.imkit.widget.adapter.SubConversationListAdapter;
import io.rong.mcenter.fragments.MCSubConversationListFragment;

public class SubConversationListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subconversationlist);
        MCSubConversationListFragment fragment = new MCSubConversationListFragment();
        fragment.setAdapter(new SubConversationListAdapter(this));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fr_container, fragment);
        transaction.commitAllowingStateLoss();
        findViewById(R.id.icon_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
