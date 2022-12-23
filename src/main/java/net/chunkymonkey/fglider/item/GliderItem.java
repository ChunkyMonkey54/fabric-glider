package net.chunkymonkey.fglider.item;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.item.*;

public class GliderItem extends ElytraItem implements FabricElytraItem {

    public GliderItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.LEATHER);
    }
}
