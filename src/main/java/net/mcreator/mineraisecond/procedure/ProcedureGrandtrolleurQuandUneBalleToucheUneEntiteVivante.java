package net.mcreator.mineraisecond.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.mineraisecond.potion.PotionCHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTT;
import net.mcreator.mineraisecond.item.ItemTrolliumGem;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureGrandtrolleurQuandUneBalleToucheUneEntiteVivante extends ElementsClubInfoMod.ModElement {
	public ProcedureGrandtrolleurQuandUneBalleToucheUneEntiteVivante(ElementsClubInfoMod instance) {
		super(instance, 518);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GrandtrolleurQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GrandtrolleurQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GrandtrolleurQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GrandtrolleurQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GrandtrolleurQuandUneBalleToucheUneEntiteVivante!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double rouedelachance = 0;
		rouedelachance = (double) (10 * Math.random());
		if (((0 < (rouedelachance)) && ((rouedelachance) < 0.2))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("1supreme!"), (false));
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity)
						.addPotionEffect(new PotionEffect(PotionCHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTT.potion, (int) 60, (int) 1, (true), (true)));
		}
		if (((0 < (rouedelachance)) && ((rouedelachance) < 1))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("1!"), (false));
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (int) 60, (int) 1, (false), (false)));
		}
		if (((1 < (rouedelachance)) && ((rouedelachance) < 2))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("2!"), (false));
			}
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, true);
			}
		}
		if (((2 < (rouedelachance)) && ((rouedelachance) < 3))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("3!"), (false));
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		}
		if (((3 < (rouedelachance)) && ((rouedelachance) < 4))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("4!"), (false));
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityIllusionIllager(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if (((4 < (rouedelachance)) && ((rouedelachance) < 5))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("5!"), (false));
			}
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemTrolliumGem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (((5 < (rouedelachance)) && ((rouedelachance) < 6))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("6!"), (false));
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				IBlockState _bs = Blocks.FLOWING_LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((6 < (rouedelachance)) && ((rouedelachance) < 7))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("7!"), (false));
			}
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
		}
		if (((7 < (rouedelachance)) && ((rouedelachance) < 8))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("8!"), (false));
			}
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 5, (int) 5));
		}
		if (((8 < (rouedelachance)) && ((rouedelachance) < 9))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("9!"), (false));
			}
			entity.attackEntityFrom(DamageSource.MAGIC, (float) 30);
		}
		if (((9 < (rouedelachance)) && ((rouedelachance) < 10))) {
			if (entity instanceof EntityPlayer && !entity.world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("10?"), (false));
			}
			entity.attackEntityFrom(DamageSource.MAGIC, (float) 30);
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 5, (int) 5));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				IBlockState _bs = Blocks.FLOWING_LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemTrolliumGem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityIllusionIllager(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity)
						.addPotionEffect(new PotionEffect(PotionCHHHHHEEEEEEEEEEEAAAAAAAAAAAAATTTTTTTTTTT.potion, (int) 60, (int) 1, (true), (true)));
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, (int) 60, (int) 1, (false), (false)));
		}
	}
}
