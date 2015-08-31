package com.mijn_eerste_woordjes.wordgrid;

import java.util.ArrayList;

/**
 * Created by Maartje on 11-7-2015.
 */
public class Repository {

    public final static int SOUND_DURATION_IN_MILLISECONDS = 4000;
    private final static int DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS = 1200;
    private final static int DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS = 1600;

    public ArrayList<WordItem> getWordItems(String category){
        switch (category){
            case "ANIMALS": return getAnimals();
            case "VEHICLES": return getProfessions(); //getVehicles();
            case "ALL": return getAll();
            default:
                return getAnimals();
        }
    }

    private ArrayList<WordItem> getAll() {
        ArrayList<WordItem> result = new ArrayList<WordItem>();
        result.addAll(getAnimals());
        result.addAll(getVehicles());
        return result;
    }

    private ArrayList<WordItem> getVehicles() {
        ArrayList<WordItem> wordItems = new ArrayList<WordItem>();
        wordItems.add(new WordItem(19, R.drawable.car, R.raw.car, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.car_word));
        wordItems.add(new WordItem(20, R.drawable.boat, R.raw.boat, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.boat_word));
        wordItems.add(new WordItem(22, R.drawable.motorcycle, R.raw.motorcycle, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.motorcycle_word));
        wordItems.add(new WordItem(23, R.drawable.airplane, R.raw.airplane, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.airplane_word));
        wordItems.add(new WordItem(24, R.drawable.helicopter, R.raw.helicopter, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.helicopter_word));
        wordItems.add(new WordItem(25, R.drawable.ambulance, R.raw.ambulance, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.ambulance_word));
        wordItems.add(new WordItem(26, R.drawable.police, R.raw.police, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.police_word));
        wordItems.add(new WordItem(27, R.drawable.firetruck, R.raw.firetruck, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.firetruck_word));
        wordItems.add(new WordItem(28, R.drawable.bike, R.raw.bike, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.bike_word));
        wordItems.add(new WordItem(29, R.drawable.bus, R.raw.bus, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.bus_word));
        wordItems.add(new WordItem(31, R.drawable.tractor, R.raw.tractor, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.tractor_word));
        wordItems.add(new WordItem(32, R.drawable.train, R.raw.train, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.train_word));
        wordItems.add(new WordItem(33, R.drawable.truck, R.raw.truck, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.truck_word));
        wordItems.add(new WordItem(35, R.drawable.excavator, R.raw.excavator, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.excavator_word));
        wordItems.add(new WordItem(36, R.drawable.locomotive, R.raw.locomotive, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.locomotive_word));
        return wordItems;
    }

    private ArrayList<WordItem> getAnimals() {
        ArrayList<WordItem> wordItems = new ArrayList<WordItem>();
        wordItems.add(new WordItem(1, R.drawable.duck, R.raw.duck, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.duck_word));
        wordItems.add(new WordItem(2, R.drawable.elephant, R.raw.elephant, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.elephant_word));
        wordItems.add(new WordItem(3, R.drawable.giraffe, R.raw.giraffe, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.giraffe_word));
        wordItems.add(new WordItem(4, R.drawable.mouse, R.raw.mouse, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.mouse_word));
        wordItems.add(new WordItem(5, R.drawable.pig, R.raw.pig, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.pig_word));
        wordItems.add(new WordItem(6, R.drawable.kangaroo, R.raw.kangaroo, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.kangaroo_word));
        wordItems.add(new WordItem(7, R.drawable.cat, R.raw.cat, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.cat_word));
        wordItems.add(new WordItem(8, R.drawable.dog, R.raw.dog, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.dog_word));
        wordItems.add(new WordItem(9, R.drawable.frog, R.raw.frog, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.frog_word));
        wordItems.add(new WordItem(10, R.drawable.leopard, R.raw.leopard, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.leopard_word));
        wordItems.add(new WordItem(12, R.drawable.snake, R.raw.snake, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.snake_word));
        wordItems.add(new WordItem(13, R.drawable.fish, R.raw.fish, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.fish_word));
        wordItems.add(new WordItem(14, R.drawable.penguin, R.raw.penguin, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.penguin_word));
        wordItems.add(new WordItem(15, R.drawable.bird, R.raw.bird, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.bird_word));
        wordItems.add(new WordItem(16, R.drawable.peacock, R.raw.peacock, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.peacock_word));
        wordItems.add(new WordItem(17, R.drawable.butterfly, R.raw.butterfly, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.butterfly_word));
        wordItems.add(new WordItem(18, R.drawable.rooster, R.raw.rooster, DEFAULT_ANIMAL_NAME_DURATION_IN_MILLISECONDS, R.raw.rooster_word));
        return wordItems;
    }

    private ArrayList<WordItem> getProfessions() {
        ArrayList<WordItem> wordItems = new ArrayList<WordItem>();
        wordItems.add(new WordItem(42, R.drawable.cashier, R.raw.cashier, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.cashier_word)); //+-
        wordItems.add(new WordItem(43, R.drawable.cleaner, R.raw.cleaner, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.cleaner_word)); //+-
        wordItems.add(new WordItem(44, R.drawable.construction_worker, R.raw.construction_worker, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.construction_worker_word)); //+-
        wordItems.add(new WordItem(45, R.drawable.doctor, R.raw.doctor, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.doctor_word)); //+
        wordItems.add(new WordItem(46, R.drawable.farmer, R.raw.farmer, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.farmer_word)); //++
        wordItems.add(new WordItem(47, R.drawable.fireman, R.raw.firefighter, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.firefighter_word)); //++ TODO
        wordItems.add(new WordItem(48, R.drawable.hairdresser, R.raw.hairdresser, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.hairdresser_word)); //++
        wordItems.add(new WordItem(49, R.drawable.magician, R.raw.magician, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.magician_word)); //+
        wordItems.add(new WordItem(50, R.drawable.musician, R.raw.musician, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.musician_word)); //++
        wordItems.add(new WordItem(51, R.drawable.officeworker, R.raw.office_worker, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.officeworker_word)); //+ programmer
        wordItems.add(new WordItem(52, R.drawable.programmer, R.raw.programmer, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.programmer_word)); //+
        wordItems.add(new WordItem(54, R.drawable.policeman, R.raw.policeman, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.policeman_word)); //+
        wordItems.add(new WordItem(56, R.drawable.shoemaker, R.raw.shoemaker, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.shoemaker_word)); //+
        wordItems.add(new WordItem(57, R.drawable.tailor, R.raw.tailor, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.tailor_word)); //+-
        wordItems.add(new WordItem(57, R.drawable.teacher, R.raw.teacher, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.teacher_word)); //+-
        wordItems.add(new WordItem(57, R.drawable.vendor, R.raw.vendor, DEFAULT_VEHICLE_NAME_DURATION_IN_MILLISECONDS, R.raw.vendor_word)); //+
        return wordItems;
    }

}
