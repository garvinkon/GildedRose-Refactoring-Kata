package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch(items[i].name){
                case "Aged Brie":
                    updateAgedBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePass(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    updateSulfuras(items[i]);
                    break;
                case "Conjured":
                    updateConjuredItem(items[i]);
                    break;
                default:
                    updateNormalItem(items[i]);
            }
        }
    }

    public void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    public void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    public void updateSulfuras(Item item) {
        // Sulfuras doesn't need to be updated.
    }

    public void updateNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }

    public void updateConjuredItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }

        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
        }
    }
}   