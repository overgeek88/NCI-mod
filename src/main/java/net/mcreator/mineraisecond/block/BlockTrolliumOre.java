
package net.mcreator.mineraisecond.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Container;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.Block;

import net.mcreator.mineraisecond.world.WorldWarpmine;
import net.mcreator.mineraisecond.item.ItemTrolliumGem;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Random;

@ElementsClubInfoMod.ModElement.Tag
public class BlockTrolliumOre extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:trolliumore")
	public static final Block block = null;
	public BlockTrolliumOre(ElementsClubInfoMod instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("trolliumore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEntityCustom.class, "club_info:tileentitytrolliumore");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("club_info:trolliumore", "inventory"));
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
		for (int i = 0; i < 5; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(255) + 1;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 5, new com.google.common.base.Predicate<IBlockState>() {
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
	public static class BlockCustom extends Block implements ITileEntityProvider {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("trolliumore");
			setSoundType(SoundType.STONE);
			setHardness(0.3F);
			setResistance(0.7924465962305567F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabNationCI.tab);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemTrolliumGem.block, (int) (1)));
		}

		@Override
		public TileEntity createNewTileEntity(World worldIn, int meta) {
			return new TileEntityCustom();
		}

		@Override
		public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, worldIn, pos, eventID, eventParam);
			TileEntity tileentity = worldIn.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			return EnumBlockRenderType.MODEL;
		}

		@Override
		public void breakBlock(World world, BlockPos pos, IBlockState state) {
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof TileEntityCustom)
				InventoryHelper.dropInventoryItems(world, pos, (TileEntityCustom) tileentity);
			world.removeTileEntity(pos);
			super.breakBlock(world, pos, state);
		}

		@Override
		public boolean hasComparatorInputOverride(IBlockState state) {
			return true;
		}

		@Override
		public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityCustom)
				return Container.calcRedstoneFromInventory((TileEntityCustom) tileentity);
			else
				return 0;
		}
	}

	public static class TileEntityCustom extends TileEntityLockableLoot {
		private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
		@Override
		public int getSizeInventory() {
			return 9;
		}

		@Override
		public boolean isEmpty() {
			for (ItemStack itemstack : this.stacks)
				if (!itemstack.isEmpty())
					return false;
			return true;
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return true;
		}

		@Override
		public ItemStack getStackInSlot(int slot) {
			return stacks.get(slot);
		}

		@Override
		public String getName() {
			return "container.trolliumore";
		}

		@Override
		public void readFromNBT(NBTTagCompound compound) {
			super.readFromNBT(compound);
			this.stacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
			if (!this.checkLootAndRead(compound))
				ItemStackHelper.loadAllItems(compound, this.stacks);
		}

		@Override
		public NBTTagCompound writeToNBT(NBTTagCompound compound) {
			super.writeToNBT(compound);
			if (!this.checkLootAndWrite(compound))
				ItemStackHelper.saveAllItems(compound, this.stacks);
			return compound;
		}

		@Override
		public SPacketUpdateTileEntity getUpdatePacket() {
			return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
		}

		@Override
		public NBTTagCompound getUpdateTag() {
			return this.writeToNBT(new NBTTagCompound());
		}

		@Override
		public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
			this.readFromNBT(pkt.getNbtCompound());
		}

		@Override
		public void handleUpdateTag(NBTTagCompound tag) {
			this.readFromNBT(tag);
		}

		@Override
		public int getInventoryStackLimit() {
			return 13;
		}

		@Override
		public String getGuiID() {
			return "club_info:trolliumore";
		}

		@Override
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			this.fillWithLoot(playerIn);
			return new ContainerChest(playerInventory, this, playerIn);
		}

		@Override
		protected NonNullList<ItemStack> getItems() {
			return this.stacks;
		}
	}
}
