package com.example.keyguardtest;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;


import static com.example.keyguardtest.AppLog.TAG;
public class MainActivityTile extends TileService {
    @Override
    public IBinder onBind(Intent intent) {
        AppLog.d(TAG, "onBind() ");
        MainApplication app = (MainApplication)getApplication();
        app.setTileService(MainActivityTile.this);
        return super.onBind(intent);
    }

    @Override
    public void onClick() {
        super.onClick();

        Tile tile = getQsTile();
        int state = tile.getState();
        if (state == Tile.STATE_INACTIVE) {
            AppLog.d(TAG, "set Tile.STATE_ACTIVE ");
            tile.setState(Tile.STATE_ACTIVE);
            tile.updateTile();
//            ComponentName componentName = new ComponentName(
//                    "com.lge.instaviewotr", "com.lge.instaviewotr.MainActivity");
            ComponentName componentName = new ComponentName(
                    "com.example.keyguardtest", "com.example.keyguardtest.MainActivity");
            startActivityAndCollapse(getActivityIntent(componentName));
        } else if (state == Tile.STATE_ACTIVE) {
            AppLog.d(TAG, "set Tile.STATE_INACTIVE ");
            tile.setState(Tile.STATE_INACTIVE);
            tile.updateTile();
            MainApplication app = (MainApplication)getApplication();
            if (app.getActivity() != null) {
                AppLog.d(TAG, "finish() ");
                app.getActivity().finish();
                app.setActivity(null);
            }
        }
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
    }

    public static Intent getActivityIntent(ComponentName activity) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
