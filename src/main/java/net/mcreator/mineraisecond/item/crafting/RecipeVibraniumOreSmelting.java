
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemVibraniumIngot;
import net.mcreator.mineraisecond.block.BlockVibraniumOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeVibraniumOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeVibraniumOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 312);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockVibraniumOre.block, (int) (1)), new ItemStack(ItemVibraniumIngot.block, (int) (1)),
				3.8499999999999996F);
	}
}
