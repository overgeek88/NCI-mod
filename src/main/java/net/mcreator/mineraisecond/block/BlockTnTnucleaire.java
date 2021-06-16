
package net.mcreator.mineraisecond.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.mineraisecond.procedure.ProcedureTnTnucleaireRedstoneOn;
import net.mcreator.mineraisecond.procedure.ProcedureTnTnucleaireOnBlockRightClicked;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class BlockTnTnucleaire extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:tntnucleaire")
	public static final Block block = null;
	public BlockTnTnucleaire(ElementsClubInfoMod instance) {
		super(instance, 431);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("tntnucleaire"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("club_info:tntnucleaire", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("tntnucleaire");
			setSoundType(SoundType.GROUND);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabNationCI.tab);
		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureTnTnucleaireRedstoneOn.executeProcedure($_dependencies);
				}
			} else {
			}
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureTnTnucleaireOnBlockRightClicked.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
