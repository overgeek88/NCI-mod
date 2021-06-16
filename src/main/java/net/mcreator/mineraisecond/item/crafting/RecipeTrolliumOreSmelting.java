
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemTrolliumGem;
import net.mcreator.mineraisecond.block.BlockTrolliumOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeTrolliumOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeTrolliumOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 81);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockTrolliumOre.block, (int) (1)), new ItemStack(ItemTrolliumGem.block, (int) (1)), 0.07F);
	}
}
