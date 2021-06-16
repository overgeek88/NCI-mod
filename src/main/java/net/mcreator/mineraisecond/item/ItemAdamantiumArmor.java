
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
public class ItemAdamantiumArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:adamantiumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:adamantiumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:adamantiumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:adamantiumarmorboots")
	public static final Item boots = null;
	public ItemAdamantiumArmor(ElementsClubInfoMod instance) {
		super(instance, 139);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ADAMANTIUMARMOR", "club_info:adamantium", 46, new int[]{10, 20, 25, 10}, 42,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("adamantiumarmorhelmet")
				.setRegistryName("adamantiumarmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("adamantiumarmorbody")
				.setRegistryName("adamantiumarmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("adamantiumarmorlegs")
				.setRegistryName("adamantiumarmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("adamantiumarmorboots")
				.setRegistryName("adamantiumarmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:adamantiumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:adamantiumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:adamantiumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:adamantiumarmorboots", "inventory"));
	}
}
