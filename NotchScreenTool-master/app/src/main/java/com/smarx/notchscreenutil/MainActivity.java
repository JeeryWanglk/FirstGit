package com.smarx.notchscreenutil;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.Calendar;


public class MainActivity extends BaseActivity {

    private TextView five;
    private static long lastClickTime;
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        five = findViewById(R.id.five);
        Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DAY_OF_WEEK) == 1){
            five.setText("手机型号: "+Build.MODEL+" 今天是周日");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 2){
            five.setText("手机型号: "+Build.MODEL+" 今天是周一");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 3){
            five.setText("手机型号: "+Build.MODEL+" 今天是周二");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 4){
            five.setText("手机型号: "+Build.MODEL+" 今天是周三");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 5){
            five.setText("手机型号: "+Build.MODEL+" 今天是周四");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 6){
            five.setText("手机型号: "+Build.MODEL+" 今天是周五");
        }else if (c.get(Calendar.DAY_OF_WEEK) == 7){
            five.setText("手机型号: "+Build.MODEL+" 今天是周六");
        }
        TextView six = findViewById(R.id.six);
        six.setText("没有声明six控件");
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long curClickTime = System.currentTimeMillis();//第一次点击的时间
                if ((curClickTime - lastClickTime) > MIN_CLICK_DELAY_TIME){
                    lastClickTime = curClickTime;
                    Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                    Log.i("Taga","点击了");
                }
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    public void openLandscapeActivity(View view) {
        CrashReport.testJavaCrash();
        startActivity(new Intent(MainActivity.this, LandscapeActivity.class));

    }

    public void openPortraitActivity(View view) {
        startActivity(new Intent(this, PortraitActivity.class));
    }

    public void openThress(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }

    public void openFour(View view) {
        startActivity(new Intent(this,Main3Activity.class));
    }

    @TargetApi(19)
    public static void transparencyBar1(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window =activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }



}
