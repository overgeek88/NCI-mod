
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.mineraisecond.procedure.ProcedureUraniumPickaxeToolInInventoryTick;
import net.mcreator.mineraisecond.procedure.ProcedureAaaaaaaaaaaaa;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class ItemUraniumPickaxe extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:uraniumpickaxe")
	public static final Item block = null;
	public ItemUraniumPickaxe(ElementsClubInfoMod instance) {
		super(instance, 410);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("URANIUMPICKAXE", 2, 216, 6f, -2f, 13)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 2);
				return ret.keySet();
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, EntityLivingBase entity, EntityLivingBase entity2) {
				super.hitEntity(itemstack, entity, entity2);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureAaaaaaaaaaaaa.executeProcedure($_dependencies);
				}
				return true;
			}

			@Override
			public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean par5) {
				super.onUpdate(itemstack, world, entity, slot, par5);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureUraniumPickaxeToolInInventoryTick.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("uraniumpickaxe").setRegistryName("uraniumpickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("club_info:uraniumpickaxe", "inventory"));
	}
}
