package net.hunter.modproject.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record SpeedBoostEnchantmentEffect() implements EnchantmentEntityEffect {
    //Sets Codec data
    public static final MapCodec<SpeedBoostEnchantmentEffect> CODEC = MapCodec.unit(SpeedBoostEnchantmentEffect::new);

    //Applies the speed boost effect to user
    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos){
        if (user instanceof PlayerEntity player) {
            int duration = 100 + (level * 20); // Extend duration by 1 second per level
            int amplifier = level - 1; // Increase amplifier with level (level 1 = Speed I)

            StatusEffectInstance currentEffect = player.getStatusEffect(StatusEffects.SPEED);
            if (currentEffect == null || currentEffect.getAmplifier() < amplifier || currentEffect.getDuration() < duration) {
                player.addStatusEffect(new StatusEffectInstance(
                        StatusEffects.SPEED,
                        duration,
                        amplifier
                ));
            }
        }
    }


    //Returns Codec data when called
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}