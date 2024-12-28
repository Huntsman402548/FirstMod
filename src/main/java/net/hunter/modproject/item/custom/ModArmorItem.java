package net.hunter.modproject.item.custom;

import com.google.common.collect.ImmutableMap;
import net.hunter.modproject.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    public static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> Material_To_Effect_Map =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.SAPPHIRE,
                        List.of(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400,1,false,false))).build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : Material_To_Effect_Map.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectsforMaterials(player,mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectsforMaterials(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));
            if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
                for(StatusEffectInstance instance : mapStatusEffect) {
                    player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                            instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()
                            ));
                }
            }



    }
    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack Boots = player.getInventory().getArmorStack(0);
        ItemStack Leggings = player.getInventory().getArmorStack(1);
        ItemStack Chestplate = player.getInventory().getArmorStack(2);
        ItemStack Helmet = player.getInventory().getArmorStack(3);

        return !Helmet.isEmpty() && !Leggings.isEmpty() && !Chestplate.isEmpty() && !Boots.isEmpty();


    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof  ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots =  ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings =  ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate =  ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet =  ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material
                && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
