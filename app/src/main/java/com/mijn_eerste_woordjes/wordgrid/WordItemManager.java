package com.mijn_eerste_woordjes.wordgrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Maartje on 17-7-2015.
 */
public class WordItemManager {

    private List<WordItem> displayedItems;
    private List<WordItem> nonDisplayedItems;

    public List<WordItem> getDisplayedItems() {
        return displayedItems;
    }

    public List<WordItem> getNonDisplayedItems() {
        return nonDisplayedItems;
    }

    public WordItemManager() {
        nonDisplayedItems = new ArrayList<WordItem>();
        displayedItems =  new ArrayList<WordItem>();
    }

    public void displayNewItemAtPosition(int indexDisplayedItem)
    {
        if(nonDisplayedItems.isEmpty()){
            return;
        }
        WordItem oldItem = displayedItems.get(indexDisplayedItem);
        WordItem newItem = nonDisplayedItems.remove(0);
        displayedItems.set(indexDisplayedItem, newItem);
        nonDisplayedItems.add(oldItem);
    }

    public int[] getDisplayedItemIds() {
        int[] displayedItemIds = new int[displayedItems.size()];
        for (int i = 0; i < displayedItemIds.length; i++) {
            displayedItemIds[i] = displayedItems.get(i).getId();
        }
        return displayedItemIds;
    }

    public int[] getNonDisplayedItemIds() {
        int[] nonDisplayedItemIds = new int[nonDisplayedItems.size()];
        for (int i = 0; i < nonDisplayedItemIds.length; i++) {
            nonDisplayedItemIds[i] = nonDisplayedItems.get(i).getId();
        }
        return nonDisplayedItemIds;
    }

    public void initialize(List<WordItem> wordItems, int numberOfDisplayedItems) {
        nonDisplayedItems = wordItems;
        Random r = new Random();
        for (int i = 0; i < numberOfDisplayedItems; i++) {
            if(nonDisplayedItems.isEmpty())
            {
                return;
            }
            int pos = r.nextInt(nonDisplayedItems.size());
            displayedItems.add(nonDisplayedItems.remove(pos));
        }
    }

    public void initialize(List<WordItem> wordItems, int[] displayedItemIds, int[] nonDisplayedItemIds) {
        for (int i = 0; i < displayedItemIds.length; i++) {
            if(wordItems.isEmpty())
            {
                return;
            }
            WordItem item = removeItemById(wordItems, displayedItemIds[i]);
            if(item != null){
                displayedItems.add(item);
            }
        }
        for (int i = 0; i < nonDisplayedItemIds.length; i++) {
            if(wordItems.isEmpty())
            {
                return;
            }
            WordItem item = removeItemById(wordItems, nonDisplayedItemIds[i]);
            if(item != null){
                nonDisplayedItems.add(item);
            }
        }
        nonDisplayedItems.addAll(wordItems);
    }

    private WordItem removeItemById(List<WordItem> wordItems, int itemId) {
        for (int i = 0; i < wordItems.size(); i++) {
            if (wordItems.get(i).getId() == itemId)
            {
                return wordItems.remove(i);
            }
        }
        return null;
    }
}
