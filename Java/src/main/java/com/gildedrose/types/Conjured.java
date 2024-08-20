package com.gildedrose.types;

import com.gildedrose.Item;

public class Conjured implements QualifiedType {

    public static final String NAME = "Conjured Mana Cake";

    private final int normalQualityDecrease;
    private final int normalSellInMultiplier;
    private final int decreaseMultiplier;

    public Conjured(int normalQualityDecrease, int normalSellInMultiplier, int decreaseMultiplier) {
        this.normalQualityDecrease = normalQualityDecrease;
        this.normalSellInMultiplier = normalSellInMultiplier;
        this.decreaseMultiplier = decreaseMultiplier;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn > 0
            ? item.quality - normalQualityDecrease * decreaseMultiplier
            : item.quality - normalQualityDecrease * decreaseMultiplier * normalSellInMultiplier;
    }
}
