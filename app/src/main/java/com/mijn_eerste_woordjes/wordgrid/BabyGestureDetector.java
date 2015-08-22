package com.mijn_eerste_woordjes.wordgrid;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Maartje on 21-7-2015.
 */
public abstract class BabyGestureDetector implements View.OnTouchListener {

    private int lastPointerDownId;
    private long lastPointerDownTime;

    public boolean onTouch(View view, MotionEvent me) {

        switch (me.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
            {
                int pointerIndex = me.getActionIndex();
                lastPointerDownId = me.getPointerId(pointerIndex);
                lastPointerDownTime = me.getEventTime();
                return true;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            {
                int pointerIndex = me.getActionIndex();
                int pointerId = me.getPointerId(pointerIndex);
                long pointerEventTime = me.getEventTime();
                if(pointerId == lastPointerDownId && pointerEventTime - lastPointerDownTime < 500)
                {
                    return onClick(me);
                }
                break;
            }
            default:
                break;

        }

        return false;
    }

    public abstract boolean onClick(MotionEvent me);
}
