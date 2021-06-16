package net.mcreator.mineraisecond.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFireQuandUneBalleToucheUneEntiteVivante extends ElementsClubInfoMod.ModElement {
	public ProcedureFireQuandUneBalleToucheUneEntiteVivante(ElementsClubInfoMod instance) {
		super(instance, 515);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
