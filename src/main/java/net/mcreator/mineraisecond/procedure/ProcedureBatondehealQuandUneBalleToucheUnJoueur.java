package net.mcreator.mineraisecond.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureBatondehealQuandUneBalleToucheUnJoueur extends ElementsClubInfoMod.ModElement {
	public ProcedureBatondehealQuandUneBalleToucheUnJoueur(ElementsClubInfoMod instance) {
		super(instance, 490);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BatondehealQuandUneBalleToucheUnJoueur!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (int) 1, (int) 1, (false), (false)));
	}
}
