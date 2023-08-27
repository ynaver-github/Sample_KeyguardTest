package com.example.keyguardtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import static com.example.keyguardtest.AppLog.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Handler mHandler = new Handler();
    public static Context mContext;

    KeyguardManager mKeyguardMgr = null;

    private Long finishtimeed = Long.valueOf(1000);
    private Long presstime = Long.valueOf(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppLog.d(TAG, "onCreate() ");
        super.onCreate(savedInstanceState);
        mContext =  this;
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
//
//
//        mKeyguardMgr = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
//        boolean isSecure = mKeyguardMgr.isKeyguardSecure();
//        boolean isLocked = mKeyguardMgr.isKeyguardLocked();
//        AppLog.d(TAG, "isSecure: " +  isSecure + ", isLocked: " +  isLocked);
//        if (isLocked) {
//            AppLog.d(TAG, "KeyguardManager: 3 isDestroyed: " + ((Activity) mContext).isDestroyed());
//            AppLog.d(TAG, "Show: requestDismissKeyguard");
////                    keyguardMgr.requestDismissKeyguard(MainActivity.this,
//            mKeyguardMgr.requestDismissKeyguard((Activity) mContext,
//                    new KeyguardManager.KeyguardDismissCallback() {
//                        //                            keyguardMgr.KeyguardDismissCallback() {
//                        @Override
//                        public void onDismissError() {
//                            super.onDismissError();
//                            AppLog.d(TAG, "onDismissError");
//
//                        }
//                        @Override
//                        public void onDismissSucceeded() {
//                            super.onDismissSucceeded();
//                            AppLog.d(TAG, "onDismissSucceeded");
//
//                        }
//                        @Override
//                        public void onDismissCancelled() {
//                            super.onDismissCancelled();
//                            AppLog.d(TAG, "onDismissCancelled");
//                        }
//                    }
//            );
//            AppLog.d(TAG, "KeyguardManager: 4 isDestroyed: " + ((Activity) mContext).isDestroyed());
//        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getBaseContext(),Flag1Activity.class));
                            }
                        },3000);
                    }
                }).start();
                break;
            case R.id.btn_2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getBaseContext(),Flag2Activity.class));
                            }
                        },3000);
                    }
                }).start();
                break;
            case R.id.btn_3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getBaseContext(),Flag3Activity.class));
                            }
                        },3000);
                    }
                }).start();
                break;
            case R.id.btn_4:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getBaseContext(),Flag4Activity.class));
                            }
                        },3000);
                    }
                }).start();
                break;
        }
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

    @Override
    public void onBackPressed() {
        AppLog.d(TAG, "onBackPressed() ");
        Long tempTime = System.currentTimeMillis();
        Long intervalTime = tempTime - presstime;
        if (0 <= intervalTime && finishtimeed >= intervalTime) {
            finish();
        } else {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(), "한번더 누르시면 앱이 종료됩니다", Toast.LENGTH_SHORT).show();
        }
    }
}
