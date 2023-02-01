package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater {


    public ConjuredItemUpdater(Item item) {
        super(item);

    }

    @Override
    public void updateItem() {
        if (item.quality > 1) {
            item.quality = item.quality - 2;
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }


}
