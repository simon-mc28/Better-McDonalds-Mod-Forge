package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterMcDonaldsMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> BETTER_MCDONALDS_MOD_TAB =
            CREATIVE_MODE_TABS.register("better_mcdonalds_mod_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.HAPPY_MEAL.get()))
                    .title(Component.literal("Better McDonald's Mod")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
