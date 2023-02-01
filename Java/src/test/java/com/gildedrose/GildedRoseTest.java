package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void multiple_items_quality_sellin_decrease() {
        Item item_1 = new Item("Elixir of the Mongoose", 5, 7);
        Item item_2 = new Item("+5 Dexterity Vest", 7, 6);

        GildedRose app = new GildedRose(new Item[]{item_1, item_2});
        app.updateQuality();
        assertEquals(6, item_1.quality);
        assertEquals(4, item_1.sellIn);

        assertEquals(5, item_2.quality);
        assertEquals(6, item_2.sellIn);
    }

    @Test
    void quality_down_twice_faster_whenExpired() {
        Item item = new Item("Elixir of the Mongoose", 0, 7);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(5, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    void normal_quality_decrease_with_1_day_left() {
        Item item = new Item("Elixir of the Mongoose", 1, 7);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(6, item.quality);
        assertEquals(0, item.sellIn);
    }

    @Test
    void quality_is_never_negative() {
        Item item = new Item("foo", 1, 0);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void quality_should_move_to_zero() {
        Item item = new Item("foo", 1, 1);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void quality_is_never_more_than_50() {
        Item item = new Item("Aged Brie", 10, 50);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    void agedBrie_quality_increase() {
        Item item = new Item("Aged Brie", 10, 15);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(16, item.quality);
    }

    @Test
    void agedBrie_quality_is_never_more_than_50() {
        Item item = new Item("Aged Brie", 0, 50);

        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(50, item.quality);
    }


    @Test
    void agedBrie_quality_increases_twice_faster_whenExpired() {
        Item item = new Item("Aged Brie", 0, 6);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(8, item.quality);
    }

    @Test
    void legendary_items_never_updated() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstage_passes_quality_drops_to_zero_whenExpired() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(0, item.quality);
    }


    @Test
    void backstage_passes_quality_increase_over_days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(21, item.quality);
        assertEquals(14, item.sellIn);
    }

    @Test
    void backstage_passes_quality_49_increase_50_when_there_are_10_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(50, item.quality);
    }

    @Test
    void backstage_passes_increase_quality_2_when_there_are_10_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(22, item.quality);
    }
    @Test
    void backstage_passes_quality_increase_2_when_6_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 46);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(48, item.quality);
    }

    @Test
    void backstage_passes_increase_quality_1_with_more_10_days_left() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(49, item.quality);
    }



    @Test
    void backstage_passes_quality_increase_by_3_when_there_are_5_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(23, item.quality);
    }

    @Test
    void backstage_passes_quality_47_increase_to_50_when_5_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(50, item.quality);
    }

    @Test
    void backstage_passes_quality_49_increase_to_50_when_5_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertEquals(50, item.quality);
    }


}
