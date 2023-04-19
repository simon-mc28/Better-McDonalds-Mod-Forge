package simon_mc.bettermcdonaldsmod.worldgen.feature;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;

import java.util.List;

import static simon_mc.bettermcdonaldsmod.util.worldgen.ModFeatureUtils.createKey;

public class ModMiscOverworldFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SALT_BLOCK = createKey("disk_salt_block");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, ModMiscOverworldFeatures.DISK_SALT_BLOCK, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SALT_BLOCK.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.SAND)), UniformInt.of(2, 3), 1));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration) {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
