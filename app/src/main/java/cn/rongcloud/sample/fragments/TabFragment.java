package cn.rongcloud.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.rongcloud.sample.R;
import cn.rongcloud.sample.utils.StatusBarUtils;


public class TabFragment extends Fragment {

    private View statusBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, null);
        statusBar = view.findViewById(R.id.view_status_bar);
        ViewGroup.LayoutParams params = statusBar.getLayoutParams();
        params.height = StatusBarUtils.getStatusBarHeight(getContext());
        statusBar.setLayoutParams(params);
        view.findViewById(R.id.tv_title).setVisibility(View.GONE);
        view.findViewById(R.id.img_right).setVisibility(View.GONE);
        view.findViewById(R.id.view_remid).setVisibility(View.GONE);
        return view;
    }
}
