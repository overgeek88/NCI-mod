
package net.mcreator.mineraisecond.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.mineraisecond.procedure.ProcedurePetroleUpdateTick;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class BlockPetrole extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:petrole")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("club_info:petrole")
	public static final Item item = null;
	private Fluid fluid;
	public BlockPetrole(ElementsClubInfoMod instance) {
		super(instance, 354);
		fluid = new Fluid("petrole", new ResourceLocation("club_info:blocks/stil_petrol"), new ResourceLocation("club_info:blocks/flow_petrol"))
				.setLuminosity(0).setDensity(1000).setViscosity(2000).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {
			@Override
			public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
				super.updateTick(world, pos, state, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					ProcedurePetroleUpdateTick.executeProcedure($_dependencies);
				}
				world.scheduleUpdate(new BlockPos(x, y, z), this, this.tickRate(world));
			}
		}.setUnlocalizedName("petrole").setRegistryName("petrole"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("petrole"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("club_info:petrole", "petrole");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("club_info:petrole", "petrole");
			}
		});
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		int i = chunkX + random.nextInt(16) + 8;
		int j = random.nextInt(256);
		int k = chunkZ + random.nextInt(16) + 8;
		new WorldGenLakes(block).generate(world, random, new BlockPos(i, j, k));
	}
}
