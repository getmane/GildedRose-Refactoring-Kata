package com.gildedrose;

import com.gildedrose.type.ItemTypeFactory;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(
            item -> ItemTypeFactory.typeOf(item).dailyUpdate(item)
        );
    }
}
