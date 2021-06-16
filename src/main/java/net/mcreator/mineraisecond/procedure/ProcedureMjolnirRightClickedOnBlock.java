package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureMjolnirRightClickedOnBlock extends ElementsClubInfoMod.ModElement {
	public ProcedureMjolnirRightClickedOnBlock(ElementsClubInfoMod instance) {
		super(instance, 399);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MjolnirRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MjolnirRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MjolnirRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MjolnirRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
	}
}
