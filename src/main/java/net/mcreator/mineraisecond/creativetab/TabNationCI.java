
package net.mcreator.mineraisecond.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.mineraisecond.item.ItemAdamantiumGem;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class TabNationCI extends ElementsClubInfoMod.ModElement {
	public TabNationCI(ElementsClubInfoMod instance) {
		super(instance, 395);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabnationci") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemAdamantiumGem.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
