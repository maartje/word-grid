package com.mijn_eerste_woordjes.wordgrid;

import java.util.ArrayList;

/**
 * Created by Maartje on 11-7-2015.
 */
public class Repository {

    private final static int DEFAULT_DURATION_IN_MILLISECONDS = 5000;
    
    public ArrayList<WordItem> getWordItems(){
        //TODO use bitmap instead of resourceId for performance (and more generic)
        return getVehicles();
//        return getAnimals();
    }

    private ArrayList<WordItem> getVehicles() {
        ArrayList<WordItem> wordItems = new ArrayList<WordItem>();
        wordItems.add(new WordItem(19, R.drawable.car, R.raw.car, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.car_word));
        wordItems.add(new WordItem(20, R.drawable.boat, R.raw.boat, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.boat_word));
        wordItems.add(new WordItem(22, R.drawable.motorcycle, R.raw.motorcycle, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.motorcycle_word));
        wordItems.add(new WordItem(23, R.drawable.airplane, R.raw.airplane, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.airplane_word));
        wordItems.add(new WordItem(24, R.drawable.helicopter, R.raw.helicopter, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.helicopter_word));
        wordItems.add(new WordItem(25, R.drawable.ambulance, R.raw.ambulance, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.ambulance_word));
        wordItems.add(new WordItem(26, R.drawable.police, R.raw.police, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.police_word));
        wordItems.add(new WordItem(27, R.drawable.firetruck, R.raw.firetruck, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.firetruck_word));
        wordItems.add(new WordItem(28, R.drawable.bike, R.raw.bike, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.bike_word));
        wordItems.add(new WordItem(29, R.drawable.bus, R.raw.bus, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.bus_word));
        wordItems.add(new WordItem(31, R.drawable.tractor, R.raw.tractor, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.tractor_word));
        wordItems.add(new WordItem(32, R.drawable.train, R.raw.train, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.train_word));
        wordItems.add(new WordItem(33, R.drawable.truck, R.raw.truck, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.truck_word));
        wordItems.add(new WordItem(35, R.drawable.excavator, R.raw.excavator, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.excavator_word));
        wordItems.add(new WordItem(36, R.drawable.locomotive, R.raw.locomotive, DEFAULT_DURATION_IN_MILLISECONDS, R.raw.locomotive_word));
        return wordItems;
    }

    private ArrayList<WordItem> getAnimals() {
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
