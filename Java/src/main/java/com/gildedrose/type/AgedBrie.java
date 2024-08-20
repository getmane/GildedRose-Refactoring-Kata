package com.gildedrose.type;

import com.gildedrose.Item;

public class AgedBrie implements ItemType {

    public static final String NAME = "Aged Brie";

    private final ModifiableItemType modifier;

    public AgedBrie(ModifiableItemType modifier) {
        this.modifier = modifier;
    }

    @Override
    public void dailyUpdate(Item item) {
        modifier.increaseQuality(item);
        if (item.sellIn <= 0) {
            modifier.increaseQuality(item);
        }
        modifier.progressDay(item);
    }
}
