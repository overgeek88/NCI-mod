
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemElementium_BlizaroIngot;
import net.mcreator.mineraisecond.block.BlockElementium_BlizaroOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeElementium_BlizaroOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeElementium_BlizaroOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 27);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockElementium_BlizaroOre.block, (int) (1)),
				new ItemStack(ItemElementium_BlizaroIngot.block, (int) (1)), 0.7F);
	}
}
