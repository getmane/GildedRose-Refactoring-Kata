package com.gildedrose.type;

import com.gildedrose.Item;

public class ItemTypeFactory {

    private ItemTypeFactory() {}

    public static ItemType typeOf(Item item) {
        ModifiableItemType defaultItem = new Normal();

        return switch (item.name) {
            case AgedBrie.NAME -> new AgedBrie(defaultItem);
            case BackstagePasses.NAME -> new BackstagePasses(defaultItem);
            case Conjured.NAME -> new Conjured(defaultItem);
            case Sulfuras.NAME -> new Sulfuras();
            default -> defaultItem;
        };
    }
}
