package com.gildedrose.types;

import com.gildedrose.Item;

public class Conjured implements QualifiedType {

    public static final String NAME = "Conjured Mana Cake";

    private final Basic basicType;

    public Conjured(QualifiedType basicType, int reduceMultiplier) {
        this.basicType = new Basic(
            basicType.getQualityChange() * reduceMultiplier,
            basicType.getAfterSellInQualityMultiplier() * reduceMultiplier
        );
    }

    @Override
    public int calculateQuality(Item item) {
        return basicType.calculateQuality(item);
    }

    @Override
    public int getQualityChange() {
        return basicType.getQualityChange();
    }

    @Override
    public int getAfterSellInQualityMultiplier() {
        return basicType.getAfterSellInQualityMultiplier();
    }
}