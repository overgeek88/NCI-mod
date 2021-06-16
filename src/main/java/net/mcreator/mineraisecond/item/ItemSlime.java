
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
public class ItemSlime extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:slimehelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("club_info:slimebody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("club_info:slimelegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("club_info:slimeboots")
	public static final Item boots = null;
	public ItemSlime(ElementsClubInfoMod instance) {
		super(instance, 478);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SLIME", "club_info:uranium", 2, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("slimeboots").setRegistryName("slimeboots")
				.setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("club_info:slimeboots", "inventory"));
	}
}
