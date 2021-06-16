
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Set;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemTerreHoe extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:terrehoe")
	public static final Item block = null;
	public ItemTerreHoe(ElementsClubInfoMod instance) {
		super(instance, 213);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("TERREHOE", 0, 26, 2f, 0f, 3)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 0);
				return ret.keySet();
			}
		}.setUnlocalizedName("terrehoe").setRegistryName("terrehoe").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:terrehoe", "inventory"));
	}
}
