package com.gildedrose.type;

import com.gildedrose.Item;

public interface ModifiableItemType extends ItemType {

    void progressQuality(Item item);

    void progressDay(Item item);

    void decreaseQuality(Item item);

    void increaseQuality(Item item);
}
