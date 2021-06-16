
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

import net.mcreator.mineraisecond.procedure.ProcedureObsidieneArmorLeggingsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureObsidieneArmorHelmetTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureObsidieneArmorBootsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureObsidieneArmorBodyTickEvent;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemObsidieneArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:obsidienearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:obsidienearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:obsidienearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:obsidienearmorboots")
	public static final Item boots = null;
	public ItemObsidieneArmor(ElementsClubInfoMod instance) {
		super(instance, 195);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("OBSIDIENEARMOR", "club_info:obsidiene", 83, new int[]{3, 7, 8, 3}, 50,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureObsidieneArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("obsidienearmorhelmet").setRegistryName("obsidienearmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureObsidieneArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("obsidienearmorbody").setRegistryName("obsidienearmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureObsidieneArmorLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("obsidienearmorlegs").setRegistryName("obsidienearmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureObsidieneArmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("obsidienearmorboots").setRegistryName("obsidienearmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:obsidienearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:obsidienearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:obsidienearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:obsidienearmorboots", "inventory"));
	}
}
