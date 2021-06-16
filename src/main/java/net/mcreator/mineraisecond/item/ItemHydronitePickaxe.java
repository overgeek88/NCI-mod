
package net.mcreator.mineraisecond.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.procedure.ProcedureHydronitePickaxeToolInInventoryTick;
import net.mcreator.mineraisecond.creativetab.TabNationCI;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemHydronitePickaxe extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:hydronitepickaxe")
	public static final Item block = null;
	public ItemHydronitePickaxe(ElementsClubInfoMod instance) {
		super(instance, 283);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("HYDRONITEPICKAXE", 10, 2072, 16f, 6f, 35)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 10);
				return ret.keySet();
			}

			@Override
			public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean par5) {
				super.onUpdate(itemstack, world, entity, slot, par5);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("itemstack", itemstack);
					ProcedureHydronitePickaxeToolInInventoryTick.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("hydronitepickaxe").setRegistryName("hydronitepickaxe").setCreativeTab(TabNationCI.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:hydronitepickaxe", "inventory"));
	}
}
