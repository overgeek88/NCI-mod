
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

import net.mcreator.mineraisecond.procedure.ProcedureElementiumaeroArmorLeggingsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureElementiumaeroArmorBootsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureElementiumaeroArmorBodyTickEvent;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemElementium_aeroArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:elementium_aeroarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:elementium_aeroarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:elementium_aeroarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:elementium_aeroarmorboots")
	public static final Item boots = null;
	public ItemElementium_aeroArmor(ElementsClubInfoMod instance) {
		super(instance, 345);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("ELEMENTIUM_AEROARMOR", "club_info:elementium_aero", 40, new int[]{2, 5, 6, 2},
				38, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("elementium_aeroarmorhelmet")
				.setRegistryName("elementium_aeroarmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureElementiumaeroArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("elementium_aeroarmorbody").setRegistryName("elementium_aeroarmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureElementiumaeroArmorLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("elementium_aeroarmorlegs").setRegistryName("elementium_aeroarmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureElementiumaeroArmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("elementium_aeroarmorboots").setRegistryName("elementium_aeroarmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:elementium_aeroarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:elementium_aeroarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:elementium_aeroarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:elementium_aeroarmorboots", "inventory"));
	}
}
