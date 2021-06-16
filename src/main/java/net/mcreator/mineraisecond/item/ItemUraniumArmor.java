
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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.procedure.ProcedureUraniumArmorLeggingsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureUraniumArmorHelmetTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureUraniumArmorBootsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureUraniumArmorBodyTickEvent;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemUraniumArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:uraniumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:uraniumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:uraniumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:uraniumarmorboots")
	public static final Item boots = null;
	public ItemUraniumArmor(ElementsClubInfoMod instance) {
		super(instance, 420);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("URANIUMARMOR", "club_info:uranium", 14, new int[]{2, 5, 5, 2}, 8,
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
					ProcedureUraniumArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("uraniumarmorhelmet").setRegistryName("uraniumarmorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureUraniumArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("uraniumarmorbody").setRegistryName("uraniumarmorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureUraniumArmorLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("uraniumarmorlegs").setRegistryName("uraniumarmorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureUraniumArmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("uraniumarmorboots").setRegistryName("uraniumarmorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:uraniumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:uraniumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:uraniumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:uraniumarmorboots", "inventory"));
	}
}
