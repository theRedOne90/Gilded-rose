package com.gildedrose;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        final ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

        for (Item item : items) {
            ItemUpdater itemUpdater = itemUpdaterFactory.getItemUpdater(item);
            itemUpdater.updateItem();
        }
    }
}
