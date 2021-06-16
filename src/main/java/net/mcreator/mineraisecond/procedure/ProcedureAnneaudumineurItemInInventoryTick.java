package net.mcreator.mineraisecond.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureAnneaudumineurItemInInventoryTick extends ElementsClubInfoMod.ModElement {
	public ProcedureAnneaudumineurItemInInventoryTick(ElementsClubInfoMod instance) {
		super(instance, 370);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AnneaudumineurItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.LUCK, (int) 60, (int) 5));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, (int) 60, (int) 2));
	}
}
