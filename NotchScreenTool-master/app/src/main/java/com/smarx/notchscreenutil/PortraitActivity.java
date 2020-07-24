package com.smarx.notchscreenutil;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.smarx.notchlib.INotchScreen;
import com.smarx.notchlib.NotchScreenManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PortraitActivity extends BaseActivity {

    private static final String TAG = "portrait_notch";
    private NotchScreenManager notchScreenManager = NotchScreenManager.getInstance();
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_portrait;
    }




}
