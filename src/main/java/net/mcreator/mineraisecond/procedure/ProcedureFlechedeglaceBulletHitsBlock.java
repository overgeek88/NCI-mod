package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFlechedeglaceBulletHitsBlock extends ElementsClubInfoMod.ModElement {
	public ProcedureFlechedeglaceBulletHitsBlock(ElementsClubInfoMod instance) {
		super(instance, 242);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FlechedeglaceBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FlechedeglaceBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FlechedeglaceBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlechedeglaceBulletHitsBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.SNOW_LAYER.getDefaultState(), 3);
	}
}
