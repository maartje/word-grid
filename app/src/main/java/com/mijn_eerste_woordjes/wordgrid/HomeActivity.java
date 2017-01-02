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

    private boolean categorySelected;
    private Category animals;
    private Category vehicles;
    private Category jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animals = new Category(R.id.animals_category, R.color.yellow, R.color.dark_yellow, "ANIMALS");
        vehicles = new Category(R.id.vehicles_category, R.color.blue, R.color.dark_blue, "VEHICLES");
        jobs = new Category(R.id.jobs_category, R.color.green, R.color.dark_green, "JOBS ");

        setContentView(R.layout.activity_home);

        findViewById(R.id.animals_category).setOnTouchListener(new BabyGestureDetector() {
            @Override
            public boolean onClick(MotionEvent me) {
                startCategory(animals);
                return true;
            }
        });
        findViewById(R.id.vehicles_category).setOnTouchListener(new BabyGestureDetector() {
            @Override
            public boolean onClick(MotionEvent me) {
                startCategory(vehicles);
                return true;
            }
        });
        findViewById(R.id.jobs_category).setOnTouchListener(new BabyGestureDetector() {
            @Override
            public boolean onClick(MotionEvent me) {
                startCategory(jobs);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        categorySelected = false;
        findViewById(R.id.vehicles_category).setBackgroundColor(getResources().getColor(vehicles.bgColor));
        findViewById(R.id.animals_category).setBackgroundColor(getResources().getColor(animals.bgColor));
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

    private void startCategory(Category category){
        if(categorySelected){
            return;
        }
        findViewById(category.viewId).setBackgroundColor(getResources().getColor(category.bgSelectedColor));
        categorySelected = true;
        startMain(category.name);
    }

    private void startMain(String category)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.CATEGORY, category);
        intent.putExtra(ChildLockedActivity.SKIP_LOCK_DIALOG, true);
        startActivity(intent);
    }

    private class Category {
        private int viewId;
        private int bgColor;
        private int bgSelectedColor;
        private String name;

        private Category(int viewId, int bgColor, int bgSelectedColor, String name)
        {
            this.viewId = viewId;
            this.bgColor = bgColor;
            this.bgSelectedColor = bgSelectedColor;
            this.name = name;
        }

    }
}
