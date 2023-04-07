package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMcDonaldsMod.MOD_ID);

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
