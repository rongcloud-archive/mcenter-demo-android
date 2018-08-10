package cn.rongcloud.sample.views;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import cn.rongcloud.sample.R;


public class CustomTabView extends FrameLayout {

    private ImageView imageView;
    private TextView textView;

    public CustomTabView(Context context) {
        super(context);
        initView();
    }

    public CustomTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        removeAllViews();
        inflate(getContext(), R.layout.layout_tab_view, this);
        imageView = findViewById(R.id.img_icon);
        textView = findViewById(R.id.tv_text);
    }

    public CustomTabView setIcon(@DrawableRes int resId) {
        imageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), resId));
        return this;
    }

    public CustomTabView setText(@StringRes int resId) {
        textView.setText(getResources().getText(resId));
        textView.setTextColor(getResources().getColorStateList(R.color.selector_color_tab));
        return this;
    }

}
