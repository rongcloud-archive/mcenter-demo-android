package cn.rongcloud.sample.handle.interfaces;


public interface IConfig {

    String getIMToken();

    void setIMToken(String token);

    String getUserId();

    void setUserId(String userId);

    boolean isFirstLogin();

    void setFirstLogin(boolean isFirst);

}
