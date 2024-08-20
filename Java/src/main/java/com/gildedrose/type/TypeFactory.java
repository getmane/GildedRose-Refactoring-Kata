package com.gildedrose.type;

import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TypeFactory {

    private final Map<String, QualifiedType> specialTypes;
    private final Normal normalType;

    public TypeFactory() {
        this.specialTypes = new HashMap<>();

        this.normalType = new Normal(1, 2);

        specialTypes.put(
            AgedBrie.NAME,
            new AgedBrie(
                normalType.getQualityDecrease() * -1,
                normalType.getQualityDecreaseMultiplier()
            )
        );
        specialTypes.put(
            Conjured.NAME,
            new Conjured(
                normalType.getQualityDecrease(),
                normalType.getQualityDecreaseMultiplier(),
                2
            )
        );
        specialTypes.put(Sulfuras.NAME, new Sulfuras(80));

        NavigableMap<Integer, Integer> backstageTransforms = new TreeMap<>();

        backstageTransforms.put(5, 3);
        backstageTransforms.put(10, 2);

        specialTypes.put(
            BackstagePasses.NAME,
            new BackstagePasses(backstageTransforms, normalType.getQualityDecrease() * -1)
        );
    }

    public QualifiedType typeOf(Item item) {
        return specialTypes.getOrDefault(item.name, normalType);
    }
}
