
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.List;

@ElementsClubInfoMod.ModElement.Tag
public class ItemCaptainshield extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:captainshield")
	public static final Item block = null;
	public ItemCaptainshield(ElementsClubInfoMod instance) {
		super(instance, 328);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:captainshield", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(10);
			maxStackSize = 64;
			setUnlocalizedName("captainshield");
			setRegistryName("captainshield");
			setCreativeTab(TabNationCI.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 20;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 99999;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 2F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("Bouclier ayant appartenu a un soldat de la 2e grande guerre");
		}
	}
}
