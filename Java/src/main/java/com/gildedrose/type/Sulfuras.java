package com.gildedrose.type;

import com.gildedrose.Item;

public class Sulfuras implements QualifiedType {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    private final int constantQuality;

    public Sulfuras(int constantQuality) {
        this.constantQuality = constantQuality;
    }

    @Override
    public int calculateQuality(Item item) {
        return constantQuality;
    }
}
