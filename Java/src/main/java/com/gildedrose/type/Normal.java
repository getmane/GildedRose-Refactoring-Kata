package com.gildedrose.type;

import com.gildedrose.Item;

public class Normal implements QualifiedType {

    private final int qualityDecrease;
    private final int sellInMultiplier;

    public Normal(int qualityDecrease, int sellInMultiplier) {
        this.qualityDecrease = qualityDecrease;
        this.sellInMultiplier = sellInMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality - qualityDecrease
            : item.quality - qualityDecrease * sellInMultiplier;
    }

    public int getQualityDecrease() {
        return this.qualityDecrease;
    }

    public int getQualityDecreaseMultiplier() {
        return this.sellInMultiplier;
    }
}
