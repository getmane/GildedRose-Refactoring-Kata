package com.gildedrose.types;

import com.gildedrose.Item;

public interface QualifiedType {

    int calculateQuality(Item item);

    int getQualityChange();

    int getAfterSellInQualityMultiplier();
}
