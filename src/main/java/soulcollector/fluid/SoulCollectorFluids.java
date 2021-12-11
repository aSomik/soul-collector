package soulcollector.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;

public class SoulCollectorFluids {

    public static FlowableFluid STILL_MELIS;
    public static FlowableFluid FLOWING_MELIS;

    public static void register(){

        STILL_MELIS = Registry.register(Registry.FLUID, new Identifier(MainClassMod.MODID, "melis"), new MelisFluid.Still());
        FLOWING_MELIS = Registry.register(Registry.FLUID, new Identifier(MainClassMod.MODID, "flowing_melis"), new MelisFluid.Flowing());
    }
}
