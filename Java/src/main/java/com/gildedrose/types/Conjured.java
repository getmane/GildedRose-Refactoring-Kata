package com.gildedrose.types;

import com.gildedrose.Item;

public class Conjured implements QualifiedType {

    public static final String NAME = "Conjured Mana Cake";

    private final Basic basicType;
    private final int qualityChange;

    public Conjured(QualifiedType basicType, int reduceMultiplier) {
        this.qualityChange = basicType.getQualityChange() * reduceMultiplier;
        this.basicType = new Basic(
            qualityChange,
            basicType.getThresholdQualityChangeMultiplier()
        );
    }

    @Override
    public int calculateQuality(Item item) {
        return basicType.calculateQuality(item);
    }

    @Override
    public int getQualityChange() {
        return qualityChange;
    }

    @Override
    public int getThresholdQualityChangeMultiplier() {
        return basicType.getThresholdQualityChangeMultiplier();
    }
}
