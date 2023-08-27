package com.example.keyguardtest;

import static com.example.keyguardtest.AppLog.TAG;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Chcheung on 2015-11-23.
 */
public class Flag1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.d(TAG, "onCreate() ");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.flag_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        ((TextView)findViewById(R.id.txt_flag_)).setText("FLAG_SHOW_WHEN_LOCKED");
    }

    @Override
    protected void onStart() {
        AppLog.d(TAG, "onStart() ");
        super.onStart();

    }

    @Override
    protected void onResume() {
        AppLog.d(TAG, "onResume() ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        AppLog.d(TAG, "onPause() ");
        super.onPause();

    }

    @Override
    protected void onStop() {
        AppLog.d(TAG, "onStop() ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        AppLog.d(TAG, "onDestroy() ");
        super.onDestroy();
    }

}
