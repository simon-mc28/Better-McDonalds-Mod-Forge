package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancements()));
    }

    private static class ModAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            Advancement START = Advancement.Builder.advancement()
                    .display(ModItems.HAPPY_MEAL.get().getDefaultInstance(),
                            Component.literal("Better McDonald's Mod"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".start.description"),
                            new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                            FrameType.TASK, false, false, false)
                    .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "start"), existingFileHelper);

            Advancement GET_SALT = Advancement.Builder.advancement()
                    .display(makeNormalDisplay(ModItems.SALT.get().getDefaultInstance(), FrameType.TASK, "get_salt"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SALT.get()))
                    .parent(START)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "get_salt"), existingFileHelper);

            Advancement CRAFT_KNIFE = Advancement.Builder.advancement()
                    .display(makeNormalDisplay(ModItems.KNIFE.get().getDefaultInstance(), FrameType.TASK, "craft_knife"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.KNIFE.get()))
                    .parent(START)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_knife"), existingFileHelper);

            Advancement.Builder.advancement()
                    .display(makeNormalDisplay(ModItems.HAMBURGER.get().getDefaultInstance(), FrameType.GOAL, "craft_burger"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HAMBURGER.get()))
                    .parent(CRAFT_KNIFE)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_burger"), existingFileHelper);

            Advancement.Builder.advancement()
                    .display(makeNormalDisplay(ModItems.COCA_COLA.get().getDefaultInstance(), FrameType.GOAL, "craft_drink"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COCA_COLA.get()))
                    .parent(GET_SALT)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_drink"), existingFileHelper);
        }
    }

    public static DisplayInfo makeNormalDisplay(ItemStack item, FrameType frame, String titleKey) {
        return new DisplayInfo(item.getItem().getDefaultInstance(),
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".title"),
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".description"),
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                frame, true, true, false);
    }
}
