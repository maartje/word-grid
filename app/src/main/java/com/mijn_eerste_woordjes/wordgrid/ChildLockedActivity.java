package com.mijn_eerste_woordjes.wordgrid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Maartje on 21-7-2015.
 */
public class ChildLockedActivity  extends Activity{

    public static final String ON_PAUSE_TIME = "ON_PAUSE_TIME";
    private ArrayList<Long> backPressTimes;
    private long onPauseTime;
    protected boolean skipLockDialog;

    public ChildLockedActivity()
    {
        backPressTimes = new ArrayList<Long>();
        onPauseTime = 0;
        skipLockDialog = false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        /*
        if (getActionBar() != null){
            getActionBar().hide();
        }
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                        */
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null)
        {
            onPauseTime = savedInstanceState.getLong(ON_PAUSE_TIME, 0);
        }
    }

    @Override
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onResume() {
        super.onResume();
        if (!skipLockDialog && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !isCreatedBecauseOfOrientationChange()) {
            startLockTask();
        }

    }

    @Override
    public void onPause()
    {
        super.onPause();
        onPauseTime = getCurrentTimeInMilliseconds();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(ON_PAUSE_TIME, onPauseTime);
    }

    private boolean isCreatedBecauseOfOrientationChange() {
        long currentTime = getCurrentTimeInMilliseconds();
        return currentTime - onPauseTime < 2000;
    }


    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            handleBackButton();
            return; //screen pinning is used as child lock
        }
            long currentTimeInMilliseconds = getCurrentTimeInMilliseconds();

        boolean isInSequence = !backPressTimes.isEmpty() && currentTimeInMilliseconds - backPressTimes.get(0) < 1200;
        if(!isInSequence)
        {
            backPressTimes.clear();
            backPressTimes.add(currentTimeInMilliseconds);
            showBackButtonHelpMessage();
            return;
        }

        backPressTimes.add(currentTimeInMilliseconds);
        if (backPressTimes.size() >= 3)
        {
            backPressTimes.clear();
            handleBackButton();
        }
    }

    protected void handleBackButton() {
        super.onBackPressed();
    }

    private long getCurrentTimeInMilliseconds() {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    private void showBackButtonHelpMessage() {
        Context context = getApplicationContext();
        CharSequence text = "Childlock active, press button three times";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
        toast.show();
    }

}
