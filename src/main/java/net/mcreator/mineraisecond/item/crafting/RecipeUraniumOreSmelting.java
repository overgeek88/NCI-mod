
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemUraniumIngot;
import net.mcreator.mineraisecond.block.BlockUraniumOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeUraniumOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeUraniumOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 409);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockUraniumOre.block, (int) (1)), new ItemStack(ItemUraniumIngot.block, (int) (1)), 0.63F);
	}
}
