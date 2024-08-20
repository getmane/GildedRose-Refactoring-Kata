package com.gildedrose.type;

import com.gildedrose.Item;

public class Normal implements ModifiableItemType {

    @Override
    public void dailyUpdate(Item item) {
        progressQuality(item);
        progressDay(item);
    }

    @Override
    public void progressQuality(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
    }

    @Override
    public void progressDay(Item item) {
        item.sellIn--;
    }

    @Override
    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    @Override
    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
}
