
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class ItemElementium_BlizaroArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:elementium_blizaroarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:elementium_blizaroarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:elementium_blizaroarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:elementium_blizaroarmorboots")
	public static final Item boots = null;
	public ItemElementium_BlizaroArmor(ElementsClubInfoMod instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ELEMENTIUM_BLIZAROARMOR", "club_info:elementium_blizaro", 15,
				new int[]{2, 6, 5, 2}, 9, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")),
				0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("elementium_blizaroarmorhelmet")
				.setRegistryName("elementium_blizaroarmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("elementium_blizaroarmorbody")
				.setRegistryName("elementium_blizaroarmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("elementium_blizaroarmorlegs")
				.setRegistryName("elementium_blizaroarmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("elementium_blizaroarmorboots")
				.setRegistryName("elementium_blizaroarmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:elementium_blizaroarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:elementium_blizaroarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:elementium_blizaroarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:elementium_blizaroarmorboots", "inventory"));
	}
}
