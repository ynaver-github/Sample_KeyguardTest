package com.example.keyguardtest;

import android.app.Activity;
import android.app.Application;
import android.service.quicksettings.TileService;


import static com.example.keyguardtest.AppLog.TAG;

public class MainApplication extends Application {
    private Activity mActivity;
    private TileService mTileService;

    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public TileService getTileService() {
        return mTileService;
    }

    public void setTileService(TileService service) {
        mTileService = service;
    }


    @Override
    public void onCreate() {
        AppLog.d(TAG, "MainApplication onCreate() ");
        super.onCreate();
//jh.ha TEST AWS
//        final CountDownLatch latch = new CountDownLatch(1);
//        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
//            @Override
//            public void onResult(UserStateDetails result) {
//                AppLog.d(TAG, "onResult: user state: " + result.getUserState());
//                latch.countDown();
//            }
//
//            @Override
//            public void onError(Exception e) {
//                AppLog.e(TAG, "onError: Initialization error of the mobile client", e);
//                latch.countDown();
//            }
//        });
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
