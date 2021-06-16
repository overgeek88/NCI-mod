
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

import net.mcreator.mineraisecond.procedure.ProcedureVisionnocturneEvenementDeTickDuCasque;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemVisionnocturne extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:visionnocturnehelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:visionnocturnebody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:visionnocturnelegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:visionnocturneboots")
	public static final Item boots = null;
	public ItemVisionnocturne(ElementsClubInfoMod instance) {
		super(instance, 525);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("VISIONNOCTURNE", "club_info:diamond_", 5, new int[]{0, 0, 0, 1}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("club_info:piou")), 0f);
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
					ProcedureVisionnocturneEvenementDeTickDuCasque.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("visionnocturnehelmet").setRegistryName("visionnocturnehelmet").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:visionnocturnehelmet", "inventory"));
	}
}
