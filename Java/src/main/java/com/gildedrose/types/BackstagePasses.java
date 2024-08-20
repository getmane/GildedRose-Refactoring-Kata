package com.gildedrose.types;

import com.gildedrose.Item;

import java.util.NavigableMap;
import java.util.NoSuchElementException;

public class BackstagePasses implements QualifiedType {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    private final NavigableMap<Integer, Integer> sellInToQualityStages;
    private final int afterSellInQuality;
    private final int defaultTransformation;

    public BackstagePasses(
        QualifiedType basicType,
        NavigableMap<Integer, Integer> sellInToQualityStages
    ) {
        this.sellInToQualityStages = sellInToQualityStages;
        this.defaultTransformation = basicType.getQualityChange() * -1;

        this.afterSellInQuality = 0;
    }

    @Override
    public int calculateQuality(Item item) {
        return item.sellIn <= 0
            ? afterSellInQuality
            : item.quality + getCurrentStage(item.sellIn);
    }

    @Override
    public int getQualityChange() {
        return defaultTransformation;
    }

    @Override
    public int getThresholdQualityChangeMultiplier() {
        return afterSellInQuality;
    }

    private int getCurrentStage(int sellIn) {
        try {
            return sellInToQualityStages.get(sellInToQualityStages.tailMap(sellIn, true).firstKey());
        } catch (NoSuchElementException ex) {
            return defaultTransformation;
        }
    }
}
