package com.gildedrose.types;

import com.gildedrose.Item;

public class Basic implements QualifiedType {

    private final int qualityDecrease;
    private final int qualityDecreaseMultiplier;

    public Basic(int qualityDecrease, int afterSellInDecreaseMultiplier) {
        this.qualityDecrease = qualityDecrease;
        this.qualityDecreaseMultiplier = afterSellInDecreaseMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality - qualityDecrease
            : item.quality - qualityDecrease * qualityDecreaseMultiplier;
    }

    public int getQualityChange() {
        return this.qualityDecrease * -1;
    }

    public int getThresholdQualityChangeMultiplier() {
        return this.qualityDecreaseMultiplier;
    }
}
