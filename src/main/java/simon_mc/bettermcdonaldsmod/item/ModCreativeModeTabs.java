package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;

@Mod.EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab BETTER_MCDONALDS_MOD_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
         BETTER_MCDONALDS_MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "better_mcdonalds_mod_tab"),
                 builder -> builder.icon(() -> new ItemStack(ModItems.HAPPY_MEAL.get()))
                         .title(Component.translatable("creativemodetab.bettermcdonaldsmod.tab")));
    }
}
