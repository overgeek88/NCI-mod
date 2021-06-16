
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Set;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemMyrthilShovel extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:myrthilshovel")
	public static final Item block = null;
	public ItemMyrthilShovel(ElementsClubInfoMod instance) {
		super(instance, 158);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("MYRTHILSHOVEL", 4, 1888, 15f, 5f, 31)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 4);
				return ret.keySet();
			}
		}.setUnlocalizedName("myrthilshovel").setRegistryName("myrthilshovel").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:myrthilshovel", "inventory"));
	}
}
