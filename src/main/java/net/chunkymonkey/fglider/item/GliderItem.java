package net.chunkymonkey.fglider.item;

import net.minecraft.item.*;

public class GliderItem extends ElytraItem {

    public GliderItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.LEATHER);
    }
}
