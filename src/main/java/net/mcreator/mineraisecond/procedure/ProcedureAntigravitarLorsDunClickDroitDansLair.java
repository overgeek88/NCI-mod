package net.mcreator.mineraisecond.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureAntigravitarLorsDunClickDroitDansLair extends ElementsClubInfoMod.ModElement {
	public ProcedureAntigravitarLorsDunClickDroitDansLair(ElementsClubInfoMod instance) {
		super(instance, 483);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntigravitarLorsDunClickDroitDansLair!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).capabilities.isFlying = (true);
			((EntityPlayer) entity).sendPlayerAbilities();
		}
	}
}
