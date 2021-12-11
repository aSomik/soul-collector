package soulcollector.blocks.base;

import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;

public class BaseFluidBlock extends FluidBlock {
    public BaseFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }
}
