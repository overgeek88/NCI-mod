
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class ItemDivineBloodline extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:divine_bloodline")
	public static final Item block = null;
	public ItemDivineBloodline(ElementsClubInfoMod instance) {
		super(instance, 521);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:divine_bloodline", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("divine_bloodline", ElementsClubInfoMod.sounds.get(new ResourceLocation("club_info:divine")));
			setUnlocalizedName("divine_bloodline");
			setRegistryName("divine_bloodline");
			setCreativeTab(TabNationCI.tab);
		}
	}
}
