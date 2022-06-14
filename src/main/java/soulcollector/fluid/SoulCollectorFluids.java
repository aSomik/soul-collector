package soulcollector.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.SoulCollectorMod;

public class SoulCollectorFluids {

    public static final FlowableFluid STILL_MELIS = new MelisFluid.Still();
    public static final FlowableFluid FLOWING_MELIS =new MelisFluid.Flowing();

    public static void register(){

        Registry.register(Registry.FLUID, new Identifier(SoulCollectorMod.MODID, "melis"), STILL_MELIS);
        Registry.register(Registry.FLUID, new Identifier(SoulCollectorMod.MODID, "flowing_melis"), FLOWING_MELIS);
    }
}
