package simon_mc.bettermcdonaldsmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.ModCreativeModeTabs;
import simon_mc.bettermcdonaldsmod.item.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "bettermcdonaldsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public BetterMcDonaldsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabs.BETTER_MCDONALDS_MOD_TAB) {
            event.accept(ModBlocks.SALT_BLOCK);
            event.accept(ModItems.SALT);
            event.accept(ModItems.CHEESE);
            event.accept(ModItems.BEEF_PATTY);
            event.accept(ModItems.COOKED_BEEF_PATTY);
            event.accept(ModItems.MAYONNAISE);
            event.accept(ModItems.SWEET_SOUR_SAUCE);
            event.accept(ModItems.KETCHUP);
            event.accept(ModItems.HAMBURGER);
            event.accept(ModItems.CHEESEBURGER);
            event.accept(ModItems.KNIFE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
