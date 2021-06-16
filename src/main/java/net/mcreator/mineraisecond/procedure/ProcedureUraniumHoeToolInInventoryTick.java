package net.mcreator.mineraisecond.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.item.ItemAntiradioactif;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureUraniumHoeToolInInventoryTick extends ElementsClubInfoMod.ModElement {
	public ProcedureUraniumHoeToolInInventoryTick(ElementsClubInfoMod instance) {
		super(instance, 446);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UraniumHoeToolInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAntiradioactif.helmet, (int) (1)))
				: false)) {
			if (((entity instanceof EntityPlayer)
					? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAntiradioactif.body, (int) (1)))
					: false)) {
				if (((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAntiradioactif.legs, (int) (1)))
						: false)) {
					if (((entity instanceof EntityPlayer)
							? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(ItemAntiradioactif.boots, (int) (1)))
							: false)) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 0);
					} else {
						if (entity instanceof EntityLivingBase)
							((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, (int) 60, (int) 1));
					}
				}
			}
		}
	}
}
