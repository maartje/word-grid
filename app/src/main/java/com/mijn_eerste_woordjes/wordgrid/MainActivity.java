package com.mijn_eerste_woordjes.wordgrid;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;

import java.util.List;

public class MainActivity extends ChildLockedActivity {

	public static final String DISPLAYED_ITEM_IDS = "DISPLAYED_ITEM_IDS";
	public static final String NON_DISPLAYED_ITEM_IDS = "NON_DISPLAYED_ITEM_IDS";
	public static final String MEDIA_VOLUME = "MEDIA_VOLUME";
	private SoundPool soundPool;
	private ThumbViewImageAnimator thumbViewAnimator;
	private AudioManager audioManager;
	private WordItemManager wordItemManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// initializes the views and sets the content view
		setContentView(R.layout.activity_main);
		GridView gridview = (GridView) findViewById(R.id.gridview);

		//initialize and attach the adapter for the grid view
		Repository repo = new Repository();
		List<WordItem> wordItems = repo.getWordItems();
		ScreenSizeManager screenSizeManager = new ScreenSizeManager(this);

		wordItemManager = new WordItemManager();
		if (savedInstanceState != null && savedInstanceState.containsKey(DISPLAYED_ITEM_IDS)){
			int[] displayedIds = savedInstanceState.getIntArray(DISPLAYED_ITEM_IDS);
			int[] nondisplayedIds = savedInstanceState.getIntArray(NON_DISPLAYED_ITEM_IDS);
			wordItemManager.initialize(wordItems, displayedIds, nondisplayedIds);
		}
		else {
			wordItemManager.initialize(wordItems, screenSizeManager.getNumberOfItemsDisplayed());
		}


		ImageAdapter imageAdapter;
		imageAdapter = new ImageAdapter(this, wordItemManager, screenSizeManager.getAspectRatio());
		gridview.setAdapter(imageAdapter);
		thumbViewAnimator = new ThumbViewImageAnimator(this, 750, 250);
		gridview.setOnTouchListener(thumbViewAnimator);

		audioManager =
				(AudioManager)getSystemService(this.AUDIO_SERVICE);

		if (savedInstanceState == null && audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) <= 2) //open first time
		{
			int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
			int initialVolume = (int)(0.6*maxVolume);
			audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, initialVolume, AudioManager.FLAG_PLAY_SOUND);
		}
	}

	@Override
	public void onResume()
	{
		super.onResume();

		// initialize system resources
		if(soundPool == null){
			initializeSoundPool();
		}
	}

	private void initializeSoundPool() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			createSoundPoolWithBuilder();
		} else{
			createSoundPoolWithConstructor();
		}
		for(WordItem wordItem : wordItemManager.getDisplayedItems())
		{
			wordItem.loadSound(this, soundPool);
		}
		for(WordItem wordItem : wordItemManager.getNonDisplayedItems())
		{
			wordItem.loadSound(this, soundPool);
		}
		thumbViewAnimator.setSoundPool(soundPool);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	protected void createSoundPoolWithBuilder(){
		AudioAttributes attributes = new AudioAttributes.Builder()
				.setUsage(AudioAttributes.USAGE_GAME)
				.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
				.build();

		soundPool = new SoundPool.Builder()
				.setAudioAttributes(attributes)
				.setMaxStreams(1)
				.build();
	}

	@SuppressWarnings("deprecation")
	protected void createSoundPoolWithConstructor(){
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	}

	@Override
	public void onPause()
	{
		super.onPause();

		// release system resources
		soundPool.release();
		soundPool = null;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_VOLUME_UP:
				audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
				return true;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
						AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
				return true;
			default:
				return super.onKeyDown(keyCode, event);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putIntArray(DISPLAYED_ITEM_IDS, wordItemManager.getDisplayedItemIds());
		outState.putIntArray(NON_DISPLAYED_ITEM_IDS, wordItemManager.getNonDisplayedItemIds());
		int mediaVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		outState.putInt(MEDIA_VOLUME, mediaVolume);
	}

}
