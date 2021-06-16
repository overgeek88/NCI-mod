
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

import net.mcreator.mineraisecond.procedure.ProcedurePegaseArmorBootsTickEvent;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemPegaseArmor extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:pegasearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:pegasearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:pegasearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:pegasearmorboots")
	public static final Item boots = null;
	public ItemPegaseArmor(ElementsClubInfoMod instance) {
		super(instance, 271);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PEGASEARMOR", "club_info:pegase", 8, new int[]{1, 3, 3, 1}, 5,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedurePegaseArmorBootsTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("pegasearmorboots").setRegistryName("pegasearmorboots").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:pegasearmorboots", "inventory"));
	}
}
