package com.gildedrose;

import com.gildedrose.types.TypeFactory;
import com.gildedrose.types.validator.QualityValidator;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    private static final TypeFactory TYPE_FACTORY = new TypeFactory();
    private static final QualityValidator QUALITY_VALIDATOR = new QualityValidator(50);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(
            item -> {
                item.quality = QUALITY_VALIDATOR.validate(TYPE_FACTORY.typeOf(item).calculateQuality(item));
                item.sellIn--;
            }
        );
    }
}
