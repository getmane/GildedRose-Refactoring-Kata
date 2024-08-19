package com.gildedrose.categories;

import com.gildedrose.Item;

public class AgedBrie implements QualifiedCategory, NamedCategory {

    private static final String NAME = "Aged Brie";

    private final int qualityIncrease;
    private final int qualityIncreaseMultiplier;

    public AgedBrie(int qualityIncrease, int qualityIncreaseMultiplier) {
        this.qualityIncrease = qualityIncrease;
        this.qualityIncreaseMultiplier = qualityIncreaseMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality + qualityIncrease
            : item.quality + qualityIncrease * qualityIncreaseMultiplier;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
