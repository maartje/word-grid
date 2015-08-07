package com.mijn_eerste_woordjes.wordgrid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends Activity {

    public static final String CATEGORY = "com.mijn_eerste_woordjes.wordgrid.CATEGORY";
    public static final String SKIP_LOCK_DIALOG = "com.mijn_eerste_woordjes.wordgrid.SKIP_LOCK_DIALOG";

    private String lastCategory;

    private boolean isCreatedFromMain(){
        return lastCategory != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        lastCategory = intent.getStringExtra(HomeActivity.CATEGORY);
        setContentView(R.layout.activity_home);
    }



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
    }

    public void startVehicles(View view) {
        startMain("VEHICLES");
    }

    public void startAnimals(View view) {
        startMain("ANIMALS");
    }

    private void startMain(String category)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CATEGORY, category);
        intent.putExtra(SKIP_LOCK_DIALOG, isCreatedFromMain());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
