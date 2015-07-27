package com.mijn_eerste_woordjes.wordgrid;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by Maartje on 22-7-2015.
 */
public class ScreenSizeManager {

    //display settings
    private int orientation;
    private int smallestScreenWidthDp;
    private int widthPx;
    private int heightPx;

    //application settings
    private int numberOfColumns;
    private int numberOfRows;


    public int getNumberOfItemsDisplayed()
    {
        return numberOfColumns * numberOfRows;
    }

    public double getAspectRatio()
    {
        double rowWidth = (double)widthPx/numberOfColumns;
        double rowHeight = (double)heightPx/numberOfRows;
        return rowWidth/rowHeight;
    }

    public ScreenSizeManager(Activity context)
    {
        setDisplaySettings(context);
        setApplicationSettings();
    }

    private void setApplicationSettings() {
        if (smallestScreenWidthDp < 600) { // phone in portrait mode: layout
            numberOfColumns = 2;
            numberOfRows = 3;
        }
        else { // tablet in portrait mode: layout-sw600dp
            numberOfColumns = 3;
            numberOfRows = 4;
        }
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){ // tablet or phone in landscape mode: layout(-sw600dp)-land
            rotateGrid(numberOfColumns, numberOfRows);
        }
    }

    private void rotateGrid(int numberOfColumns, int numberOfRows) {
        this.numberOfColumns = numberOfRows;
        this.numberOfRows = numberOfColumns;
    }

    private void setDisplaySettings(Activity context) {
        orientation = context.getResources().getConfiguration().orientation;
        Configuration config = context.getResources().getConfiguration();
        smallestScreenWidthDp = config.smallestScreenWidthDp;


        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthPx = size.x;
        heightPx = size.y;
    }
}
