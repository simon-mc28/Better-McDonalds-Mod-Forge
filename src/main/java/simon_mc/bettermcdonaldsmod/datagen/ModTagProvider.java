package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import simon_mc.bettermcdonaldsmod.BetterMcDonaldsMod;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModTagProvider {
    public static class Items extends TagsProvider<Item>{
        public static final TagKey<Item> SALT = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "dusts/salt"));
        public static final TagKey<Item> BURGERS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "burgers"));
        public static final TagKey<Item> SAUCES = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "sauces"));

        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            TagAppender<Item> saltTagAppender = tag(SALT);
            saltTagAppender.add(ModItems.SALT.getKey());

            TagAppender<Item> burgerTagAppender = tag(BURGERS);
            burgerTagAppender.add(ModItems.HAMBURGER.getKey());
            burgerTagAppender.add(ModItems.CHEESEBURGER.getKey());
            burgerTagAppender.add(ModItems.BIG_MAC.getKey());
            burgerTagAppender.add(ModItems.CHICKENBURGER.getKey());
            burgerTagAppender.add(ModItems.MCCHICKEN.getKey());
            burgerTagAppender.add(ModItems.FILET_O_FISH.getKey());

            TagAppender<Item> sauceTagAppender = tag(SAUCES);
            sauceTagAppender.add(ModItems.MAYONNAISE.getKey());
            sauceTagAppender.add(ModItems.SWEET_SOUR_SAUCE.getKey());
            sauceTagAppender.add(ModItems.KETCHUP.getKey());
        }
    }

    public static class Blocks extends TagsProvider<Block>{
        public static final TagKey<Block> SALT_BLOCK = ForgeRegistries.BLOCKS.tags().createTagKey(new ResourceLocation("forge", "salt"));

        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            TagAppender<Block> saltBlockTagAppender = tag(SALT_BLOCK);
            saltBlockTagAppender.add(ModBlocks.SALT_BLOCK.getKey());
        }
    }
}
