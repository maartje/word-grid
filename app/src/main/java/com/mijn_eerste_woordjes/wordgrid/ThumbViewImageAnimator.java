package com.mijn_eerste_woordjes.wordgrid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Maartje on 21-7-2015.
 */
public class ThumbViewImageAnimator extends BabyGestureDetector {


    private GifImageView expandedImageView;
    private View containerView;
    private GridView gridView;

    private final Animation anim_out;
    private final Animation anim_in;
    private boolean isAnimating;
    private SoundPool soundPool;
    private int scalingDurationInMilliseconds;
    private final ImageAdapter adapter;

    public void setSoundPool(SoundPool soundPool) {
        this.soundPool = soundPool;
    }

    public ThumbViewImageAnimator(Activity context, int scalingDurationInMilliseconds, int fadingDurationInMilliseconds) {
        anim_out = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        anim_out.setDuration(fadingDurationInMilliseconds);
        anim_in  = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        anim_in.setDuration(fadingDurationInMilliseconds);

        expandedImageView = (GifImageView) context.findViewById(R.id.expanded_image);
        gridView = (GridView) context.findViewById(R.id.gridview);
        containerView = context.findViewById(R.id.container);
        this.scalingDurationInMilliseconds = scalingDurationInMilliseconds;
        isAnimating = false;

        adapter = (ImageAdapter)gridView.getAdapter();
    }

    @Override
    public boolean onClick(MotionEvent me) {
        // Do not start a new animation when an animation is currently in progress
        if (isAnimating) {
            return false;
        }

        int pointerIndex = me.getActionIndex();
        float currentXPosition = me.getX(pointerIndex);
        float currentYPosition = me.getY(pointerIndex);
        int position = gridView.pointToPosition((int) currentXPosition, (int) currentYPosition);
        if (position == AdapterView.INVALID_POSITION || gridView.getChildAt(position) == null){
            return false;
        }
        ImageView thumbView = (ImageView) gridView.getChildAt(position);
        animateThumbView(thumbView);
        return true;
    }

    private void animateThumbView(final View thumbView) {
        final int pos = (Integer) thumbView.getTag();
        WordItem item = (WordItem)adapter.getItem(pos);
        int imageResId = item.getImageResourceId();
        final int soundId = item.getSoundId();
        final int soundNameId = item.getSoundNameId();
        final int durationOfSound = item.getSoundDuration();
        final int durationOfImageAnimation = durationOfSound + 2000;

        final Rect startBounds = new Rect();
        final Rect endBounds = new Rect();
        thumbView.getGlobalVisibleRect(startBounds);
        containerView.getGlobalVisibleRect(endBounds);

        //calculate endscale (for given startscale 1.0f)
        //calculate end bounds for scaled image that preserves the aspect ratio and fills the full width or height
        float endScale;
        if ((float) endBounds.width() / endBounds.height() > (float) startBounds
                .width() / startBounds.height()) {
            // Container height is filled
            // Calculate scale and correct left and right position of the endBounds
            endScale = (float) endBounds.height() / startBounds.height();
            float endWidth = endScale * startBounds.width();
            float deltaWidth = (endBounds.width() - endWidth) / 2f;
            endBounds.left += deltaWidth;
            endBounds.right -= deltaWidth;
        } else {
            // Container width is filled
            // Calculate scale and correct top and bottom position of the endBounds
            endScale = (float) endBounds.width() / startBounds.width();
            float endHeight = endScale * startBounds.height();
            float deltaHeight = (endBounds.height() - endHeight)/2f;
            endBounds.top += deltaHeight;
            endBounds.bottom -= deltaHeight;
        }

        expandedImageView.setImageResource(imageResId);
        expandedImageView.setScaleType(GifImageView.ScaleType.FIT_CENTER);
        expandedImageView.setBackgroundColor(Color.WHITE);
        expandedImageView.setAdjustViewBounds(false);

        // Set the pivot point for SCALE_X and SCALE_Y transformations to the
        // top-left corner of
        // the zoomed-in view (the default is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // set height and width of the expanding image equal to the height and width of the thumbview
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(startBounds.width(), startBounds.height());
        expandedImageView.setLayoutParams(layoutParams);
        expandedImageView.requestLayout();



        final AnimatorSet animateScaleUp = new AnimatorSet();
        animateScaleUp
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left, endBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top, endBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
                        1f, endScale))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y,
                        1f, endScale))
                .with(ObjectAnimator.ofFloat(gridView, View.ALPHA, 1f, 0.2f));
        animateScaleUp.setDuration(scalingDurationInMilliseconds);
        animateScaleUp.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (soundPool != null) {
                    final int streamId = soundPool.play(soundId, 0.5f, 0.5f, 1, 0, 1.0f);
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {

                            soundPool.stop(streamId);
                            soundPool.play(soundNameId, 0.5f, 0.5f, 1, 0, 1.0f);
                        }
                    };
                    new Timer().schedule(task, durationOfSound);
                }
            }
        });


        final AnimatorSet animateScaleDown = new AnimatorSet();
        animateScaleDown
                .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
                        startBounds.left))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
                        startBounds.top))
                .with(ObjectAnimator.ofFloat(expandedImageView,
                        View.SCALE_X, 1.0f))
                .with(ObjectAnimator.ofFloat(expandedImageView,
                        View.SCALE_Y, 1.0f))
                .with(ObjectAnimator.ofFloat(gridView, View.ALPHA, 0.2f, 1f));

        animateScaleDown.setDuration(scalingDurationInMilliseconds);
        animateScaleDown.setStartDelay(durationOfImageAnimation);


        final AnimatorSet animate = new AnimatorSet();
        animate.play(animateScaleDown).after(animateScaleUp);
        animate.setInterpolator(new DecelerateInterpolator());
        animate.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isAnimating = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                expandedImageView.setVisibility(View.GONE);
                animateFadeInAndOut(pos, (ImageView) thumbView, R.raw.kangaroo);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                expandedImageView.setVisibility(View.GONE);
                animateFadeInAndOut(pos, (ImageView) thumbView, R.raw.kangaroo);
            }
        });

        expandedImageView.setVisibility(View.VISIBLE);
        isAnimating = true;
        animate.start();
    }


    private void animateFadeInAndOut(final int pos, final ImageView imageView, final int resourceId) {
        anim_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);
                imageView.setImageResource(resourceId);
                adapter.displayNewItemAtPosition(pos);
                anim_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        isAnimating = false;
                        imageView.setVisibility(View.VISIBLE);
                    }
                });
                anim_in.setStartOffset(250);
                imageView.startAnimation(anim_in);
            }
        });
        isAnimating = true;
        imageView.startAnimation(anim_out);
    }

}
