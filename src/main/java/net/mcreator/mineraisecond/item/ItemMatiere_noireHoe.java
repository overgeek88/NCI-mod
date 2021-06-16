
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
public class ItemMatiere_noireHoe extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:matiere_noirehoe")
	public static final Item block = null;
	public ItemMatiere_noireHoe(ElementsClubInfoMod instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("MATIERE_NOIREHOE", 5, 3198, 25f, 0.1f, 30)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("matiere_noirehoe").setRegistryName("matiere_noirehoe").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:matiere_noirehoe", "inventory"));
	}
}
