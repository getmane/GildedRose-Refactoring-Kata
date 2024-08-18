package com.gildedrose;



import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(
            item -> item.quality = switch (item.name) {
                case "Aged brie" -> calculateAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> calculateBackStagePasses(item);
                case "Conjured" -> calculateConjured(item);
                case "Sulfuras, Hand of Ragnaros" -> 80;
                default -> calculateNormal(item);
            }
        );
    }

    private int calculateNormal(Item item) {
        return item.sellIn > 0 ? item.quality - 1 : item.quality - 2;
    }

    private int calculateAgedBrie(Item item) {
        return item.sellIn > 0 ? item.quality + 1 : item.quality + 2;
    }

    private int calculateBackStagePasses(Item item) {
        int quality = item.quality;

        if (item.sellIn <= 0) {
            quality = 0;
        } else if (item.sellIn <= 5) {
            quality += 3;
        } else if (item.sellIn <= 10) {
            quality += 2;
        }
        return quality;
    }

    private int calculateConjured(Item item) {
        return item.sellIn > 0 ? item.quality - 2 : item.quality - 4;
    }
}
