package com.example.keyguardtest;

import static com.example.keyguardtest.AppLog.TAG;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Chcheung on 2015-11-23.
 */
public class Flag2Activity extends Activity {

    KeyguardManager mKeyguardMgr = null;

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.d(TAG, "onCreate() ");
        super.onCreate(savedInstanceState);
        mContext =  this;

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
//                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


        mKeyguardMgr = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        boolean isSecure = mKeyguardMgr.isKeyguardSecure();
        boolean isLocked = mKeyguardMgr.isKeyguardLocked();
        AppLog.d(TAG, "isSecure: " +  isSecure + ", isLocked: " +  isLocked);
        if (isLocked) {
            AppLog.d(TAG, "KeyguardManager: 1");
//            setShowWhenLocked(true);
            setTurnScreenOn(true);
            AppLog.d(TAG, "KeyguardManager: 3 isDestroyed: " + ((Activity) mContext).isDestroyed());
            AppLog.d(TAG, "Show: requestDismissKeyguard");
//                    keyguardMgr.requestDismissKeyguard(MainActivity.this,
            mKeyguardMgr.requestDismissKeyguard((Activity) mContext,
                    new KeyguardManager.KeyguardDismissCallback() {
                        //                            keyguardMgr.KeyguardDismissCallback() {
                        @Override
                        public void onDismissError() {
                            super.onDismissError();
                            AppLog.d(TAG, "onDismissError");

                        }
                        @Override
                        public void onDismissSucceeded() {
                            super.onDismissSucceeded();
                            AppLog.d(TAG, "onDismissSucceeded");
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.setComponent(new ComponentName("com.example.deeplink_call", "com.example.deeplink_call.MainActivity"));
//                intent.setComponent(new ComponentName("com.lge.mwocam", "com.lge.mwocam.app.CameraActivity"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            AppLog.d(TAG, "Start: startActivity()");
                            startActivity(intent);
                            finish();
                        }
                        @Override
                        public void onDismissCancelled() {
                            super.onDismissCancelled();
                            AppLog.d(TAG, "onDismissCancelled");
//                            Intent intent = new Intent(getBaseContext(),MainActivity.class);
//                            startActivity(intent);
                            finish();
                        }
                    }
            );
            AppLog.d(TAG, "KeyguardManager: 4 isDestroyed: " + ((Activity) mContext).isDestroyed());
            AppLog.d(TAG, "KeyguardManager: 2");
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);  // screen on
        }


        setContentView(R.layout.flag_activity);
        ((TextView)findViewById(R.id.txt_flag_)).setText("FLAG_DISMISS_KEYGUARD");

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
