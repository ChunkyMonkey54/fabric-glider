package net.chunkymonkey.fglider.item;

import net.chunkymonkey.fglider.FabricGlider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WING = registerItem("wing",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item GLIDER = registerItem("glider",
            (Item)(new GliderItem((new Item.Settings()).maxDamage(432).group(ItemGroup.TRANSPORTATION).rarity(Rarity.COMMON))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabricGlider.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FabricGlider.LOGGER.debug("Registering Mod Items for " + FabricGlider.MOD_ID);
    }
}
