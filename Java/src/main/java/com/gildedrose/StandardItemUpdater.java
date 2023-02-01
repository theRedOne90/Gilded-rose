package com.gildedrose;

public class StandardItemUpdater extends ItemUpdater {


    public StandardItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        decreaseQuality();
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (item.quality > 0)
            item.quality--;
    }
}
