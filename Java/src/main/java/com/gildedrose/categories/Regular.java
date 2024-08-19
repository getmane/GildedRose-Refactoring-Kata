package com.gildedrose.categories;

import com.gildedrose.Item;

public class Regular implements QualifiedCategory {

    private final int qualityDecrease;
    private final int qualityDecreaseMultiplier;

    public Regular(int qualityDecrease, int qualityDecreaseMultiplier) {
        this.qualityDecrease = qualityDecrease;
        this.qualityDecreaseMultiplier = qualityDecreaseMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality - qualityDecrease
            : item.quality - qualityDecrease * qualityDecreaseMultiplier;
    }
}
