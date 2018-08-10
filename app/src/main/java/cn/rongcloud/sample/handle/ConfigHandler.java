package cn.rongcloud.sample.handle;


import android.content.Context;
import android.content.SharedPreferences;

import cn.rongcloud.sample.handle.interfaces.IConfig;

public class ConfigHandler implements IConfig {

    SharedPreferences imConfig;

    public ConfigHandler(Context context) {
        imConfig = context.getSharedPreferences("imconfig", Context.MODE_PRIVATE);
    }

    @Override
    public String getIMToken() {
        return imConfig.getString("token", "");
    }

    @Override
    public void setIMToken(String token) {
        imConfig.edit().putString("token", token).apply();
    }

    @Override
    public String getUserId() {
        return imConfig.getString("userId", "");
    }

    @Override
    public void setUserId(String userId) {
        imConfig.edit().putString("userId", userId).apply();
    }

    @Override
    public boolean isFirstLogin() {
        return imConfig.getBoolean("isFirst", true);
    }

    @Override
    public void setFirstLogin(boolean isFirst) {
        imConfig.edit().putBoolean("isFirst", false).apply();
    }


}
