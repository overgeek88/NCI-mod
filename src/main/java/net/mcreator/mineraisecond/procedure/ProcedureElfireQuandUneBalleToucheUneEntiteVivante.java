package net.mcreator.mineraisecond.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureElfireQuandUneBalleToucheUneEntiteVivante extends ElementsClubInfoMod.ModElement {
	public ProcedureElfireQuandUneBalleToucheUneEntiteVivante(ElementsClubInfoMod instance) {
		super(instance, 492);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ElfireQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
