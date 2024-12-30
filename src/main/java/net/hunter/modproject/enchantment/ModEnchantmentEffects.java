package net.hunter.modproject.enchantment;

import com.mojang.serialization.MapCodec;
import net.hunter.modproject.ModProject;
import net.hunter.modproject.enchantment.custom.SpeedBoostEnchantmentEffect;
import net.hunter.modproject.enchantment.custom.ZeusFuryEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    //Names EntityEffects
    public static final MapCodec<? extends EnchantmentEntityEffect> ZEUS_FURY =
            registerEntityEffect("zeus_fury", ZeusFuryEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> SPEED_BOOST =
            registerEntityEffect("speed_boost", SpeedBoostEnchantmentEffect.CODEC);


    //Calls and registers each EntityEffect into generated
    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(ModProject.MOD_ID, name), codec);
    }
    public static void registerEnchantmentEffects(){
        ModProject.LOGGER.info("Registering mod enchantments for " + ModProject.MOD_ID);
    }
}
