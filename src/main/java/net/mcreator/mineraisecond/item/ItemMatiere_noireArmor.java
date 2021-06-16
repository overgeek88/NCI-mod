
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

import net.mcreator.mineraisecond.procedure.ProcedureMatierenoireArmorBodyTickEvent;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemMatiere_noireArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:matiere_noirearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:matiere_noirearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:matiere_noirearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:matiere_noirearmorboots")
	public static final Item boots = null;
	public ItemMatiere_noireArmor(ElementsClubInfoMod instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("MATIERE_NOIREARMOR", "club_info:matiere_noire", 10, new int[]{2, 5, 6, 2}, 34,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("matiere_noirearmorhelmet")
				.setRegistryName("matiere_noirearmorhelmet").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureMatierenoireArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("matiere_noirearmorbody").setRegistryName("matiere_noirearmorbody").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("matiere_noirearmorlegs")
				.setRegistryName("matiere_noirearmorlegs").setCreativeTab(TabNationCI.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("matiere_noirearmorboots")
				.setRegistryName("matiere_noirearmorboots").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("club_info:matiere_noirearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("club_info:matiere_noirearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("club_info:matiere_noirearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:matiere_noirearmorboots", "inventory"));
	}
}
