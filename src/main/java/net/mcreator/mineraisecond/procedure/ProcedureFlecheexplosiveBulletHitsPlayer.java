package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFlecheexplosiveBulletHitsPlayer extends ElementsClubInfoMod.ModElement {
	public ProcedureFlecheexplosiveBulletHitsPlayer(ElementsClubInfoMod instance) {
		super(instance, 120);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FlecheexplosiveBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FlecheexplosiveBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FlecheexplosiveBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlecheexplosiveBulletHitsPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 3, true);
		}
	}
}
