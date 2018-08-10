package cn.rongcloud.sample.utils;


import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class OsUtils {

    public static boolean isFlyme() {
        try {
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean isMIUI() {
        String line = "";
        BufferedReader input = null;
        String propName = "ro.miui.ui.version.name";
        try {
            java.lang.Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            Log.e("DeviceUtils", "Unable to read sysprop " + propName);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
        return !TextUtils.isEmpty(line);
    }
}
