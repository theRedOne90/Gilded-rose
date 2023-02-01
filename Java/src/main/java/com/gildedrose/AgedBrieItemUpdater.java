package com.gildedrose;

public class AgedBrieItemUpdater extends ItemUpdater {

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        if (item.quality < 50) incrementQuality();

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) incrementQuality();
    }

    private void incrementQuality() {
        item.quality++;
    }
}
