package com.gildedrose.type;

import com.gildedrose.Item;

public class Conjured implements ItemType {

    public static final String NAME = "Conjured Mana Cake";

    private final ModifiableItemType modifier;

    public Conjured(ModifiableItemType modifier) {
        this.modifier = modifier;
    }

    @Override
    public void dailyUpdate(Item item) {
        modifier.progressQuality(item);
        modifier.progressQuality(item);
        modifier.progressDay(item);
    }
}
