package com.mijn_eerste_woordjes.wordgrid;

import java.util.ArrayList;

/**
 * Created by Maartje on 11-7-2015.
 */
public class Repository {

    private final static int DEFAULT_DURATION_IN_MILLISECONDS = 5000;
    
    public ArrayList<WordItem> getWordItems(){
        //TODO use bitmap instead of resourceId for performance (and more generic)
        ArrayList<WordItem> wordItems = new ArrayList<WordItem>();
        wordItems.add(new WordItem(1, R.drawable.duck, R.raw.duck, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.duck_word));
        wordItems.add(new WordItem(2, R.drawable.elephant, R.raw.elephant, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.elephant_word));
        wordItems.add(new WordItem(3, R.drawable.giraffe, R.raw.giraffe, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.giraffe_word));
        wordItems.add(new WordItem(4, R.drawable.mouse, R.raw.mouse, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.mouse_word));
        wordItems.add(new WordItem(5, R.drawable.pig, R.raw.pig, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.pig_word));
        wordItems.add(new WordItem(6, R.drawable.kangaroo, R.raw.kangaroo, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.kangaroo_word));
        wordItems.add(new WordItem(7, R.drawable.cat, R.raw.cat, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.cat_word));
        wordItems.add(new WordItem(8, R.drawable.dog, R.raw.dog, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.dog_word));
        wordItems.add(new WordItem(9, R.drawable.frog, R.raw.frog, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.frog_word));
        wordItems.add(new WordItem(10, R.drawable.leopard, R.raw.leopard, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.leopard_word));
        wordItems.add(new WordItem(11, R.drawable.seal, R.raw.seal, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.seal_word));
        wordItems.add(new WordItem(12, R.drawable.snake, R.raw.snake, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.snake_word));
        wordItems.add(new WordItem(13, R.drawable.fish, R.raw.fish, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.fish_word));
        wordItems.add(new WordItem(14, R.drawable.penguin, R.raw.penguin, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.penguin_word));
        wordItems.add(new WordItem(15, R.drawable.bird, R.raw.bird, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.bird_word));
        wordItems.add(new WordItem(16, R.drawable.peacock, R.raw.peacock, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.peacock_word));
        wordItems.add(new WordItem(17, R.drawable.butterfly, R.raw.butterfly, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.butterfly_word));
        wordItems.add(new WordItem(18, R.drawable.rooster, R.raw.rooster, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.rooster_word));
        return wordItems;
    }
}
