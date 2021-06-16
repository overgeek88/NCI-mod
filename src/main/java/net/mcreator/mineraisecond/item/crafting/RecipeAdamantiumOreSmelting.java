
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemAdamantiumGem;
import net.mcreator.mineraisecond.block.BlockTrolliumOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeAdamantiumOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeAdamantiumOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 128);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockTrolliumOre.block, (int) (1)), new ItemStack(ItemAdamantiumGem.block, (int) (1)), 7F);
	}
}
