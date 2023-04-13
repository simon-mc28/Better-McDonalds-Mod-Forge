package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.BEEF_PATTY);
        simpleItem(ModItems.COOKED_BEEF_PATTY);
        simpleItem(ModItems.MAYONNAISE);
        simpleItem(ModItems.SWEET_SOUR_SAUCE);
        simpleItem(ModItems.KETCHUP);
        simpleItem(ModItems.HAMBURGER);
        simpleItem(ModItems.CHEESEBURGER);
        simpleItem(ModItems.BIG_MAC);
        simpleItem(ModItems.CHICKENBURGER);
        simpleItem(ModItems.MCCHICKEN);
        simpleItem(ModItems.FILET_O_FISH);
        simpleItem(ModItems.CHICKEN_MCNUGGETS);
        simpleItem(ModItems.FRIES);
        handheldItem(ModItems.KNIFE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<SwordItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
