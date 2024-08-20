package com.gildedrose.types;

import com.gildedrose.Item;

public class AgedBrie implements QualifiedType {

    public static final String NAME = "Aged Brie";

    private final QualifiedType basicType;

    public AgedBrie(QualifiedType basicType) {
        this.basicType = new Basic(
            basicType.getQualityChange() * -1,
            basicType.getAfterSellInQualityChangeMultiplier()
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
    public int getAfterSellInQualityChangeMultiplier() {
        return basicType.getAfterSellInQualityChangeMultiplier();
    }
}
