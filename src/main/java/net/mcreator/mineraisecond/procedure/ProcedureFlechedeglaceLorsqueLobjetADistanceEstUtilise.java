package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFlechedeglaceLorsqueLobjetADistanceEstUtilise extends ElementsClubInfoMod.ModElement {
	public ProcedureFlechedeglaceLorsqueLobjetADistanceEstUtilise(ElementsClubInfoMod instance) {
		super(instance, 462);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FlechedeglaceLorsqueLobjetADistanceEstUtilise!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FlechedeglaceLorsqueLobjetADistanceEstUtilise!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FlechedeglaceLorsqueLobjetADistanceEstUtilise!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlechedeglaceLorsqueLobjetADistanceEstUtilise!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.spawnParticle(EnumParticleTypes.SPIT, x, y, z, x, y, z);
	}
}