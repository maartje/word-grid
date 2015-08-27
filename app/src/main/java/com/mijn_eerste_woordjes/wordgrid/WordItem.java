package com.mijn_eerste_woordjes.wordgrid;

import android.app.Activity;
import android.media.SoundPool;

import java.util.Locale;

/**
 * Created by Maartje on 11-7-2015.
 */
public class WordItem {
    private int id;
    private int imageResourceId;
    private int soundResourceId;
    private int soundId;
    private int durationSpokenWord;
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

    public int getDurationSpokenWord() {
        return durationSpokenWord;
    }

    public int getSoundNameId() {
        return soundNameId;
    }

    public WordItem(int id, int imageResourceId, int soundResourceId, int durationSpokenWord, int soundNameResourceId) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.soundResourceId = soundResourceId;
        this.soundNameResourceId = soundNameResourceId;
        this.soundId = -1;
        this.soundNameId = -1;
        this.durationSpokenWord = durationSpokenWord;
    }

    public void loadSound(Activity context, SoundPool soundPool)
    {
        this.soundId = soundPool.load(context, soundResourceId, 1);
        if (isSupportedLanguage(Locale.getDefault().getLanguage())){
            try{
                this.soundNameId = soundPool.load(context, soundNameResourceId, 10);
            }
            catch (Exception e){
                //ignore exception
            }
        }
    }

    private static String[] supportedLanguages()
    {
        return new String[]{
                "ar", "cs", "da", "de", "el", "en", "es", "fr", "hi", "hu", "id", "it", "ja",
                "ko", "nl", "no", "pl", "pt", "ru", "th", "tr", "zh"
                // Bad audio: "af", "ro", "sw",
        };
    }

    private static boolean isSupportedLanguage(String lang){
        for(String l : supportedLanguages()){
            if(lang.equals(l)){
                return true;
            }
        }
        return false;
    }
}
