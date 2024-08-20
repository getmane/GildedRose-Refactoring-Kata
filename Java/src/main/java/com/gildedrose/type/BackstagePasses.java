package com.gildedrose.type;

import com.gildedrose.Item;

import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class BackstagePasses implements ItemType {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    private final ModifiableItemType modifier;

    private final NavigableMap<Integer, Integer> sellInToQualityStages;

    public BackstagePasses(ModifiableItemType modifier) {
        this.modifier = modifier;
        this.sellInToQualityStages = new TreeMap<>();

        sellInToQualityStages.put(5, 3);
        sellInToQualityStages.put(10, 2);
    }

    @Override
    public void dailyUpdate(Item item) {
        if (item.sellIn > 0) {
            IntStream.range(0, getCurrentStage(item.sellIn)).forEach(
                i -> modifier.increaseQuality(item)
            );
        } else {
            item.quality = 0;
        }
        modifier.progressDay(item);
    }


    private int getCurrentStage(int sellIn) {
        try {
            return sellInToQualityStages.get(sellInToQualityStages.tailMap(sellIn, true).firstKey());
        } catch (NoSuchElementException ex) {
            return 1;
        }
    }
}
