package com.gildedrose;

public class ItemUpdaterFactory {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    public ItemUpdater getItemUpdater(Item item) {

        switch (item.name) {
            case SULFURAS:
                return new ItemUpdater(item);
            case CONJURED:
                return new ConjuredItemUpdater(item);
            case BACKSTAGE_PASSES:
                return new BackStageItemUpdater(item);
            case AGED_BRIE:
                return new AgedBrieItemUpdater(item);
            default:
                return new StandardItemUpdater(item);
        }
    }
}
