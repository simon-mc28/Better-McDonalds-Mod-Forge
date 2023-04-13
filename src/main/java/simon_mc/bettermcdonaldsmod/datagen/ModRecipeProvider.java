package simon_mc.bettermcdonaldsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SALT_BLOCK.get(), 1)
                .define('#', ModItems.SALT.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModItems.SALT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESE.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(ModItems.SALT.get())
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModItems.SALT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BEEF_PATTY.get())
                .requires(ModItems.KNIFE.get())
                .requires(Items.BEEF.asItem())
                .unlockedBy(getHasName(Items.BEEF.asItem()), has(Items.BEEF.asItem()))
                .save(consumer);

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_smelting");

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_smoking");

        SimpleCookingRecipeBuilder.generic(Ingredient.of(ModItems.BEEF_PATTY.get()), RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                .unlockedBy(getHasName(ModItems.BEEF_PATTY.get()), has(ModItems.BEEF_PATTY.get()))
                .save(consumer, getItemName(ModItems.COOKED_BEEF_PATTY.get()) + "_campfire_cooking");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MAYONNAISE.get())
                .requires(Items.EGG.asItem())
                .unlockedBy(getHasName(Items.EGG.asItem()), has(Items.EGG.asItem()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_SOUR_SAUCE.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModItems.SALT.get())
                .requires(Items.WHEAT.asItem())
                .requires(Items.ORANGE_DYE.asItem())
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModItems.SALT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.KETCHUP.get())
                .requires(Items.RED_DYE.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(ModItems.SALT.get())
                .unlockedBy(getHasName(ModItems.SALT.get()), has(ModItems.SALT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HAMBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESEBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.CHEESE.get())
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BIG_MAC.get())
                .requires(Items.BREAD.asItem())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.COOKED_BEEF_PATTY.get())
                .requires(ModItems.CHEESE.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KNIFE.get(), 1)
                .define('I', Items.IRON_INGOT.asItem())
                .define('S', Items.STICK.asItem())
                .pattern("  I")
                .pattern(" I ")
                .pattern("S  ")
                .unlockedBy(getHasName(Items.IRON_INGOT.asItem()), has(Items.IRON_INGOT.asItem()))
                .save(consumer);
    }
}