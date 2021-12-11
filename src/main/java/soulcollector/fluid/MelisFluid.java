package soulcollector.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import soulcollector.blocks.SoulCollectorBlocks;
import soulcollector.items.SoulCollectorItems;

public abstract class MelisFluid extends BaseFluid {
    @Override
    public Fluid getStill() {
        return SoulCollectorFluids.STILL_MELIS;
    }

    @Override
    public Fluid getFlowing() {
        return SoulCollectorFluids.FLOWING_MELIS;
    }

    @Override
    public Item getBucketItem() {
        return SoulCollectorItems.MELIS_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return SoulCollectorBlocks.MELIS.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends MelisFluid {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends MelisFluid {

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}