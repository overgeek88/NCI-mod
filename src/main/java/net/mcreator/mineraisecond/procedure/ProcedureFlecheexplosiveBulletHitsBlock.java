package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFlecheexplosiveBulletHitsBlock extends ElementsClubInfoMod.ModElement {
	public ProcedureFlecheexplosiveBulletHitsBlock(ElementsClubInfoMod instance) {
		super(instance, 119);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FlecheexplosiveBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FlecheexplosiveBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FlecheexplosiveBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlecheexplosiveBulletHitsBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 5, true);
		}
	}
}
