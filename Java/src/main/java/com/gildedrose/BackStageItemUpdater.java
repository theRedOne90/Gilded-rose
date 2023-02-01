package com.gildedrose;

public class BackStageItemUpdater extends ItemUpdater {


    public BackStageItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality() {
        if (item.quality < 50) item.quality++;
    }

}
