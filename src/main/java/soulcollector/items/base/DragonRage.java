package soulcollector.items.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class DragonRage extends SwordItem {
    public DragonRage(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static int getMode(ItemStack stack){
        return stack.getOrCreateNbt().getInt("dragonRageMode");
    }

    public static void setMode(ItemStack stack, int mode){
        stack.getOrCreateNbt().putInt("dragonRageMode", mode);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();
        ItemStack stack = user.getStackInHand(hand);
        if(user.isSneaking()){
            if(getMode(stack) == 0){
                setMode(stack, 1);
            }
            else if(getMode(stack) == 1){
                setMode(stack, 0);
            }
            return TypedActionResult.success(stack);
        }
        else{
            if(world.isClient){
                Random random = world.getRandom();
                for(int i = 0; i <= 250; i++){
                    double px = random.nextFloat() * 8 - 4;
                    double py = random.nextFloat() * 4 - 2;
                    double pz = random.nextFloat() * 8 - 4;
                    world.addParticle(ParticleTypes.FLAME, x + px, y + py, z + pz, 0, 0, 0);
                }
                return TypedActionResult.success(stack);
            }
            else{
                if(getMode(user.getStackInHand(Hand.MAIN_HAND)) == 1){
                    List<Entity> entities = world.getOtherEntities(user, new Box(x-4, y-2, z-4, x+4, y+2, z+4));
                    for(Entity entity : entities){
                        entity.setVelocity(0, 2.22, 0);
                    }
                    world.playSound(
                            null,
                            user.getX(),
                            user.getY(),
                            user.getZ(),
                            SoundEvents.ENTITY_ENDER_DRAGON_GROWL,
                            SoundCategory.PLAYERS,
                            3F,
                            0.75F
                    );
                    stack.setDamage(stack.getDamage()+11);
                    user.getItemCooldownManager().set(this, 400);
                    return TypedActionResult.success(user.getStackInHand(hand));
                }
            }
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    @Override
    public float getAttackDamage() {
        return super.getAttackDamage();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip1").formatted(Formatting.DARK_GRAY));
        tooltip.add(new TranslatableText("item.soulcoll.dragon_rage.tooltip2").formatted(Formatting.DARK_GRAY));
        if(getMode(stack) == 0){
            tooltip.add(new LiteralText("Mode: Melee").formatted(Formatting.DARK_GREEN));
        }
        else if(getMode(stack) == 1){
            tooltip.add(new LiteralText("Mode: Ability").formatted(Formatting.DARK_GREEN));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
