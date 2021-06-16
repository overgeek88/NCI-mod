package net.mcreator.mineraisecond.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureTiquetshopLorsDunClickDroitDansLair extends ElementsClubInfoMod.ModElement {
	public ProcedureTiquetshopLorsDunClickDroitDansLair(ElementsClubInfoMod instance) {
		super(instance, 468);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TiquetshopLorsDunClickDroitDansLair!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity)
					.sendStatusMessage(new TextComponentString("contacter un mod\u00E9rateur ou un administrateur pour recevoir le shop"), (false));
		}
	}
}
