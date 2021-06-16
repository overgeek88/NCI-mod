package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureSuperTntRedstoneOn extends ElementsClubInfoMod.ModElement {
	public ProcedureSuperTntRedstoneOn(ElementsClubInfoMod instance) {
		super(instance, 245);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SuperTntRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SuperTntRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SuperTntRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SuperTntRedstoneOn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.playSound((EntityPlayer) null, (x + 0.5), (y + 0.5), (z + 0.5),
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.tnt.primed")),
				SoundCategory.NEUTRAL, (float) 1, (float) 1.5);
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityMinecartTNT(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles((x + 0.5), (y + 0.5), (z + 0.5), world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
	}
}
