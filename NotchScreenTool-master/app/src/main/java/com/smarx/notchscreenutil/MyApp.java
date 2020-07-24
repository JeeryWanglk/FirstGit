package com.smarx.notchscreenutil;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyApp extends Application {
    public static final String APP_ID = "b5cf0a67f6"; // TODO 替换成bugly上注册的appid
    public static final String APP_CHANNEL = "DEBUG"; // TODO 自定义渠道
    @Override
    public void onCreate() {
        super.onCreate();
        Density.setDensity(this,415);
//        Context context = getApplicationContext();
//// 获取当前包名
//        String packageName = context.getPackageName();
//// 获取当前进程名
//        String processName = getProcessName(android.os.Process.myPid());
//// 设置是否为上报进程
//        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
//        CrashReport.initCrashReport(context, "a3ebace431", false, strategy);

        CrashReport.initCrashReport(getApplicationContext());
        Bugly.init(getApplicationContext(), "93467a20ca", true);



//        CrashReport.initCrashReport(getApplicationContext());

    }

    private String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

}
