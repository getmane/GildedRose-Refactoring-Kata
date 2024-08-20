package com.gildedrose.types;

import com.gildedrose.Item;

public class AgedBrie implements QualifiedType {

    public static final String NAME = "Aged Brie";

    private final QualifiedType basicType;
    private final int qualityChange;

    public AgedBrie(QualifiedType basicType) {
        this.qualityChange = basicType.getQualityChange() * -1;
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
