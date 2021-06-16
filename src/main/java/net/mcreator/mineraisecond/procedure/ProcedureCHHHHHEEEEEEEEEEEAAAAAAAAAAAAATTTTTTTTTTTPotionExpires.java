package net.mcreator.mineraisecond.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureCHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTTPotionExpires extends ElementsClubInfoMod.ModElement {
	public ProcedureCHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTTPotionExpires(ElementsClubInfoMod instance) {
		super(instance, 68);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTTPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("La drogue c'est pas bien."), (false));
		}
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 300, (int) 3));
	}
}
