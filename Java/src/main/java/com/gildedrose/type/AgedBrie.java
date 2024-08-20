package com.gildedrose.type;

import com.gildedrose.Item;

public class AgedBrie implements QualifiedType {

    public static final String NAME = "Aged Brie";

    private final int qualityIncrease;
    private final int afterSellInIncreaseMultiplier;

    public AgedBrie(int qualityIncrease, int afterSellInIncreaseMultiplier) {
        this.qualityIncrease = qualityIncrease;
        this.afterSellInIncreaseMultiplier = afterSellInIncreaseMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality + qualityIncrease
            : item.quality + qualityIncrease * afterSellInIncreaseMultiplier;
    }
}
