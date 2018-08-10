package cn.rongcloud.sample;


import android.app.ActivityManager;
import android.content.Context;
import android.support.multidex.MultiDexApplication;


import cn.rongcloud.sample.utils.MessageRegisterUtils;
import io.rong.imkit.RongIM;
import io.rong.push.RongPushClient;

public class MainApp extends MultiDexApplication {

    public static final String token = "p231+cZXG2VzW+D7UpYmXF6rCy170azbkluZ+cdh/U74f94eExPm8SPWoUT4AZzoWpYi1LTJ1LCT/LmD+Lqo7A==";

    @Override
    public void onCreate() {
        super.onCreate();
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
            RongPushClient.registerMiPush(this, "2882303761517840981", "5941784045981");
            RongPushClient.registerMZPush(this, "114796", "2d70bedf188345fb8303d48a026c5694");
            RongPushClient.registerHWPush(this);
            RongIM.init(this);
            RongIM.getInstance().enableUnreadMessageIcon(true);
            MessageRegisterUtils.registerMessages();
        }
    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
