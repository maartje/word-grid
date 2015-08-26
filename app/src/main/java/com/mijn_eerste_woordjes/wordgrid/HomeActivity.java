package com.mijn_eerste_woordjes.wordgrid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class HomeActivity extends ChildLockedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);

        findViewById(R.id.animals_category).setOnTouchListener(new BabyGestureDetector() {
            @Override
            public boolean onClick(MotionEvent me) {
                startAnimals();
                return true;
            }
        });
        findViewById(R.id.vehicles_category).setOnTouchListener(new BabyGestureDetector() {
            @Override
            public boolean onClick(MotionEvent me) {
                startVehicles();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.vehicles_category).setBackgroundColor(getResources().getColor(R.color.blue));
        findViewById(R.id.animals_category).setBackgroundColor(getResources().getColor(R.color.yellow));
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_language) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    private void startVehicles() {
        findViewById(R.id.vehicles_category).setBackgroundColor(getResources().getColor(R.color.dark_blue));
        startMain("VEHICLES");
    }

    private void startAnimals() {
        findViewById(R.id.animals_category).setBackgroundColor(getResources().getColor(R.color.dark_yellow));
        startMain("ANIMALS");
    }

    private void startMain(String category)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.CATEGORY, category);
        intent.putExtra(ChildLockedActivity.SKIP_LOCK_DIALOG, true);
        startActivity(intent);
    }
}
