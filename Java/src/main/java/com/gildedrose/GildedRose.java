package com.gildedrose;

import com.gildedrose.types.AgedBrie;
import com.gildedrose.types.BackstagePasses;
import com.gildedrose.types.Conjured;
import com.gildedrose.types.QualifiedType;
import com.gildedrose.types.Basic;
import com.gildedrose.types.Sulfuras;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

class GildedRose {
    Item[] items;

    private static final int QUALITY_CAP = 50;

    private final Map<String, QualifiedType> types;
    private final QualifiedType basicType;

    public GildedRose(Item[] items) {
        this.items = items;
        this.types = new HashMap<>();

        this.basicType = new Basic(1, 2);

        types.put(AgedBrie.NAME, new AgedBrie(basicType));
        types.put(Conjured.NAME, new Conjured(basicType, 2));
        types.put(Sulfuras.NAME, new Sulfuras(80));

        NavigableMap<Integer, Integer> backstageTransforms = new TreeMap<>();

        backstageTransforms.put(5, 3);
        backstageTransforms.put(10, 2);

        types.put(
            BackstagePasses.NAME,
            new BackstagePasses(backstageTransforms, basicType.getQualityChange())
        );
    }

    public void updateQuality() {
        Arrays.stream(items).filter(GildedRose::itemIsNotSulfuras).forEach(
            item -> {
                item.quality = types.getOrDefault(item.name, basicType).calculateQuality(item);
                if (item.quality > QUALITY_CAP) {
                    item.quality = QUALITY_CAP;
                }
                item.sellIn--;
            }
        );
    }

    private static boolean itemIsNotSulfuras(Item item) {
        return !item.name.equals(Sulfuras.NAME);
    }
}
