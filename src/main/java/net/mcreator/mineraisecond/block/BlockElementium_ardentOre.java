
package net.mcreator.mineraisecond.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.mineraisecond.world.WorldWarpmine;
import net.mcreator.mineraisecond.item.ItemElementium_ardentIngot;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Random;

@ElementsClubInfoMod.ModElement.Tag
public class BlockElementium_ardentOre extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:elementium_ardentore")
	public static final Block block = null;
	public BlockElementium_ardentOre(ElementsClubInfoMod instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("elementium_ardentore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("club_info:elementium_ardentore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (dimID == WorldWarpmine.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("desert")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("desert_hills")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("savanna")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("savanna_rock")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_desert")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_savanna")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_savanna_rock")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_mesa")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_mesa_rock")))
			biomeCriteria = true;
		if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("mutated_mesa_clear_rock")))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		for (int i = 0; i < 2; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(13) + 1;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 3, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == Blocks.STONE.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("elementium_ardentore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 2);
			setHardness(15F);
			setResistance(18.11949159194239F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabNationCI.tab);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemElementium_ardentIngot.block, (int) (1)));
		}
	}
}
