package net.mcreator.mineraisecond.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureCyclonQuandUneBalleToucheUneEntiteVivante extends ElementsClubInfoMod.ModElement {
	public ProcedureCyclonQuandUneBalleToucheUneEntiteVivante(ElementsClubInfoMod instance) {
		super(instance, 495);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CyclonQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
