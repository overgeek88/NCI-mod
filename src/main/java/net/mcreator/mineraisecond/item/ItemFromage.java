
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class ItemFromage extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:fromage")
	public static final Item block = null;
	public ItemFromage(ElementsClubInfoMod instance) {
		super(instance, 70);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:fromage", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(2, 0.1f, false);
			setUnlocalizedName("fromage");
			setRegistryName("fromage");
			setCreativeTab(TabNationCI.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
