
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.procedure.ProcedureElementiumardentArmorEvenementDeTickDuPlastron;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemElementium_ardentArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:elementium_ardentarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:elementium_ardentarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:elementium_ardentarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:elementium_ardentarmorboots")
	public static final Item boots = null;
	public ItemElementium_ardentArmor(ElementsClubInfoMod instance) {
		super(instance, 114);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ELEMENTIUM_ARDENTARMOR", "club_info:elementium_ardent", 42,
				new int[]{5, 8, 10, 5}, 32,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("elementium_ardentarmorhelmet")
				.setRegistryName("elementium_ardentarmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureElementiumardentArmorEvenementDeTickDuPlastron.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("elementium_ardentarmorbody").setRegistryName("elementium_ardentarmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("elementium_ardentarmorlegs")
				.setRegistryName("elementium_ardentarmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("elementium_ardentarmorboots")
				.setRegistryName("elementium_ardentarmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:elementium_ardentarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:elementium_ardentarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:elementium_ardentarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:elementium_ardentarmorboots", "inventory"));
	}
}
