package com.mijn_eerste_woordjes.wordgrid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Maartje on 13-7-2015.
 */
public class AspectRatioImageView extends ImageView {

    private double aspectRatio;

    public AspectRatioImageView(Context context, double aspectRatio) {
        super(context);
        this.aspectRatio = aspectRatio;
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int)(width/aspectRatio);
        int heightMeasureSpecResult = MeasureSpec.makeMeasureSpec(height, MeasureSpec.getMode(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpecResult);
    }
}
