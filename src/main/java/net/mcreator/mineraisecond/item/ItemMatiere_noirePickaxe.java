
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Set;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemMatiere_noirePickaxe extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:matiere_noirepickaxe")
	public static final Item block = null;
	public ItemMatiere_noirePickaxe(ElementsClubInfoMod instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("MATIERE_NOIREPICKAXE", 5, 3198, 25f, 2f, 105)) {
			{
				this.attackSpeed = -2.9f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("matiere_noirepickaxe").setRegistryName("matiere_noirepickaxe").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:matiere_noirepickaxe", "inventory"));
	}
}
