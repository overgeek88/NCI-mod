package net.mcreator.mineraisecond.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureElementiumardentSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil extends ElementsClubInfoMod.ModElement {
	public ProcedureElementiumardentSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil(ElementsClubInfoMod instance) {
		super(instance, 475);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ElementiumardentSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
