package com.gildedrose.type;

import com.gildedrose.Item;

public class Sulfuras implements ItemType {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    @Override
    public void dailyUpdate(Item item) {
        // Sulfuras quality is 80 and never changes
        // Day should not be progressed
        item.quality = 80;
    }
}
