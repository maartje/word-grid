package com.mijn_eerste_woordjes.wordgrid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.SoundPool;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	private WordItemManager wordItemManager;
	private double aspectRatio;

	private List<WordItem> getDisplayedItems()
	{
		return wordItemManager.getDisplayedItems();
	}


	public ImageAdapter(Activity context, WordItemManager wordItemManager, double aspectRatio) {
		this.context = context;
		this.wordItemManager = wordItemManager;
		this.aspectRatio = aspectRatio;
	}

	public int getCount() {
		return getDisplayedItems().size();
	}

	public Object getItem(int position) {
		return getDisplayedItems().get(position);
	}

	public long getItemId(int position) {
		return getDisplayedItems().get(position).getId();
	}

	public View getView(final int position, View convertView, ViewGroup parent) {

		final AspectRatioImageView imageView;
		if (convertView == null) {
			imageView = new AspectRatioImageView(context, aspectRatio);
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setBackgroundColor(Color.WHITE);
		} else {
			imageView = (AspectRatioImageView) convertView;
		}

		WordItem wordItem = getDisplayedItems().get(position);
		imageView.setImageResource(wordItem.getImageResourceId());
		imageView.setTag(position);
		return imageView;
	}

	public void displayNewItemAtPosition(int pos) {
		wordItemManager.displayNewItemAtPosition(pos);
		this.notifyDataSetChanged();
	}
}