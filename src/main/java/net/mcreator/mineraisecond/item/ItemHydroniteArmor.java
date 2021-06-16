
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

import net.mcreator.mineraisecond.procedure.ProcedureHydroniteArmorLeggingsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureHydroniteArmorHelmetTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureHydroniteArmorBootsTickEvent;
import net.mcreator.mineraisecond.procedure.ProcedureHydroniteArmorBodyTickEvent;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemHydroniteArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:hydronitearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:hydronitearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:hydronitearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:hydronitearmorboots")
	public static final Item boots = null;
	public ItemHydroniteArmor(ElementsClubInfoMod instance) {
		super(instance, 293);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("HYDRONITEARMOR", "club_info:hydronite", 43, new int[]{3, 6, 8, 3}, 45,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 3f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureHydroniteArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hydronitearmorhelmet").setRegistryName("hydronitearmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureHydroniteArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hydronitearmorbody").setRegistryName("hydronitearmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureHydroniteArmorLeggingsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hydronitearmorlegs").setRegistryName("hydronitearmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureHydroniteArmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hydronitearmorboots").setRegistryName("hydronitearmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:hydronitearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:hydronitearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:hydronitearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:hydronitearmorboots", "inventory"));
	}
}
