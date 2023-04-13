package simon_mc.bettermcdonaldsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
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

    public static final RegistryObject<Item> BEEF_PATTY = ITEMS.register("beef_patty",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).meat().build())));

    public static final RegistryObject<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).meat().build())));

    public static final RegistryObject<Item> MAYONNAISE = ITEMS.register("mayonnaise",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(0.3f).build())));

    public static final RegistryObject<Item> BIG_MAC = ITEMS.register("big_mac",
            () -> new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(7).saturationMod(0.3f).build())));

    public static final RegistryObject<SwordItem> KNIFE = ITEMS.register("knife",
            () -> new SwordItem(new Tier() {
                @Override
                public int getUses() {
                    return 150;
                }

                @Override
                public float getSpeed() {
                    return 2f;
                }

                @Override
                public float getAttackDamageBonus() {
                    return -2f;
                }

                @Override
                public int getLevel() {
                    return 0;
                }

                @Override
                public int getEnchantmentValue() {
                    return 0;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return Ingredient.of(new ItemStack(Items.IRON_INGOT.asItem()));
                }
            }, 3, -3f, new Item.Properties().rarity(Rarity.COMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
