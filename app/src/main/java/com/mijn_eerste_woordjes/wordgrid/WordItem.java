package com.mijn_eerste_woordjes.wordgrid;

import android.app.Activity;
import android.media.SoundPool;

/**
 * Created by Maartje on 11-7-2015.
 */
public class WordItem {
    private int id;
    private int imageResourceId;
    private int soundResourceId;
    private int soundId;
    private int soundDuration;
    private int soundNameResourceId;
    private int soundNameId;

    public int getId() {
        return id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getSoundId() {
        return soundId;
    }

    public int getSoundDuration() {
        return soundDuration;
    }

    public int getSoundNameId() {
        return soundNameId;
    }

    public WordItem(int id, int imageResourceId, int soundResourceId, int soundDuration, int soundNameResourceId) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
        this.soundNameResourceId = soundNameResourceId;
        this.soundId = 0;
        this.soundNameId = 0;
        this.soundDuration = soundDuration;
    }

    public void loadSound(Activity context, SoundPool soundPool)
    {
        this.soundId = soundPool.load(context, soundResourceId, 1);
        this.soundNameId = soundPool.load(context, soundNameResourceId, 10);
    }
}
